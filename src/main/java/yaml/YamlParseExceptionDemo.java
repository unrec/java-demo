package yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YamlParseExceptionDemo {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, MatrixItem.class);
        ClassLoader classLoader = YamlParseDemo.class.getClassLoader();

        String matrixPath = "yaml/bad-matrix.yaml";
        File matrixFile = new File(classLoader.getResource(matrixPath).getFile());

        try {
            List<MatrixItem> list = mapper.readValue(matrixFile, listType);
            list.forEach(System.out::println);
        } catch (JsonParseException e) {
            System.out.println("JsonParseException, message: " + e.getMessage());
            System.out.println("JsonParseException, location: " + e.getLocation());
        } catch (JsonMappingException e) {
            System.out.println("JsonMappingException, message: " + e.getMessage());
            System.out.println("JsonMappingException, location: " + e.getLocation());
        }
    }
}