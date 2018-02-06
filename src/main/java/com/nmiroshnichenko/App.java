package com.nmiroshnichenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class App implements Runnable {

    @Autowired
    private AppConfiguration config = null;

    @Override
    public void run() {
        System.out.println("File property source: " + config.getFile());
        System.out.println("Console property source: " + config.getConsole());
        System.out.println("Default property source: " + config.getDef());
    }
}
