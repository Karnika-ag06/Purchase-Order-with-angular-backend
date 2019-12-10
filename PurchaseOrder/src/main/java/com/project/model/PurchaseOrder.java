  
package com.project.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Table_Purchaseorder")
public class PurchaseOrder {
	

	@Id
	@Column(name="purchaseOrder_Id")
	@GeneratedValue
	private int purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	private User userObj;
	
    @ManyToOne
	@JoinColumn(name="Seller_Id")
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL)
	private List<PurchaseOrderItems> purchaseOrderItemsObj;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_Date")
	private LocalDate createdDate;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<PurchaseOrderItems> getPurchaseOrderItemsObj() {
		return purchaseOrderItemsObj;
	}

	public void setPurchaseOrderItemsObj(List<PurchaseOrderItems> purchaseOrderItemsObj) {
		this.purchaseOrderItemsObj = purchaseOrderItemsObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
    