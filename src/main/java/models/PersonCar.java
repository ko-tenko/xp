package models;


public class PersonCar {

    private Integer personId;
    private String carNumber;
    private String carName;

    public PersonCar(){}

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

