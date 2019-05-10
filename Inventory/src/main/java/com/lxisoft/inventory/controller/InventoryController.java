/**
 * 
 */
package com.lxisoft.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.inventory.domain.Sale;
import com.lxisoft.inventory.domain.Stock;
import com.lxisoft.inventory.service.InventoryServiceImpl;

/**
 * @author mohamed anish
 *
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryServiceImpl inventoryService;

	@PutMapping("/create")
	public Stock createStock(@RequestBody Stock stock ) {
		return inventoryService.createStock(stock);
	}
	
	@GetMapping("/get")
	public List<Stock> getStock(){
		return inventoryService.getStock();
	}
	@PutMapping("/sale")
	public Sale saleProduct(@RequestBody Sale sale) {
		return inventoryService.saleProduct(sale);
	}
}
