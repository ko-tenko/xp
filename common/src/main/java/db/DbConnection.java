package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import utils.ConfigManager;
import java.util.Objects;

public class DbConnection {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String URL = ConfigManager.getValue("urlDb");
    private static final String USERNAME = ConfigManager.getValue("username");
    private static final String PASSWORD = ConfigManager.getValue("password");

    private DbConnection() {
    }

    public static Jdbi open() {
        var jdbi = Jdbi.create(Objects.requireNonNull(URL),
                Objects.requireNonNull(USERNAME),
                Objects.requireNonNull(PASSWORD));
        jdbi.installPlugin(new SqlObjectPlugin());
        LOGGER.info("Jdbi created {}", jdbi);
        return jdbi;
    }
}