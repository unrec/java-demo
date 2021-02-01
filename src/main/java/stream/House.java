package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {

    Integer id;
    String streetName;
    Integer houseNumber;
    LocalDate date;
}