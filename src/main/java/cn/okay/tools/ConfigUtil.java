package cn.okay.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yutz on 2018/4/8.
 */
public class ConfigUtil {

    private static ConfigUtil configUtil=new ConfigUtil();
    private static Properties properties;

    private ConfigUtil(){

    }

    public static ConfigUtil getConfigUtil(){
        if (configUtil==null) {
            configUtil = new ConfigUtil();
            return configUtil;
        }
        else
            return configUtil;
    }


    public String getConfigFileContent(String key) throws Exception {
        try{
            String path=Thread.currentThread().getContextClassLoader().getResource("test_config.properties").getPath();
            properties=new Properties();
            InputStream ips=new FileInputStream(path);
            properties.load(ips);
            ips.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

}
