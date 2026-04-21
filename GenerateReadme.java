import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenerateReadme {

    public static void main(String[] args) throws IOException {

        System.out.println("🚀 Generating README (No AI)");

        File repo = new File(".");
        StringBuilder md = new StringBuilder();

        md.append("# 📘 DSA Practice Repository\n\n");
        md.append("Structured collection of DSA problems with Java solutions.\n\n");

        File[] dirs = repo.listFiles(File::isDirectory);
        if (dirs == null) return;

        Arrays.sort(dirs, Comparator.comparing(File::getName));

        for (File dir : dirs) {

            String name = dir.getName();

            // skip system folders
            if (name.startsWith(".") || name.equals(".github")) continue;

            File[] files = dir.listFiles((d, f) -> f.endsWith(".java"));
            if (files == null || files.length == 0) continue;

            Arrays.sort(files, Comparator.comparing(File::getName));

            md.append("## 📂 ").append(name).append("\n\n");

            md.append("| Problem | Code | Explanation |\n");
            md.append("|--------|------|------------|\n");

            for (File f : files) {

                String problem = f.getName().replace(".java", "");
                String codePath = "./" + name + "/" + f.getName();

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

            md.append("\n");
        }

        md.append("---\n");
        md.append("⚡ Auto-generated using GitHub Actions.\n");

        Files.write(Paths.get("README.md"), md.toString().getBytes());

        System.out.println("✅ README UPDATED!");
    }
}
