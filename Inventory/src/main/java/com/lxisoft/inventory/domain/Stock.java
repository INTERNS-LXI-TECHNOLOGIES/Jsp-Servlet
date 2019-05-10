/**
 * 
 */
package com.lxisoft.inventory.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * @author mohamed anish
 *
 */
@Data
@Entity
public class Stock {

	@Id
	@GeneratedValue
	int id;
	@OneToOne(cascade = {CascadeType.ALL})
	Product product;
	int quantity;
	
}
