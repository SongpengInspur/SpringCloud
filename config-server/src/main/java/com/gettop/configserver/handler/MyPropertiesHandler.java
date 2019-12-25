package com.gettop.configserver.handler;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyPropertiesHandler implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        List<PropertySource<?>> returnList = new ArrayList<>();
        Properties properties = getProperties(resource);
        if (!properties.isEmpty()) {
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
            returnList.add(propertiesPropertySource);
            return returnList;
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            //logger.error("load inputstream failure...", e);
            System.out.println("load inputstream failure...");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //logger.error("close IO failure ....", e);
                    System.out.println("close IO failure ....");
                }
            }
        }
        return properties;
    }
}
