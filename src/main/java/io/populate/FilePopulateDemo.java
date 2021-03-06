package io.populate;

public class FilePopulateDemo {

    public static final String CSV_ORIGIN_PATH = "src/main/resources/file1.csv";
    public static final String CSV_POPULATED_PATH = "src/main/resources/populated.csv";
    public static final int COPIES_AMOUNT = 100_001;

    public static void main(String[] args) {
        FilePopulator populator = new FilePopulator();
        populator.populate(CSV_ORIGIN_PATH, CSV_POPULATED_PATH, COPIES_AMOUNT);
    }
}