package org.enigpush.config;

import org.enigpush.repository.BookArrayRepository;
import org.enigpush.repository.BookRepository;
import org.enigpush.repository.IBookRepository;
import org.enigpush.service.BookService;
import org.enigpush.service.IBookService;
import org.enigpush.util.IRandomStringGenerator;
import org.enigpush.util.UuidGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@Profile("local")
@Configuration
@PropertySource("classpath:app-${spring.profiles.active}.properties")
public class BeanConfigurationDev {
    @Value("${GENERATOR}")
    String randomGenerator;

    @Bean
    @Scope("singleton")
    public IBookService getBookService() {
       return new BookService(getBookArrayRepository());
    }

    @Bean
    @Scope("prototype")
    public IBookRepository getBookArrayRepository() {
        return new BookArrayRepository(getUuidGenerator());
    }

    @Bean
    @Qualifier("randomUuid")
    public IRandomStringGenerator getUuidGenerator() {
        return new UuidGenerator();
    }

}
