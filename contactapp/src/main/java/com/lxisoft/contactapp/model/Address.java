package com.lxisoft.contactapp.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="houseName ", length = 20)
	private String houseName;
	
	@Column(name="street")
	private String street;
	
	@Column(name="district", length = 20)
	private String district;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="pincode")
	private String pincode;

	@OneToOne(mappedBy = "address")
	private Contact contact;
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getStreet() {
		return street;
	}


	public void setStreet( String street){
		this.street=street;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getNationality(){
		return nationality;
	}
	
	public void  setNationality(String nationality){
		this.nationality=nationality;
	}
	
	public String getPincode(){
		return pincode;
	}
	
	public void  setPincode(String pincode){
		this.pincode=pincode;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        if (address.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), address.getId());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
	
	@Override
	public String toString(){
		return "Address{" +
	            "id=" + getId() +
	            ", houseName='" + getHouseName() + "'" +
	            ", street='" + getStreet() + "'" +
	            ", district=" + getDistrict() +
	            ",nationality="+getNationality()+
	            ",pincode="+getPincode() +
	            "}";
		
	}	

}
