/**
 * 
 */
package com.lxisoft.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.inventory.domain.Product;
import com.lxisoft.inventory.domain.Sale;
import com.lxisoft.inventory.domain.Stock;
import com.lxisoft.inventory.repo.InventoryRepo;
import com.lxisoft.inventory.repo.SaleRepo;

/**
 * @author mohamed anish
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepo inventoryRepo;
	@Autowired
	SaleRepo saleRepo;
	
	public Stock createStock(Stock stock) {
		return inventoryRepo.save(stock);
	}
	public List<Stock> getStock() {
		return inventoryRepo.findAll();
	}
	public Sale saleProduct(Sale sale) {
		for(Product p:sale.getProduct()) {
			Stock stock = inventoryRepo.findByProduct_id(p.getId());
			int quantity = stock.getQuantity()-sale.getQuantity();
			inventoryRepo.updateStock(quantity, stock.getId());
		} 
		
		return saleRepo.save(sale);
	}

}
