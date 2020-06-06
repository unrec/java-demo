package yaml;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Matrix {
    private List<MatrixItem> matrixItems;
}