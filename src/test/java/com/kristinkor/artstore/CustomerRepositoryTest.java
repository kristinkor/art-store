package com.kristinkor.artstore;

import com.kristinkor.artstore.model.Customer;
import com.kristinkor.artstore.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;


@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateAndFetchCustomer() {
        // Create a new customer
        Customer customer = new Customer();
        customer.setUserId("u12345");
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPassword("hashedpassword");
        customer.setAddressLine1("123 Main St");
        customer.setAddressLine2("Apt 4B");
        customer.setCity("Anytown");
        customer.setState("Anystate");
        customer.setZip("12345");
        customer.setBillingAddressLine1("456 Secondary St");
        customer.setBillingAddressLine2("Suite 1A");
        customer.setBillingCity("Othertown");
        customer.setBillingState("Otherstate");
        customer.setBillingZip("67890");
        customer.setPaymentMethod("Credit Card");
        customer.setCardNumber("4111111111111111");
        customer.setCardExpiration("12/25");
        customer.setCardCVC("123");
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());

        // Save the customer to the database
        Customer savedCustomer = customerRepository.save(customer);

        // Fetch the customer by ID
        Customer fetchedCustomer = customerRepository.findById(savedCustomer.getUserId()).orElse(null);

        // Assert that the fetched customer is not null and has the correct details
        assertThat(fetchedCustomer).isNotNull();
        assertThat(fetchedCustomer.getName()).isEqualTo("John Doe");
        assertThat(fetchedCustomer.getEmail()).isEqualTo("john.doe@example.com");
    }
}
