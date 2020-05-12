package string;

import java.util.UUID;

public class SubstringDemo {
    public static void main(String[] args) {
        String emailId = String.valueOf(UUID.randomUUID());
        String fileValue = "records.zip";
        String filePath = emailId + "/" + fileValue.substring(0, fileValue.lastIndexOf('.')) + ".csv";
        System.out.println(filePath);
    }
}