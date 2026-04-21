import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    static class Meta {
        String pattern, difficulty, tc;

        Meta(String p, String d, String t) {
            pattern = p;
            difficulty = d;
            tc = t;
        }
    }

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

        System.out.println("README updated!");
    }

    // ================= OPENAI =================

    public static Meta analyze(String code) {

        try {
            String apiKey = System.getenv("OPENAI_API_KEY");

            if (apiKey == null) {
                System.out.println("❌ NO API KEY");
                return new Meta("Unknown", "Unknown", "Unknown");
            }

            String prompt = """
Return ONLY JSON (no text):

{"pattern":"...","difficulty":"...","tc":"..."}

Code:
""" + code;

            String body = "{\n" +
                    "\"model\":\"gpt-5.3\",\n" +
                    "\"messages\":[{\"role\":\"user\",\"content\":" + esc(prompt) + "}]\n" +
                    "}";

            HttpURLConnection conn = (HttpURLConnection)
                    new URL("https://api.openai.com/v1/chat/completions").openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.getOutputStream().write(body.getBytes());

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            StringBuilder res = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) res.append(line);

            System.out.println("RAW: " + res);

            String content = extract(res.toString());

            return new Meta(
                    get(content, "pattern"),
                    get(content, "difficulty"),
                    get(content, "tc")
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new Meta("Error", "Error", "Error");
        }
    }

    // ================= HELPERS =================

    static String esc(String s) {
        return "\"" + s.replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    static String extract(String json) {
        int i = json.indexOf("\"content\":\"") + 11;
        int j = json.lastIndexOf("\"");
        return json.substring(i, j).replace("\\n", "\n").replace("\\\"", "\"");
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
