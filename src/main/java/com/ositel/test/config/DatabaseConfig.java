package com.ositel.test.config;

/**
 * Created by DEFARTECH on 22/09/2018.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.ositel.test.repository")
@ComponentScan(basePackages = {"com.ositel.test.entity"})
@EnableTransactionManagement
public class DatabaseConfig {

}
