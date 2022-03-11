package com.teachMeSkills.lesson21.task2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperty {

    private static final String PATH_DB_PROPERTIES = "D:\\все_файлы\\java\\projects\\JavaEE\\TMS_Servlet_Lesson21\\TMS_Servlet3\\src\\resource\\database.properties";

    public static String getDBProperties(String key) {

        try (InputStream input = new FileInputStream(PATH_DB_PROPERTIES)) {

            Properties properties = new Properties();
            properties.load(input);

            String value = properties.getProperty(key);
            return value;

        } catch (IOException io) {
            io.printStackTrace();
            return null;
        }

    }


}
