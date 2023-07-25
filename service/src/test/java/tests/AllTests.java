package tests;

import api.ApiClient;
import api.ApiService;
import api.RequestSpecUtils;
import api.models.User;

import db.DbConnection;
import db.dao.IPersonCarDAO;
import db.models.PersonCar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import retrofit2.Response;
import utils.ConfigManager;
import utils.UserUtil;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


class AllTests {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void testDb() {
        Jdbi jdbi = DbConnection.open();
        List<PersonCar> personCars = jdbi.withExtension(IPersonCarDAO.class, IPersonCarDAO::getAll);
        LOGGER.info(personCars);
        int personCarId = 1;
        PersonCar personCar = jdbi.withExtension(IPersonCarDAO.class, dao -> dao.getById(personCarId));
        Assertions.assertEquals((int) personCar.getPersonId(), personCarId);
        LOGGER.info(personCar);
    }

    @Test
    void testApi() throws IOException {
        ApiService apiService = RequestSpecUtils.createService(ApiClient.getClient());
        int personId = 1;
        Response<User> userGetResponse = apiService.getUser(personId).execute();
        User responseBody = userGetResponse.body();
        LOGGER.info(Objects.requireNonNull(responseBody).getBody());

        User user = UserUtil.generateUser();
        String title = user.getTitle();
        Response<User> userPostResponse = apiService.createUser(user).execute();
        Assertions.assertEquals(Objects.requireNonNull(userPostResponse.body()).getTitle(), title);
    }

    @Test
    void testConfigManager() {
        String value = "new";
        ConfigManager.getValue("urlDb");
        ConfigManager.setValue("token", value);
        Assertions.assertEquals(value, ConfigManager.getValue("token"));
    }
}
