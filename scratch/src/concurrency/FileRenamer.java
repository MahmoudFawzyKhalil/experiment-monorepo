package concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileRenamer {
    public static void main(String[] args) throws IOException {
        Path directory = Path.of("path/to/file");

        Path namesPath = directory.resolve("names.txt");

        List<String> names = Files.readAllLines(namesPath)
                .stream()
                .map(String::strip)
                .toList();

        List<Path> files = Files.list(directory)
                .filter(path -> path.toString().endsWith(".mp4"))
                .sorted((p1, p2) -> {
                    int p1Num = Integer.parseInt(p1.getFileName().toString().replace("lesson", "").replace(".mp4", ""));
                    int p2Num = Integer.parseInt(p2.getFileName().toString().replace("lesson", "").replace(".mp4", ""));
                    return Integer.compare(p1Num, p2Num);
                })
                .peek(System.out::println)
                .toList();

        for (int i = 0; i < files.size(); i++) {
            Path file = files.get(i);
            String newName = names.get(i);

            String x = i <= 8 ? "0" + (i + 27) + " - " + newName + ".mp4" : (i + 27) + " - " + newName + ".mp4";

            Path newFile = file.resolveSibling(Path.of(x));

            System.out.println(x);
            Files.move(file, newFile);
        }
    }
}
