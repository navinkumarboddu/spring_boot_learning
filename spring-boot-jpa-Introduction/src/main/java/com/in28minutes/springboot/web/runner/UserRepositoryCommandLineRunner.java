package com.in28minutes.springboot.web.runner;

import com.in28minutes.springboot.web.entity.User;
import com.in28minutes.springboot.web.service.UserDAOService;
import com.in28minutes.springboot.web.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            (Logger) LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill","Admin");
        userRepository.save(user);
        log.info("New user created :" + user);
    }
}
