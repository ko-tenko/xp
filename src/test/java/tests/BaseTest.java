package tests;

import commondb.DbConnection;
import dao.PersonCarDAO;
import models.PersonCar;
import org.jdbi.v3.core.Handle;
import org.junit.jupiter.api.Test;
import utils.FileManagerUtil;


public class BaseTest {

    @Test
    void test1() {
        System.out.println(FileManagerUtil.getValue("credentials.json", "password"));
        System.out.println(FileManagerUtil.getValue("config.json", "url"));
        Handle handle = DbConnection.open();
        PersonCarDAO personCarDao = new PersonCarDAO(handle);
        PersonCar personCar = personCarDao.getById(1);
        System.out.println(personCar.getPersonId()+ " " + personCar.getCarName() + " " + personCar.getCarNumber());
    }
}
