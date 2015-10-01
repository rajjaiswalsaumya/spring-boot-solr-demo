package org.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.test.models.Product;
import org.test.repositories.ProductRepository;

@SpringBootApplication
@EnableSolrRepositories(basePackages = "org.test.repositories")
public class SpringBootSolrDemoApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSolrDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        productRepository.save(new Product("1", "rohit"));
    }
}
