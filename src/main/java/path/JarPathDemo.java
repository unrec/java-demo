package path;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class JarPathDemo {

    public static void main(String[] args) throws URISyntaxException {
        Class clazz = JarPathDemo.class;
        System.out.println("This Class: " + clazz);

        String protocol = clazz.getProtectionDomain().getCodeSource().getLocation().getProtocol();
        System.out.println("Protocol Name of the Class: " + protocol);

        if (protocol.equals("file")) {
            String pathToClasses = clazz.getProtectionDomain().getCodeSource().getLocation().toURI().toString();
            System.out.println(pathToClasses);
        }
        if (protocol.equals("jar")) {
            String tempPath = clazz.getProtectionDomain().getCodeSource().getLocation().toString().split("!")[0].replace("jar:file:", "");
            String jarPath = Paths.get(tempPath).getParent().toString();
            System.out.println(jarPath);
        }
    }
}