package vn.sapo.sync.service;

import vn.sapo.sync.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void saveAll(List<Order> orders);

    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(String id);

    void deleteById(String id);

}
