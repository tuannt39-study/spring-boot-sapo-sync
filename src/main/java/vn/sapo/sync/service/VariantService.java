package vn.sapo.sync.service;

import vn.sapo.sync.domain.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {

    void saveAll(List<Variant> variants);

    Variant save(Variant variant);

    List<Variant> findAll();

    Optional<Variant> findById(String id);

    void deleteById(String id);

}
