import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    public static void main(String[] args) throws IOException {

        System.out.println("🚀 Generating README (Commit Order)");

        File repo = new File(".");
        StringBuilder md = new StringBuilder();

        md.append("# 📘 DSA Practice Repository\n\n");
        md.append("Structured collection of DSA problems with Java solutions.\n\n");

        // 🔥 Get files in commit order
        List<String> orderedFiles = getFilesByCommitOrder();

        File[] dirs = repo.listFiles(File::isDirectory);
        if (dirs == null) return;

        Arrays.sort(dirs, Comparator.comparing(File::getName));

        for (File dir : dirs) {

            String name = dir.getName();

            // skip system folders
            if (name.startsWith(".") || name.equals(".github")) continue;

            md.append("## 📂 ").append(name).append("\n\n");
            md.append("| Problem | Code | Explanation |\n");
            md.append("|--------|------|------------|\n");

            boolean hasFiles = false;

            for (String path : orderedFiles) {

                // only take files from this directory
                if (!path.startsWith(name + "/")) continue;
                if (!path.endsWith(".java")) continue;

                File f = new File(path);
                if (!f.exists()) continue;

                hasFiles = true;

                String problem = f.getName().replace(".java", "");
                String codePath = "./" + path;

                File explanation = new File(dir, problem + ".md");

                md.append("| ")
                  .append(problem)
                  .append(" | [View Code](")
                  .append(codePath)
                  .append(") | ");

                if (explanation.exists()) {
                    String expPath = "./" + name + "/" + problem + ".md";
                    md.append("[View Notes](").append(expPath).append(")");
                } else {
                    md.append("—");
                }

                md.append(" |\n");
            }

            if (hasFiles) {
                md.append("\n");
            }
        }

        md.append("---\n");
        md.append("⚡ Auto-generated using GitHub Actions.\n");

        Files.write(Paths.get("README.md"), md.toString().getBytes());

        System.out.println("✅ README UPDATED!");
    }

    // 🔥 Get files in first commit order (oldest → newest)
    static List<String> getFilesByCommitOrder() throws IOException {

        ProcessBuilder pb = new ProcessBuilder(
            "git", "log", "--reverse", "--name-only", "--pretty=format:"
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream())
        );

        LinkedHashSet<String> files = new LinkedHashSet<>();
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (!line.isEmpty()) {
                files.add(line); // keeps order, removes duplicates
            }
        }

        return new ArrayList<>(files);
    }
}
