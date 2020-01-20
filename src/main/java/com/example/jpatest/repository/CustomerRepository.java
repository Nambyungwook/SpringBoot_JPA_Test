package com.example.jpatest.repository;

import com.example.jpatest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public List<Customer> findByName(String name);
    public List<Customer> findByPhone(String phone);
    public List<Customer> findByNameLike(String keyword);
}
