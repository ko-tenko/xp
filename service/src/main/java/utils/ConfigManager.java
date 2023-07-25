package utils;

import exceptions.FileReadException;
import exceptions.FileWriteException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class ConfigManager {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String YAML_FILE = "_config.yml";
    private static final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private static final String PATH = Objects.requireNonNull(classloader.getResource(YAML_FILE)).getPath();

    private ConfigManager() {}

    public static String getValue(String key) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new FileInputStream(PATH)) {
            Map<String, Object> data = yaml.load(inputStream);
            LOGGER.info("Getting the [{}] value from the YAML file [{}]", key, YAML_FILE);
            return String.valueOf(data.get(key));
        } catch (IOException e) {
            LOGGER.error("Error when reading YAML file: " + YAML_FILE, e);
            throw new FileReadException("Error reading from YAML file", e);
        }
    }


    public static void setValue(String key, String value) {
        Map<String, String> data = readDataFromYamlFile();
        data.put(key, value);
        writeDataToYamlFile(data);
    }

    private static Map<String, String> readDataFromYamlFile() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new FileInputStream(PATH)) {
            LOGGER.info("Reading data from YAML file: " + YAML_FILE);
            return yaml.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Error when reading from YAML file: " + YAML_FILE);
            throw new FileReadException("Error reading from YAML file", e);
        }
    }

    private static void writeDataToYamlFile(Map<String, String> data) {
        DumperOptions options = new DumperOptions();
        Yaml yaml = new Yaml(options);
        try (OutputStream outputStream = new FileOutputStream(PATH)) {
            LOGGER.info("Writing data to YAML file: " + YAML_FILE);
            yaml.dump(data, new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            LOGGER.error("Error when writing to YAML file: " + YAML_FILE);
            throw new FileWriteException("Error writing from YAML file", e);
        }
    }
}

