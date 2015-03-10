package com.impulse.phonec;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 手机号 城市 资源
 * @author zhaohaifeng
 * @since 2015-03-10
 */
public class PhoneCityResource {


    private static final Logger LOGGER = Logger.getLogger(PhoneCityResource.class.getName());

    /**
     * 手机号-城市资源文件
     */
    private static final String resourceName = "/db/phone_city.txt";

    private Properties phoneCityProperties = null;

    /**
     * 采用饿汉模式，程序初始即加载数据
     */
    private static PhoneCityResource phoneCityResource = getInstance();

    private PhoneCityResource() {
    }


    public static PhoneCityResource getInstance() {
        if (phoneCityResource != null) {
            return phoneCityResource;
        }

        phoneCityResource = new PhoneCityResource();
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(PhoneCityResource.class.getResourceAsStream(resourceName),"UTF-8"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"加载[手机号-城市]资源文件失败",e);
        }
        phoneCityResource.setPhoneCityProperties(properties);

        return phoneCityResource;
    }

    private void setPhoneCityProperties(Properties phoneCityProperties) {
        this.phoneCityProperties = phoneCityProperties;
    }

    public String getValueByKey(String key) {
        return phoneCityProperties.getProperty(key);
    }
}
