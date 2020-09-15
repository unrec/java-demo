package mapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mapping.dto.SupplierDto;
import mapping.dto.enums.CalculationType;
import mapping.dto.enums.SupplierStatus;
import java.math.BigDecimal;
import java.util.Map;

public class DtoToMapDemo {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SupplierDto dto = getDto();
        Map<String, Object> map = mapper.convertValue(dto, new TypeReference<>() {});
        System.out.println("map = " + map);

        Map<String, Object> settings = (Map) map.get("settings");
        System.out.println("settings = " + settings);
        System.out.println("isEnabled = " + settings.get("isEnabled"));
        System.out.println(settings.get("isEnabled").getClass());

        Boolean isEnabled = Boolean.valueOf((String) settings.get("isEnabled"));
        System.out.println("isEnabled = " + isEnabled);
    }

    private static SupplierDto getDto() {
        return new SupplierDto()
                .setName("some_supplier")
                .setPartnerType("regular")
                .setStatus(SupplierStatus.ACTIVE)
                .setDescription("some_description")
                .setConfidence("good")
                .setLogo(42)
                .setDeliveryCost(BigDecimal.TEN)
                .setCalculationType(CalculationType.FIXED)
                .setDownloadUrl("http://some.url.com")
                .setDeliveryVariantsUrl("http://some.variants.url.com")
                .setReportEmailList("admin@supplier.com")
                .setEnabled(false)
                .setSettings(Map.of(
                        "email", "abc@xyz.com",
                        "price", "current",
                        "tax", "zero",
                        "isEnabled", "true"));
    }
}