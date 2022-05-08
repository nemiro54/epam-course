package by.epam.unit_5.task_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class MyFile {
    private String name;
    private String format;
    private Directory directory;
    private Path path;

    public MyFile(String name, String format, Directory directory) {
        this.name = name;
        this.format = format;
        this.directory = directory;
        this.path = createFile();
    }

    private Path createFile() {
        String separator = File.separator;
        String path = directory.getPath() + separator + name + "." + format;

        if (Files.exists(Paths.get(path))) {
            System.out.println("Файл уже существует.");
            return Paths.get(path);
        } else {
            try {
                return Files.createFile(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void deleteFile() {
        try {
            Files.delete(getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
