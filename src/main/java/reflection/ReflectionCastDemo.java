package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionCastDemo {

    public static void main(String[] args) {
        Dto dto = new Dto("john", "smith", "sr.", "abc@xyz.com", "9511234567889");

        Field[] dtoFields = dto.getClass().getDeclaredFields();
        System.out.println("dtoFields: ");
        Arrays.asList(dtoFields).forEach(System.out::println);

        Object castObj = (Object) dto;
        Field[] castFields = castObj.getClass().getDeclaredFields();
        System.out.println("castDtoFields: ");
        Arrays.asList(castFields).forEach(System.out::println);


    }


}