package jp.co.sample.domain;

import java.time.LocalDate;

/**
 * 従業員情報を表すドメインクラス
 * @author daiki.takayama
 */
public class Employee {

	private Integer id;
	private String name;
	private String image;
	private String gender;
	private LocalDate hireDate;
	private String mailAddress;
	private String zip_code;
	private String address;
	private String telephone;
	private Integer salary;
	private String characteristics;
	private Integer dependentsCount;
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, String image, String gender, LocalDate hire_date, String mail_address,
			String zip_code, String address, String telephone, Integer salary, String characteristics,
			Integer dependents_count) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hire_date;
		this.mailAddress = mail_address;
		this.zip_code = zip_code;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependentsCount = dependents_count;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getHire_date() {
		return hireDate;
	}
	public void setHire_date(LocalDate hire_date) {
		this.hireDate = hire_date;
	}
	public String getMail_address() {
		return mailAddress;
	}
	public void setMail_address(String mail_address) {
		this.mailAddress = mail_address;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public Integer getDependents_count() {
		return dependentsCount;
	}
	public void setDependents_count(Integer dependents_count) {
		this.dependentsCount = dependents_count;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hire_date="
				+ hireDate + ", mail_address=" + mailAddress + ", zip_code=" + zip_code + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependents_count=" + dependentsCount + "]";
	}
	
	
}
