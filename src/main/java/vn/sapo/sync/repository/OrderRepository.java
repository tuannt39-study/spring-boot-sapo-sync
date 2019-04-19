package vn.sapo.sync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.sync.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
