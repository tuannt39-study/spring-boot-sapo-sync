package vn.sapo.sync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.sync.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
