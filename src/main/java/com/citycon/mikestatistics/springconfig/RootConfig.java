package com.citycon.mikestatistics.springconfig;

import com.citycon.mikestatistics.repositories.UserStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages="com.zoxal", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})

public class RootConfig {
    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
        factory.setJndiName("jdbc/City");
        factory.setProxyInterface(DataSource.class);
        return factory;
    }

    @Bean
    @Autowired
    @Qualifier("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Autowired
    public UserStatisticsRepository userStatisticsRepository(JdbcOperations repo) {
        return new UserStatisticsRepository(repo);
    }
}