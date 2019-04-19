package vn.sapo.sync.service;

import vn.sapo.sync.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void saveAll(List<Product> products);

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(String id);

    void deleteById(String id);
}
