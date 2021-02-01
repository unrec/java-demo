package string;

import java.util.Arrays;
import java.util.List;

public class StringSplitRegexDemo {

    public static void main(String[] args) {
        getNames().stream()
                .map(s -> s.split("Settings")[0])
                .forEach(System.out::println);
    }

    private static List<String> getNames() {
        return Arrays.asList("addrObjectSettings", "addrObjectParamsSettings", "apartmentsSettings",
                "apartmentsParamsSettings", "housesSettings", "housesParamsSettings", "roomsSettings",
                "roomsParamsSettings", "admHierarchySettings", "reestrObjectsSettings",
                "addrObjTypesSettings", "objectLevelsSettings", "apartmentTypesSettings",
                "houseTypesSettings", "addHouseTypesSettings", "roomTypesSettings", "paramTypesSettings");
    }
}