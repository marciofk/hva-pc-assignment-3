package teaching.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Config instance;
    private Properties config;

    static {
        instance = new Config();
    }

    public static Config getInstance() {
        return instance;
    }

    private Config() {
        loadProperties();
    }

    public String getServer() {
        return config.getProperty("server");
    }

    public int getPort() {
        return Integer.parseInt(config.getProperty("port"));
    }


    private void loadProperties() {
        try {
            config = new Properties();
            InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties");
            config.load(in);
            in.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}
