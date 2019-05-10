/**
 * 
 */
package com.lxisoft.inventory.service;

import java.util.List;

import com.lxisoft.inventory.domain.Sale;
import com.lxisoft.inventory.domain.Stock;

/**
 * @author mohamed anish
 *
 */
public interface InventoryService {
	public Stock createStock(Stock stock);
	public List<Stock> getStock();
	public Sale saleProduct(Sale sale);
}
