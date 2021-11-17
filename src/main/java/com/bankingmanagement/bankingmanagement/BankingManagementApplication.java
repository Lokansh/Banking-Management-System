package com.bankingmanagement.bankingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = { "com.bankingmanagement.bankingmanagement.authentication","com.bankingmanagement.bankingmanagement.database"} )
public class BankingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingManagementApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from ABC Bank";
    }
}
