package tests;

import commonapi.ApiClient;
import commonapi.RequestSpecUtils;
import commonapi.RequestUtils;
import commonapi.models.User;
import commondb.DbConnection;
import commondb.dao.PersonCarDAO;
import commondb.models.PersonCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdbi.v3.core.Handle;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import utils.UserUtil;

import java.util.Objects;


public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void testDb() {
        Handle handle = DbConnection.open();
        PersonCarDAO personCarDao = new PersonCarDAO(handle);
        PersonCar personCar = personCarDao.getById(1);
        LOGGER.info(personCar.getPersonId() + " " + personCar.getCarName() + " " + personCar.getCarNumber());
    }

    @Test
    void testApi() {
        Response<User> userGetResponse = RequestUtils
                .sendGet(RequestSpecUtils.createService(ApiClient.getClient()), 1);
        User post = userGetResponse.body();
        LOGGER.info(Objects.requireNonNull(post).getBody());

        User user = UserUtil.generateUser();
        Response<User> userPostResponse = RequestUtils
                .sendPost(RequestSpecUtils.createService(ApiClient.getClient()), user);
        LOGGER.info(userPostResponse.body());
    }
}
