package com.example.TanKhoaLearningCenterBE.web.rest.old;

import com.example.TanKhoaLearningCenterBE.entity.old.CustomerEntity;
import com.example.TanKhoaLearningCenterBE.repository.old.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(customerRepository.findById(id).get());
    }
}
