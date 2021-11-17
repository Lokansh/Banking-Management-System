package com.bankingmanagement.bankingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(scanBasePackages = { "com.bankingmanagement.bankingmanagement.*"} )
public class BankingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingManagementApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
}
