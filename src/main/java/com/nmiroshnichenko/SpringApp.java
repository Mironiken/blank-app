package com.nmiroshnichenko;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;

/**
 * Created on 06.02.2018.
 */
@Component
public class SpringApp {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SimpleCommandLinePropertySource clps = new SimpleCommandLinePropertySource(args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfiguration.class);
        ctx.getEnvironment().getPropertySources().addFirst(clps);
        ctx.scan("com.nmiroshnichenko");
        ctx.refresh();

        Runnable app = ctx.getBean(App.class);
        app.run();
    }
}
