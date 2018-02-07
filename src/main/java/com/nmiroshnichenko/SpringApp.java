package com.nmiroshnichenko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;


/**
 * Created on 06.02.2018.
 */
@Component
public class SpringApp {
    private static final Logger logger = LogManager.getLogger(SpringApp.class.getName());
    public static void main(String[] args) {

        logger.info("Application started");

        try {
            SimpleCommandLinePropertySource clps = new SimpleCommandLinePropertySource(args);
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.getEnvironment().getPropertySources().addFirst(clps);
            ctx.scan("com.nmiroshnichenko");
            ctx.refresh();

            Runnable app = ctx.getBean(App.class);
            app.run();
        } catch (Exception e) {
            logger.error("Error in SpringApp.main");
            logger.error(e);
            e.printStackTrace();
        }
        logger.info("Application stopped");
    }
}
