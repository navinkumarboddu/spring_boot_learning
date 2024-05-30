package com.in28minutes.springboot.web.runner;

import com.in28minutes.springboot.web.entity.User;
import com.in28minutes.springboot.web.service.UserDAOService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {


    private static final Logger log =
            (Logger) LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;


    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack","Admin");
        Long userid = userDAOService.saveUser(user);
        log.info("New user created :" + user);

    }
}
