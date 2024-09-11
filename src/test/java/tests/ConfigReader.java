package tests;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/config.properties";

    public ConfigReader() {
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file");
        }
    }

    //Browser configuration
    public boolean isNoFirstRun() {
        return Boolean.parseBoolean(properties.getProperty("noFirstRun"));
    }

    public boolean isNoDefaultBrowserCheck() {
        return Boolean.parseBoolean(properties.getProperty("noDefaultBrowserCheck"));
    }
    public boolean isIncognito() {
        return Boolean.parseBoolean(properties.getProperty("incognito"));
    }

    //URL selection
    public String getQuestionaryURL() {
        return properties.getProperty("questionaryURL");
    }
    public String getAccountLoginURL() {
        return properties.getProperty("accountURL");
    }
    public String getUserName() {
        return properties.getProperty("username");
    }
    public String getPassword() {
        return properties.getProperty("password");
    }
}
