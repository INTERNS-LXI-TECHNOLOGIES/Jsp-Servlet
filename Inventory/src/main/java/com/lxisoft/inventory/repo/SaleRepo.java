/**
 * 
 */
package com.lxisoft.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.inventory.domain.Sale;

/**
 * @author mohamed anish
 *
 */
public interface SaleRepo extends JpaRepository<Sale, Integer> {

}
