import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

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

            // skip system folders
            if (name.startsWith(".") || name.equals("node_modules")) continue;

            File[] files = dir.listFiles((d, f) -> f.endsWith(".java"));
            if (files == null || files.length == 0) continue;

            Arrays.sort(files, Comparator.comparing(File::getName));

            md.append("## 📂 ").append(name).append("\n\n");
            md.append("| Problem | Code |\n");
            md.append("|--------|------|\n");

            for (File f : files) {
                String problem = f.getName().replace(".java", "");
                String path = "./" + name + "/" + f.getName();

                md.append("| ")
                  .append(problem)
                  .append(" | [View Code](")
                  .append(path)
                  .append(") |\n");
            }
            md.append("\n");
        }

        md.append("---\n");
        md.append("⚡ Auto-generated on every push using GitHub Actions.\n");

        Files.write(Paths.get("README.md"), md.toString().getBytes());
        System.out.println("README.md updated!");
    }
}
