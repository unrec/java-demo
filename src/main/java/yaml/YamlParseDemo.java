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

public class YamlParseDemo {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, MatrixItem.class);
        ClassLoader classLoader = YamlParseDemo.class.getClassLoader();

        String itemPath = "yaml/item.yaml";
        String matrixPath = "yaml/matrix.yaml";
        File itemFile = new File(classLoader.getResource(itemPath).getFile());
        File matrixFile = new File(classLoader.getResource(matrixPath).getFile());

        try {
            MatrixItem item = mapper.readValue(itemFile, MatrixItem.class);
            List<MatrixItem> list = mapper.readValue(matrixFile, listType);
            List rawList = mapper.readValue(matrixFile, List.class);

            list.forEach(System.out::println);

        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        }
    }
}