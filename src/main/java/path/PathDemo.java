package path;

import java.nio.file.Paths;

public class PathDemo {

    public static void main(String[] args) {
        String resourcesPath = Paths.get("src", "main", "resources").toFile().getAbsolutePath();
        System.out.println(resourcesPath);
    }
}