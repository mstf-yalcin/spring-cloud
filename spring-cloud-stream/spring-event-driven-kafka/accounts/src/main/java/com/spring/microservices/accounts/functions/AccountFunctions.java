package com.spring.microservices.accounts.functions;

import com.spring.microservices.accounts.service.AccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountFunctions {
    private final Logger log = LoggerFactory.getLogger(AccountFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(AccountsService accountsService) {
        return accountNumber -> {
            log.info("Updating communication for accountNumber: {}", accountNumber);
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }

}
