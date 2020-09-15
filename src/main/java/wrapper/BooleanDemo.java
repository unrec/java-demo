package wrapper;

import java.util.Map;

public class BooleanDemo {

    public static void main(String[] args) {
        Map<String, Object> settings = Map.of("enableDeliveryPartner", "");
        Map<String, Object> map = Map.of("settings", settings);

        Map<String, Object> readSettings = (Map) map.get("settings");
        Boolean enableDeliveryPartner = (Boolean) readSettings.get("enableDeliveryPartner");

        System.out.println("enableDeliveryPartner = " + enableDeliveryPartner);
    }
}