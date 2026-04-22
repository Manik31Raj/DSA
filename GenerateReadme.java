import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    public static void main(String[] args) throws IOException {

        System.out.println("🚀 Generating README (First Commit Order + Per Folder Serial)");

        File repo = new File(".");
        StringBuilder md = new StringBuilder();

        md.append("# 📘 DSA Practice Repository\n\n");
        md.append("Structured collection of DSA problems with Java solutions.\n\n");

        // 🔥 Get files in TRUE first commit order
        List<String> orderedFiles = getFilesByCommitOrder();

        File[] dirs = repo.listFiles(File::isDirectory);
        if (dirs == null) return;

        Arrays.sort(dirs, Comparator.comparing(File::getName));

        for (File dir : dirs) {

            String name = dir.getName();

            // skip system folders
            if (name.startsWith(".") || name.equals(".github")) continue;

            StringBuilder section = new StringBuilder();
            boolean hasFiles = false;

            section.append("## 📂 ").append(name).append("\n\n");
            section.append("| S.No | Problem | Code | Explanation |\n");
            section.append("|------|--------|------|------------|\n");

            int serial = 1; // 🔥 reset per folder

            for (String path : orderedFiles) {

                if (!path.startsWith(name + "/")) continue;
                if (!path.endsWith(".java")) continue;

                File f = new File(path);
                if (!f.exists()) continue;

                hasFiles = true;

                String problem = f.getName().replace(".java", "");
                String codePath = "./" + path;

                File explanation = new File(dir, problem + ".md");

                section.append("| ")
                       .append(serial++)
                       .append(" | ")
                       .append(problem)
                       .append(" | [View Code](")
                       .append(codePath)
                       .append(") | ");

                if (explanation.exists()) {
                    String expPath = "./" + name + "/" + problem + ".md";
                    section.append("[View Notes](").append(expPath).append(")");
                } else {
                    section.append("—");
                }

                section.append(" |\n");
            }

            if (hasFiles) {
                section.append("\n");
                md.append(section);
            }
        }

        md.append("---\n");
        md.append("⚡ Auto-generated using GitHub Actions.\n");

        Files.write(Paths.get("README.md"), md.toString().getBytes());

        System.out.println("✅ README UPDATED!");
    }

    // 🔥 TRUE first commit order (file creation in repo)
    static List<String> getFilesByCommitOrder() throws IOException {

        ProcessBuilder pb = new ProcessBuilder(
            "git", "log",
            "--reverse",
            "--diff-filter=A",   // ✅ only first time added
            "--name-only",
            "--pretty=format:"
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

            if (!line.isEmpty() && line.endsWith(".java")) {
                files.add(line); // keeps correct order
            }
        }

        return new ArrayList<>(files);
    }
}
