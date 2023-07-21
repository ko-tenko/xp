package models;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PersonCarModel {

    private Integer personId;
    private String carNumber;
    private String carName;

    public PersonCarModel(Integer personId,
                          String carNumber,
                          String carName) {
        this.personId = personId;
        this.carNumber = carNumber;
        this.carName = carName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

}

