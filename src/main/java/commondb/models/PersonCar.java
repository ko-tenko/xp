package commondb.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonCar {

    private Integer personId;
    private String carNumber;
    private String carName;
}

