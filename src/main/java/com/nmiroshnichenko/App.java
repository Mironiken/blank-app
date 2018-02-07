package com.nmiroshnichenko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class App implements Runnable {

    private static final Logger logger = LogManager.getLogger(App.class.getName());

    @Autowired
    private AppConfiguration config = null;

    @Override
    public void run() {
        System.out.println("File property source: " + config.getFile());
        System.out.println("Console property source: " + config.getConsole());
        System.out.println("Default property source: " + config.getDef());
        logger.info("File property source: " + config.getFile());
        logger.info("Console property source: " + config.getConsole());
        logger.info("Default property source: " + config.getDef());
    }
}
