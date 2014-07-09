package com.hachiyae.boot.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hachiyae.boot.entity.Customer;
import com.hachiyae.boot.repository.CustomerRepository;

@Service
public class TestService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer find(int id) {
        return customerRepository.findOne((long)id);
    }
}
