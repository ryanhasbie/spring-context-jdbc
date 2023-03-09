package org.enigpush.config;

import org.enigpush.repository.BookRepository;
import org.enigpush.repository.IBookRepository;
import org.enigpush.service.BookService;
import org.enigpush.service.IBookService;
import org.enigpush.util.IRandomStringGenerator;
import org.enigpush.util.UuidGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Profile("!local")
@Configuration
@PropertySource("classpath:app-${spring.profiles.active}.properties")
public class BeanConfigurationProd {

    @Value("${client.header}")
    private String clientHeader;

    @Value("${driver}")
    private String dbDriver;

    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbUser;
    @Value("password")
    private String dbPassword;

    @Bean
    @Scope("singleton")
    public IBookService getBookService() {
        return new BookService(getBookRepository());
    }

    @Bean
    @Scope("prototype")
    public IBookRepository getBookRepository() {
        return new BookRepository(dataSource());
    }

    @Bean
    @Qualifier("randomUuid")
    @Primary
    public IRandomStringGenerator getRandomUuid() {
        return new UuidGenerator();
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);
        return driverManagerDataSource;
    }

}
