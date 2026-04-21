import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    // ================= META =================
    static class Meta {
        String pattern, difficulty, tc;

        Meta(String pattern, String difficulty, String tc) {
            this.pattern = pattern;
            this.difficulty = difficulty;
            this.tc = tc;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) throws IOException {

        File repo = new File(".");
        StringBuilder md = new StringBuilder();

        md.append("# 📘 DSA Practice Repository\n\n");
        md.append("Auto-generated index of problems (Java).\n\n");

        File[] dirs = repo.listFiles(File::isDirectory);
        if (dirs == null) return;

        Arrays.sort(dirs, Comparator.comparing(File::getName));

        for (File dir : dirs) {

            String name = dir.getName();

            if (name.startsWith(".") || name.equals("node_modules") || name.equals(".github"))
                continue;

            File[] files = dir.listFiles((d, f) -> f.endsWith(".java"));
            if (files == null || files.length == 0) continue;

            Arrays.sort(files, Comparator.comparing(File::getName));

            md.append("## 📂 ").append(name).append("\n\n");
            md.append("| Problem | Code | Explanation | Pattern | Difficulty | TC |\n");
            md.append("|--------|------|------------|---------|------------|----|\n");

            for (File f : files) {

                String problem = f.getName().replace(".java", "");
                String path = "./" + name + "/" + f.getName();

                String code = new String(Files.readAllBytes(f.toPath()));

                Meta meta = analyzeCode(code);

                File explanation = new File(dir, problem + ".md");

                md.append("| ")
                        .append(problem)
                        .append(" | [View Code](")
                        .append(path)
                        .append(") | ");

                if (explanation.exists()) {
                    String expPath = "./" + name + "/" + problem + ".md";
                    md.append("[View Notes](").append(expPath).append(")");
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

        md.append("---\n");
        md.append("⚡ Auto-generated on every push using GitHub Actions.\n");

        Files.write(Paths.get("README.md"), md.toString().getBytes());

        System.out.println("✅ README updated!");
    }

    // ================= GEMINI AI =================

    public static Meta analyzeCode(String code) {
        try {
            String apiKey = System.getenv("GEMINI_API_KEY");

            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("❌ GEMINI KEY MISSING");
                return new Meta("Unknown", "Unknown", "Unknown");
            }

            String prompt = """
You MUST return ONLY valid JSON.

Format:
{"pattern":"...","difficulty":"...","tc":"..."}

Rules:
- pattern: short (DFS, BFS, Stack, Tree DP)
- difficulty: Easy/Medium/Hard
- tc: Big-O notation
- NO explanation

Code:
""" + code;

            String requestBody = "{\n" +
                    "\"contents\": [{\n" +
                    "  \"parts\": [{\"text\": " + escape(prompt) + "}]\n" +
                    "}]\n" +
                    "}";

            URL url = new URL(
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + apiKey
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestBody.getBytes());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            System.out.println("🔥 GEMINI RAW: " + response);

            String content = extractGeminiContent(response.toString());

            System.out.println("✅ GEMINI TEXT: " + content);

            return new Meta(
                    extractField(content, "pattern"),
                    extractField(content, "difficulty"),
                    extractField(content, "tc")
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new Meta("Error", "Error", "Error");
        }
    }

    // ================= HELPERS =================

    private static String escape(String text) {
        return "\"" + text.replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    private static String extractGeminiContent(String json) {
        try {
            int start = json.indexOf("\"text\":\"");
            if (start == -1) return "";

            start += 8;

            int end = json.indexOf("\"", start);
            String content = json.substring(start, end);

            return content.replace("\\n", "\n").replace("\\\"", "\"");

        } catch (Exception e) {
            return "";
        }
    }

    private static String extractField(String json, String key) {
        try {
            int i = json.indexOf("\"" + key + "\"");
            if (i == -1) return "Unknown";

            int start = json.indexOf(":", i) + 1;

            while (start < json.length() &&
                    (json.charAt(start) == ' ' || json.charAt(start) == '"')) {
                start++;
            }

            int end = start;
            while (end < json.length() &&
                    json.charAt(end) != '"' &&
                    json.charAt(end) != ',' &&
                    json.charAt(end) != '}') {
                end++;
            }

            return json.substring(start, end).trim();

        } catch (Exception e) {
            return "Unknown";
        }
    }
}
