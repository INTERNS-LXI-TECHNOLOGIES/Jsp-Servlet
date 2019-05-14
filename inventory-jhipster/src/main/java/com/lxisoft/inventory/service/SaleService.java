package com.lxisoft.inventory.service;

import com.lxisoft.inventory.domain.Sale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Sale}.
 */
public interface SaleService {

    /**
     * Save a sale.
     *
     * @param sale the entity to save.
     * @return the persisted entity.
     */
    Sale save(Sale sale);

    /**
     * Get all the sales.
     *
     * @return the list of entities.
     */
    List<Sale> findAll();

    /**
     * Get all the sales with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<Sale> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" sale.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Sale> findOne(Long id);

    /**
     * Delete the "id" sale.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
