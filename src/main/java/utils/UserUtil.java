package utils;

import com.github.javafaker.Faker;
import commonapi.models.User;

public class UserUtil {

    private static final Faker faker = new Faker();

    private UserUtil(){}

    public static User generateUser() {
        User user = new User();
        user.setUserId(faker.number().numberBetween(999, 9999));
        user.setTitle(faker.name().firstName());
        user.setBody(faker.name().fullName());
        return user;
    }
}
