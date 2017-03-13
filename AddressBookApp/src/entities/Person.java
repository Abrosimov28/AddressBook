package entities;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String country;
	private String phone;
	
	public Person(String firstName, String lastName, String address, String country, String phone){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.country = country;
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
