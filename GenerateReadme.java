import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    // ================= META =================
    static class Meta {
        String pattern, difficulty, tc;

        Meta(String p, String d, String t) {
            pattern = p;
            difficulty = d;
            tc = t;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) throws IOException {

        File repo = new File(".");
        StringBuilder md = new StringBuilder();

        md.append("# 📘 DSA Practice Repository\n\n");

        File[] dirs = repo.listFiles(File::isDirectory);
        if (dirs == null) return;

        Arrays.sort(dirs, Comparator.comparing(File::getName));

        for (File dir : dirs) {

            String name = dir.getName();
            if (name.startsWith(".") || name.equals(".github")) continue;

            File[] files = dir.listFiles((d, f) -> f.endsWith(".java"));
            if (files == null || files.length == 0) continue;

            md.append("## 📂 ").append(name).append("\n\n");
            md.append("| Problem | Code | Explanation | Pattern | Difficulty | TC |\n");
            md.append("|--------|------|------------|---------|------------|----|\n");

            for (File f : files) {

                String problem = f.getName().replace(".java", "");
                String code = new String(Files.readAllBytes(f.toPath()));

                System.out.println("\n==============================");
                System.out.println("Processing: " + problem);

                Meta meta = analyze(code);

                md.append("| ")
                  .append(problem)
                  .append(" | [View Code](./").append(name).append("/").append(f.getName()).append(") | ");

                File exp = new File(dir, problem + ".md");

                if (exp.exists()) {
                    md.append("[View Notes](./").append(name).append("/").append(problem).append(".md)");
                } else {
                    md.append("—");
                }

                md.append(" | ")
                  .append(meta.pattern)
                  .append(" | ")
                  .append(meta.difficulty)
                  .append(" | ")
                  .append(meta.tc)
                  .append(" |\n");
            }

            md.append("\n");
        }

        Files.write(Paths.get("README.md"), md.toString().getBytes());

        System.out.println("\n✅ README updated!");
    }

    // ================= OPENAI =================

    public static Meta analyze(String code) {

        try {
            String apiKey = System.getenv("OPENAI_API_KEY");

            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("❌ ERROR: API KEY MISSING");
                return new Meta("Unknown", "Unknown", "Unknown");
            }

            String prompt = """
Return ONLY JSON:

{"pattern":"...","difficulty":"...","tc":"..."}

Code:
""" + code;

            String body = "{\n" +
                    "\"model\": \"gpt-5.3\",\n" +
                    "\"input\": " + escape(prompt) + "\n" +
                    "}";

            HttpURLConnection conn = (HttpURLConnection)
                    new URL("https://api.openai.com/v1/responses").openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.getOutputStream().write(body.getBytes());

            int status = conn.getResponseCode();
            System.out.println("🔎 STATUS CODE: " + status);

            BufferedReader br;

            if (status >= 200 && status < 300) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                System.out.println("❌ ERROR RESPONSE:");
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder res = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line);
            }

            System.out.println("🔥 FULL RESPONSE:");
            System.out.println(res.toString());

            if (status < 200 || status >= 300) {
                return new Meta("Error", "Error", "Error");
            }

            String content = extractResponse(res.toString());

            System.out.println("✅ EXTRACTED CONTENT:");
            System.out.println(content);

            return new Meta(
                    get(content, "pattern"),
                    get(content, "difficulty"),
                    get(content, "tc")
            );

        } catch (Exception e) {
            System.out.println("💥 EXCEPTION OCCURRED:");
            e.printStackTrace();
            return new Meta("Error", "Error", "Error");
        }
    }

    // ================= HELPERS =================

    static String escape(String s) {
        return "\"" + s.replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    static String extractResponse(String json) {
        try {
            String marker = "\"output_text\":\"";
            int start = json.indexOf(marker);

            if (start == -1) return "";

            start += marker.length();
            int end = json.indexOf("\"", start);

            return json.substring(start, end)
                    .replace("\\n", "\n")
                    .replace("\\\"", "\"");

        } catch (Exception e) {
            return "";
        }
    }

    static String get(String json, String key) {
        int i = json.indexOf("\"" + key + "\"");
        if (i == -1) return "Unknown";

        int s = json.indexOf(":", i) + 1;
        int e = json.indexOf(",", s);
        if (e == -1) e = json.indexOf("}", s);

        return json.substring(s, e).replace("\"", "").trim();
    }
}
