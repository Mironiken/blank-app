package com.nmiroshnichenko;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created on 06.02.2018.
 */
@Component
@PropertySource(value = "file:src/resources/application.properties")
class AppConfiguration {
    String getDef() {
        return def;
    }

    String getFile() {
        return file;
    }

    String getConsole() {
        return console;
    }

    @Value("${default:true}")
    private String def = "";

    @Value("${file:false}")
    private String file = "";

    @Value("${console:false}")
    private String console = "";

}
