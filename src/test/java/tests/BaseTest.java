package tests;

import commondb.DbConnection;
import dao.PersonCarDAO;
import models.PersonCarModel;
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
        PersonCarModel personCarModel = personCarDao.getById(1);
        System.out.println(personCarModel.getPersonId() + personCarModel.getCarName() + personCarModel.getCarNumber());
    }
}
