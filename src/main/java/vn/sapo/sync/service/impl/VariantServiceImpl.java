package vn.sapo.sync.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.sapo.sync.domain.Variant;
import vn.sapo.sync.repository.VariantRepository;
import vn.sapo.sync.service.VariantService;

import java.util.List;
import java.util.Optional;

@Service
public class VariantServiceImpl implements VariantService {

    private final Logger log = LoggerFactory.getLogger(VariantServiceImpl.class);

    private final VariantRepository variantRepository;

    public VariantServiceImpl(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    @Override
    public void saveAll(List<Variant> variants) {
        List<Variant> saved = variantRepository.saveAll(variants);
        log.debug("Request to saveAll {} Variant", saved.size());
    }

    @Override
    public Variant save(Variant variant) {
        log.debug("Request to save Variant : {}", variant);
        return variantRepository.save(variant);
    }

    @Override
    public List<Variant> findAll() {
        log.debug("Request to get all Variants");
        return variantRepository.findAll();
    }

    @Override
    public Optional<Variant> findById(String id) {
        log.debug("Request to get Variant : {}", id);
        return variantRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        log.debug("Request to delete Variant : {}", id);
        variantRepository.deleteById(id);
    }
}
