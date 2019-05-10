/**
 * 
 */
package com.lxisoft.inventory.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author mohamed anish
 *
 */
@Data
@Entity
public class Sale {
	
	@Id
	@GeneratedValue
	int id;
	@ManyToMany(cascade = {CascadeType.MERGE})
	List<Product> product;
	int quantity;
}
