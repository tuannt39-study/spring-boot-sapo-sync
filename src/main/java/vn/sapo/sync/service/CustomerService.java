package vn.sapo.sync.service;

import vn.sapo.sync.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void saveAll(List<Customer> customers);

    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(String id);

    void deleteById(String id);

}
