package utils;

import api.models.User;
import com.github.javafaker.Faker;


public class UserUtil {

    private static final Faker faker = new Faker();

    private UserUtil(){}

    public static User generateUser() {

        return User.builder()
                .userId(faker.number().numberBetween(999, 9999))
                .title(faker.name().firstName())
                .body(faker.name().fullName())
                .build();
    }
}
