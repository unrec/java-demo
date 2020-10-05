package xml.config2;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.plist.XMLPropertyListConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlistConfigurationReadDemo {
    public static void main(String[] args) throws FileNotFoundException, ConfigurationException {
        String resource = "src/main/resources/xml/sample-library.xml";

        XMLPropertyListConfiguration plist = new XMLPropertyListConfiguration();
        plist.read(new FileReader(new File(resource)));

        List<String> strings = new ArrayList<>();
        Iterator<String> keys = plist.getKeys();
        while (keys.hasNext()) {
            String string = plist.getString(keys.next());
            strings.add(string);
        }
        strings.forEach(System.out::println);
    }
}