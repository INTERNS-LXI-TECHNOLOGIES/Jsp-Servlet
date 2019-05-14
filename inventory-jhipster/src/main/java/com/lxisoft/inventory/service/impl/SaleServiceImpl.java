package com.lxisoft.inventory.service.impl;

import com.lxisoft.inventory.service.SaleService;
import com.lxisoft.inventory.domain.Sale;
import com.lxisoft.inventory.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Sale}.
 */
@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    /**
     * Save a sale.
     *
     * @param sale the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Sale save(Sale sale) {
        log.debug("Request to save Sale : {}", sale);
        return saleRepository.save(sale);
    }

    /**
     * Get all the sales.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        log.debug("Request to get all Sales");
        return saleRepository.findAllWithEagerRelationships();
    }

    /**
     * Get all the sales with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<Sale> findAllWithEagerRelationships(Pageable pageable) {
        return saleRepository.findAllWithEagerRelationships(pageable);
    }
    

    /**
     * Get one sale by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Sale> findOne(Long id) {
        log.debug("Request to get Sale : {}", id);
        return saleRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the sale by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sale : {}", id);
        saleRepository.deleteById(id);
    }
}
