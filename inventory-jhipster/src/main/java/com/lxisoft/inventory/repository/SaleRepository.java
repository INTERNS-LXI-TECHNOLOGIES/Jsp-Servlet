package com.lxisoft.inventory.repository;

import com.lxisoft.inventory.domain.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Sale entity.
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "select distinct sale from Sale sale left join fetch sale.products",
        countQuery = "select count(distinct sale) from Sale sale")
    Page<Sale> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct sale from Sale sale left join fetch sale.products")
    List<Sale> findAllWithEagerRelationships();

    @Query("select sale from Sale sale left join fetch sale.products where sale.id =:id")
    Optional<Sale> findOneWithEagerRelationships(@Param("id") Long id);

}
