package com.james.sportsmanagementws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class SportsManagementWsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SportsManagementWsApplication.class, args);
    }

}
