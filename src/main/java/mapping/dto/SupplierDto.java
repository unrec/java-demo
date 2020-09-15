package mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mapping.dto.enums.CalculationType;
import mapping.dto.enums.SupplierStatus;
import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

    private String name;
    private String partnerType;
    private SupplierStatus status;
    private String description;
    private String confidence;
    private Integer logo;

    private BigDecimal deliveryCost;
    private CalculationType calculationType;
    private String downloadUrl;
    private String deliveryVariantsUrl;
    private String reportEmailList;

    private Boolean enabled;
    private Map<String, Object> settings;
}