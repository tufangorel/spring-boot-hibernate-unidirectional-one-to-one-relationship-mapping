package com.company.customerinfo;


import com.company.customerinfo.model.Customer;
import com.company.customerinfo.model.ShippingAddress;
import com.company.customerinfo.service.CustomerService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = CustomerInfoApplication.class)
@ActiveProfiles("dev")
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Order(1)
    @Test
    public void saveCustomerTest() {

        Customer customer = new Customer();
        customer.setName("name1");
        customer.setAge(1);

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCountry("TR");
        shippingAddress.setCity("Ankara");
        shippingAddress.setStreetName("KaleSokak");
        customer.setShippingAddress(shippingAddress);

        Customer savedRecord = customerService.save(customer);
        assertThat( savedRecord.getShippingAddress() != null);
    }

    @Order(2)
    @Test
    public void findAllTest() {
        List<Customer> customerList =customerService.findAll();
        assertThat( customerList.size() > 0);
    }

}
