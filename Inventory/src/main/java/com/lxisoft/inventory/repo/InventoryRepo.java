/**
 * 
 */
package com.lxisoft.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.inventory.domain.Stock;

/**
 * @author mohamed anish
 *
 */
public interface InventoryRepo extends JpaRepository<Stock, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Stock u set u.quantity = :quantity where u.id = :id")
	public void updateStock(@Param("quantity")int quantity,@Param("id")int id);
	
	public Stock findByProduct_id(int id);
}
