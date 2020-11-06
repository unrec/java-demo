package xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbDemo {
    public static void main(String[] args) throws JAXBException {
        User user = new User("John", "Smith", 42, true);

        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // marshall object to xml
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter xmlWriter = new StringWriter();
        marshaller.marshal(user, xmlWriter);
        System.out.println(xmlWriter.toString());

        // un-marshall xml to object
        StringReader reader = new StringReader(xmlData());
        User readUser = (User) unmarshaller.unmarshal(reader);
        System.out.println("readUser = " + readUser);
    }

    private static String xmlData() {
        return "<user><firstName>Jane</firstName>" +
                "<lastName>Doe</lastName>" +
                "<rating>100</rating>" +
                "<active>false</active>" +
                "</user>";
    }
}