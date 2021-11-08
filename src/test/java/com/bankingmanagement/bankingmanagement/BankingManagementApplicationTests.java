package com.bankingmanagement.bankingmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BankingManagementApplicationTests {

    @Test
    public void homeResponse() {
        // Added dummy test for pipeline setup  TODO : Remove the testcase
        assertThat("Greetings from ABC Bank").isEqualTo("Greetings from ABC Bank");
    }

}
