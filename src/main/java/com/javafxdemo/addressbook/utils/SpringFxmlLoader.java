package com.javafxdemo.addressbook.utils;

import javafx.fxml.FXMLLoader;
import com.javafxdemo.addressbook.config.AppConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringFxmlLoader {

    private static final Logger LOG = LogManager.getLogger(SpringFxmlLoader.class);
    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    public Object load(String url) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
        loader.setLocation(getClass().getResource(url));
        //loader.setResources(ResourceBundle.getBundle(resources));
        try {
            return loader.load();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
}
