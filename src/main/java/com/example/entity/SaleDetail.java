package com.example.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Shop date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date shopDate;

    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @NotBlank(message = "Customer name is mandatory")
    private String custName;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    private String address;
    
    @NotBlank(message = "State is mandatory")
    private String state;

    
    @NotNull(message = "Date of birth is mandatory")
    @Temporal(TemporalType.DATE)
    @Past(message = "The date of birth is must be in the past")
    private Date dateOfBirth;
    private boolean minor;
    
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double price;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Pay amount must be greater than 0")
    private double payAmount;

    @Email(message = "Email should be valid")
    private String emailId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getShopDate() {
		return shopDate;
	}

	public void setShopDate(Date shopDate) {
		this.shopDate = shopDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isMinor() {
		return minor;
	}

	public void setMinor(boolean minor) {
		this.minor = minor;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public SaleDetail(Long id, Date shopDate, @Pattern(regexp = "(^$|[0-9]{10})") String mobileNo,
			@NotNull String custName, Item item, String address, String state, @Past Date dateOfBirth, boolean minor,
			int quantity, double price, double payAmount, @Email String emailId) {
		super();
		this.id = id;
		this.shopDate = shopDate;
		this.mobileNo = mobileNo;
		this.custName = custName;
		this.item = item;
		this.address = address;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
		this.minor = minor;
		this.quantity = quantity;
		this.price = price;
		this.payAmount = payAmount;
		this.emailId = emailId;
	}

	public SaleDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SaleDetail [id=" + id + ", shopDate=" + shopDate + ", mobileNo=" + mobileNo + ", custName=" + custName
				+ ", item=" + item + ", address=" + address + ", state=" + state + ", dateOfBirth=" + dateOfBirth
				+ ", minor=" + minor + ", quantity=" + quantity + ", price=" + price + ", payAmount=" + payAmount
				+ ", emailId=" + emailId + "]";
	}
	
	
    
    

    

}