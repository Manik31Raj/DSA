import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    // Meta class
    static class Meta {
        String pattern, difficulty, tc;

        Meta(String pattern, String difficulty, String tc) {
            this.pattern = pattern;
            this.difficulty = difficulty;
            this.tc = tc;
        }
    }

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

            // skip unwanted folders
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

        System.out.println("README.md updated!");
    }

    // ================= AI ANALYZER =================

    public static Meta analyzeCode(String code) {

        try {
            String apiKey = System.getenv("OPENAI_API_KEY");

            if (apiKey == null || apiKey.isEmpty()) {
                return new Meta("Unknown", "Unknown", "Unknown");
            }

            String prompt = """
You are a DSA expert.

Analyze the following Java code and return ONLY valid JSON:

{
  "pattern": "",
  "difficulty": "",
  "tc": ""
}

Rules:
- pattern: short (e.g., DFS, BFS, Stack, Tree DP)
- difficulty: Easy / Medium / Hard
- tc: Big-O notation
- DO NOT add explanations
- DO NOT add extra text

Code:
""" + code;

            String requestBody = "{\n" +
                    "\"model\": \"gpt-5.3\",\n" +
                    "\"messages\": [\n" +
                    "  {\"role\": \"user\", \"content\": " + escape(prompt) + "}\n" +
                    "]\n" +
                    "}";

            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
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

            String content = extractContent(response.toString());

            return new Meta(
                    extractField(content, "pattern"),
                    extractField(content, "difficulty"),
                    extractField(content, "tc")
            );

        } catch (Exception e) {
            return new Meta("Unknown", "Unknown", "Unknown");
        }
    }

    // ================= HELPERS =================

    private static String escape(String text) {
        return "\"" + text.replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    private static String extractContent(String json) {
        int start = json.indexOf("\"content\":\"") + 11;
        int end = json.indexOf("\"", start);
        return json.substring(start, end).replace("\\n", "\n");
    }

    private static String extractField(String json, String key) {
        int i = json.indexOf("\"" + key + "\"");
        if (i == -1) return "Unknown";

        int start = json.indexOf(":", i) + 1;
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);

        return json.substring(start, end)
                .replace("\"", "")
                .trim();
    }
}
