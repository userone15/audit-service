package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_audit_order")
public class Order {

	public Order(){
		
	}
	
	public Order(String systemUrl, String orderNumber) {
		super();
		this.systemUrl = systemUrl;
		this.orderNumber = orderNumber;
	}
	
	@Id
	@Column(name = "order_number")
	private String orderNumber;	
	
	@Column(name = "system_url")
	private String systemUrl;

	public String getSystemUrl() {
		return systemUrl;
	}

	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}

