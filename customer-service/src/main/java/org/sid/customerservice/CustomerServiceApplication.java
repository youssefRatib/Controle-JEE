package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args -> {
          customerRepository.save(new Customer(null,"youssef","youssef@gmail.com"));
          customerRepository.save(new Customer(null,"yassine","yassine@gmail.com"));
          customerRepository.save(new Customer(null,"zakaria","zakaria@gmail.com"));
          customerRepository.findAll().forEach(c->{
              System.out.println(c.toString());
          });

        };
    }

}
