package by.epam.unit_5.task_1;

import java.io.IOException;
import java.nio.file.*;

public class Directory {
    private Path path;

    public Directory(String path) {
        this.path = createDirectory(path);
    }

    public Path createDirectory(String path) {
        if (Files.exists(Paths.get(path))) {
            System.out.println("Директория уже существует.");
            return Paths.get(path);
        } else {
            try {
                return Files.createDirectory(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
