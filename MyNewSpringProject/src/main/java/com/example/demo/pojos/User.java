package com.example.demo.pojos;

	import javax.persistence.Column;

	import javax.persistence.Entity;

	//import javax.persistence.GeneratedValue;

	//import javax.persistence.GenerationType;

	import javax.persistence.Id;

	import javax.persistence.Table;

	@Entity

	@Table(name="Users")

	public class User {
	 @Id
	 private String username;
	 @Column(name="password" , nullable=false , length=100)
	private String password;
	 private String firstname;
	 private String lastname;
	 private String email;
	 private String gender;
	 private String address;
	 private int phone;
	 
	 public String getUsername() {
	 return username;
	 }
	 public void setUsername(String username) {
	 this.username = username;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 }
	 public String getFirstname() {
	 return firstname;
	 }
	 public void setFirstname(String firstname) {
	 this.firstname = firstname;
	 }
	 public String getLastname() {
	 return lastname;
	 }
	 public void setLastname(String lastname) {
	 this.lastname = lastname;
	 }
	 public String getGender() {

	 return gender;
	}
	public void setGender(String gender) {
	 this.gender = gender;
	}
	 public String getEmail() {
	 return email;
	 }
	 public void setEmail(String email) {
 this.email = email;
	 }
	 public String getAddress() {
	 return address;
	 }

 public void setAddress(String address) {
	 this.address = address;
	 }
	 public int getPhone() {
	 return phone;
	 }
	 public void setPhone(int phone) {
	 this.phone = phone;
	 }
	 @Override

	 public String toString() {

	 return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
	 + lastname + ", email=" + email + ", gender=" + gender + ", address=" + address + ", phone=" + phone + "]";
	 }
	}

