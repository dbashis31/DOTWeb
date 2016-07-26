package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "USER$SECURITY_PACKAGE" database table.
 * 
 */
@Entity
@Table(name="\"USER$SECURITY_PACKAGE\"")
@NamedQuery(name="User$securityPackage.findAll", query="SELECT u FROM User$securityPackage u")
public class User$securityPackage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="ACTIVE_YN")
	private String activeYn;

	@Column(name="SECURITY_PACKAGE_TYPE_ID")
	private BigDecimal securityPackageTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="UPDATED_USER_ID")
	private BigDecimal updatedUserId;

	@Column(name="USER_ID")
	private BigDecimal userId;

	public User$securityPackage() {
	}

	public String getActiveYn() {
		return this.activeYn;
	}

	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}

	public BigDecimal getSecurityPackageTypeId() {
		return this.securityPackageTypeId;
	}

	public void setSecurityPackageTypeId(BigDecimal securityPackageTypeId) {
		this.securityPackageTypeId = securityPackageTypeId;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public BigDecimal getUpdatedUserId() {
		return this.updatedUserId;
	}

	public void setUpdatedUserId(BigDecimal updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}