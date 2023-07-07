package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This class acts as a Configuration class. And Spring needs to act according to the configurations defined here.
// So we can configure Beans here (Java Based Configuration) rather than using the XML
// The Configuration uses the package it is in as the base package
@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
    // As we will are defining Beans individually, no need to use the ComponentScan

    // The Doctor is not a Component now for Spring to scan.
    // We are defining the Doctor Bean ourselves.
    // Spring will load this bean
    // Whenever ApplicationContext will try to load the Bean Configuration from the BeanConfig class,
    // there is a method that is defined as a Bean, it will get treated as a Bean,
    // a new Doctor will be created with default constructor or whatever we are defining over here, and it will be available in the container.
//    @Bean
//    public Doctor doctor() {
//        return new Doctor();
//    }
}
