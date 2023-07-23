package commondb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import utils.FileManagerUtil;
import java.util.Objects;

public class DbConnection {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String URL = FileManagerUtil.getValue("configDb.json", "url");
    private static final String USERNAME = FileManagerUtil.getValue("credentials.json", "username");
    private static final String PASSWORD = FileManagerUtil.getValue("credentials.json", "password");

    private DbConnection() {
    }

    public static Handle open() {
        Jdbi jdbi = Jdbi.create(Objects.requireNonNull(URL),
                Objects.requireNonNull(USERNAME),
                Objects.requireNonNull(PASSWORD));
        try {
            Handle handle = jdbi.open();
            LOGGER.info("Created connection: " + handle);
            return handle;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Handle handle) {
        try {
            LOGGER.info("Closing the connection [{}]", handle);
            handle.close();
        } catch (Exception e) {
            LOGGER.error("Failed to close the connection [{}]", handle);
        }
    }
}
