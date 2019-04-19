package vn.sapo.sync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.sync.domain.Variant;

@Repository
public interface VariantRepository extends MongoRepository<Variant, String> {
}
