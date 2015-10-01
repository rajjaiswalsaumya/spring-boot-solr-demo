package org.test;

import org.apache.solr.client.solrj.SolrServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.test.models.Product;
import org.test.repositories.ProductRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootSolrDemoApplication.class)
@WebAppConfiguration
public class SpringBootSolrDemoApplicationTests {

    @Autowired
    SolrServer solrServer;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testSolrServerLoads() {
        assertNotNull(solrServer);
        assertNotNull(productRepository);
    }


    @Test
    public void saveProduct() {
        Product product = productRepository.save(new Product("1", "rohit"));
        assertNotNull(product);
        assertEquals(productRepository.findById("1").getId(), "1");
    }


}
