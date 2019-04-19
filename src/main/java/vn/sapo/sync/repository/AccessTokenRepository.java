package vn.sapo.sync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.sync.domain.AccessToken;

@Repository
public interface AccessTokenRepository extends MongoRepository<AccessToken, String> {
}
