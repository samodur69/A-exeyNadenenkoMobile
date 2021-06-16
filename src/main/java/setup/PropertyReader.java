package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties prop;

    public PropertyReader() {
        try (InputStream input = new FileInputStream("src/test/resources/testData.property")) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPsw() {
        return prop.getProperty("password");
    }

    public String getExpectedTitle() {
        return prop.getProperty("title");
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getRequest() {
        return prop.getProperty("searchRequest");
    }
 }
