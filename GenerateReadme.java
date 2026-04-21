import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

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

                Meta meta = analyzeCodeAI(code);

                // fallback if AI fails
                if (meta.pattern.equals("—")) {
                    meta = analyzeCodeHeuristic(code);
                }

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

        System.out.println("README updated!");
    }

    // ================= AI ANALYZER =================

    public static Meta analyzeCodeAI(String code) {
        try {
            String apiKey = System.getenv("OPENAI_API_KEY");
            if (apiKey == null) return new Meta("—", "—", "—");

            String prompt = "Analyze this Java DSA code and return ONLY JSON:\n" +
                    "{ \"pattern\": \"\", \"difficulty\": \"\", \"tc\": \"\" }\n\nCode:\n" + code;

            String body = "{\n" +
                    "\"model\": \"gpt-5.3\",\n" +
                    "\"messages\": [{\"role\":\"user\",\"content\":" + escape(prompt) + "}]\n" +
                    "}";

            HttpURLConnection conn = (HttpURLConnection)
                    new URL("https://api.openai.com/v1/chat/completions").openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.getOutputStream().write(body.getBytes());

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder res = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) res.append(line);

            String content = extract(res.toString());

            return new Meta(
                    get(content, "pattern"),
                    get(content, "difficulty"),
                    get(content, "tc")
            );

        } catch (Exception e) {
            return new Meta("—", "—", "—");
        }
    }

    // ================= HEURISTIC FALLBACK =================

    public static Meta analyzeCodeHeuristic(String code) {

        code = code.toLowerCase();

        String pattern = "General";
        String difficulty = "Medium";
        String tc = "O(N)";

        if (code.contains("stack")) pattern = "Stack";
        else if (code.contains("queue")) pattern = "BFS";
        else if (code.contains("left") && code.contains("right")) pattern = "DFS";

        if (code.contains("priorityqueue")) {
            pattern = "BFS + PQ";
            tc = "O(N log N)";
            difficulty = "Hard";
        }

        if (code.contains("treemap")) {
            pattern = "BFS + Map";
            tc = "O(N log N)";
            difficulty = "Hard";
        }

        return new Meta(pattern, difficulty, tc);
    }

    // ================= HELPERS =================

    private static String escape(String s) {
        return "\"" + s.replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    private static String extract(String json) {
        int i = json.indexOf("\"content\":\"") + 11;
        int j = json.indexOf("\"", i);
        return json.substring(i, j).replace("\\n", "\n");
    }

    private static String get(String json, String key) {
        int i = json.indexOf("\"" + key + "\"");
        if (i == -1) return "—";
        int s = json.indexOf(":", i) + 1;
        int e = json.indexOf(",", s);
        if (e == -1) e = json.indexOf("}", s);
        return json.substring(s, e).replace("\"", "").trim();
    }
}
