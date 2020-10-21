package yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatrixItem {
    private String matrixItemId;
    private int minimumWeight;
    private int maximumWeight;
    private double cost;
    private int period;
    private Status status;
}