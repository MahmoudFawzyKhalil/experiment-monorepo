package concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileRenamer {
    public static void main(String[] args) throws IOException {
        Path directory = Path.of("/home/mahmoud/Downloads/Heinz Kabutz - Data Structures in Java");

        Path namesPath = directory.resolve("names.txt");

        List<String> names = Files.readAllLines(namesPath)
                .stream()
                .map(String::strip)
                .toList();

        List<Path> files = Files.list(directory)
                .filter(path -> path.toString().endsWith(".mp4"))
                .toList();

        for (int i = 0; i < files.size(); i++) {
            Path file = files.get(i);
            String newName = names.get(i);

            String x = i <= 8 ? "0" + (i + 1) + " - " + newName + ".mp4" : (i + 1) + " - " + newName + ".mp4";

            Path newFile = file.resolveSibling(Path.of(x));

            System.out.println(x);
            Files.move(file, newFile);
        }
    }
}
