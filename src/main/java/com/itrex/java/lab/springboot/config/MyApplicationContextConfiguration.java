package com.itrex.java.lab.springboot.config;

import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.itrex.java.lab.springboot.properties.Properties.H2_PASSWORD;
import static com.itrex.java.lab.springboot.properties.Properties.H2_URL;
import static com.itrex.java.lab.springboot.properties.Properties.H2_USER;
import static com.itrex.java.lab.springboot.properties.Properties.MIGRATIONS_LOCATION;

@Configuration
@ComponentScan("com.itrex.java.lab.springboot")
public class MyApplicationContextConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure().dataSource(H2_URL, H2_USER, H2_PASSWORD).locations(MIGRATIONS_LOCATION)
                .load();
        return flyway;
    }

    @Bean
    public DataSource dataSource() {
        return JdbcConnectionPool.create(H2_URL, H2_USER, H2_PASSWORD);
    }
}
