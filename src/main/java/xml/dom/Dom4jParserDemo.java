package xml.dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom4jParserDemo {
    public static void main(String[] args) throws DocumentException {
        File file = new File("src/main/resources/xml/users.xml");
        List<User> users = new ArrayList<>();

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        Element classElement = document.getRootElement();
        List<Node> nodes = document.selectNodes("/data/users/user");

        for (Node node : nodes) {
            User user = new User()
                    .setId(Integer.parseInt(node.valueOf("@id")))
                    .setFirstName(node.selectSingleNode("firstname").getText())
                    .setLastName(node.selectSingleNode("lastname").getText())
                    .setAge((Integer.parseInt(node.selectSingleNode("age").getText())))
                    .setCountry(node.selectSingleNode("country").getText())
                    .setVerified(Boolean.parseBoolean(node.selectSingleNode("verifyed").getText()));
            users.add(user);
        }
        users.forEach(System.out::println);
    }
}