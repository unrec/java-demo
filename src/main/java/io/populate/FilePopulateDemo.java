package com.epam.vtbbulpm.flc.csvcheckerworker.util;

import com.epam.vtbbulpm.flc.csvcheckerworker.util.FilePopulator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilePopulateApplication {

    public static final String CSV_ORIGIN_PATH = "src/test/resources/sample.csv";
    public static final String CSV_POPULATED_PATH = "src/test/resources/too_big.csv";
    public static final int COPIES_AMOUNT = 100_001;

    public static void main(String[] args) {
        FilePopulator populator = new FilePopulator();
        populator.populate(CSV_ORIGIN_PATH, CSV_POPULATED_PATH, COPIES_AMOUNT);
    }
}