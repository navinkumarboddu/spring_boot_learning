package com.pluralsight.fundamentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
/*@SpringBootApplication - contains 3 annotations
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
public class FundamentalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundamentalsApplication.class, args);
        System.out.println("Hello Pluralsight");
    }
}
