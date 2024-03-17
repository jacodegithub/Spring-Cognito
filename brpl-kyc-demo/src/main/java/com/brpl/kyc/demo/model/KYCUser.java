package com.brpl.kyc.demo.model;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
=======
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153

@Entity
@Table(name="kyc_user")
@NoArgsConstructor
@AllArgsConstructor
public class KYCUser {
<<<<<<< HEAD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String email;
	private String phone;
	private String panNumber;
	private String aadharNumber;
=======

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String aadharNumber;
    private String panNumber;
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
	
	
	public KYCUser() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


<<<<<<< HEAD
=======
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


<<<<<<< HEAD
	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
=======
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


<<<<<<< HEAD
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
=======
	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

		
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
	
}
