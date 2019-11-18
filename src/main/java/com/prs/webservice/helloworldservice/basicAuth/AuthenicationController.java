package com.prs.webservice.helloworldservice.basicAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenicationController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/basicauth")
    public AuthenticationBean authenticate(){
        logger.info("{}", "You are authenticated");
        return new AuthenticationBean("You are authenticated");
    }

    @GetMapping("/welcome/{name}")
    public AuthenticationBean helloUser(@PathVariable String name){
        logger.info("You are authenticated {}", name);
        return new AuthenticationBean("You are authenticated "+name);
    }
}
