package vn.sapo.sync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.sync.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
