/**
 * 
 */
package com.lxisoft.inventory.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author mohamed anish
 *
 */
@Data
@Entity
public class Product {

	@Id
	@GeneratedValue
	int id;
	String name;
	String price;
	@ManyToMany(mappedBy = "product")
	List<Sale> sale;
	
	
}
