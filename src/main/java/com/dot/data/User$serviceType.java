package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "USER$SERVICE_TYPE" database table.
 * 
 */
@Entity
@Table(name="\"USER$SERVICE_TYPE\"")
@NamedQuery(name="User$serviceType.findAll", query="SELECT u FROM User$serviceType u")
public class User$serviceType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="ACTIVE_YN")
	private String activeYn;

	@Column(name="APPLICATION_SERVICE_ID")
	private BigDecimal applicationServiceId;

	@Column(name="AUTHORIZING_USER_ID")
	private BigDecimal authorizingUserId;

	@Column(name="DELETE_YN")
	private String deleteYn;

	@Column(name="INSERT_YN")
	private String insertYn;

	private String notes;

	@Column(name="SEQUENCE_NUMBER")
	private BigDecimal sequenceNumber;

	@Column(name="UPDATE_YN")
	private String updateYn;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="UPDATED_USER_ID")
	private BigDecimal updatedUserId;

	@Column(name="USER_ID")
	private BigDecimal userId;

	@Column(name="VALIDATE_YN")
	private String validateYn;

	@Column(name="VIEW_YN")
	private String viewYn;

	public User$serviceType() {
	}

	public String getActiveYn() {
		return this.activeYn;
	}

	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}

	public BigDecimal getApplicationServiceId() {
		return this.applicationServiceId;
	}

	public void setApplicationServiceId(BigDecimal applicationServiceId) {
		this.applicationServiceId = applicationServiceId;
	}

	public BigDecimal getAuthorizingUserId() {
		return this.authorizingUserId;
	}

	public void setAuthorizingUserId(BigDecimal authorizingUserId) {
		this.authorizingUserId = authorizingUserId;
	}

	public String getDeleteYn() {
		return this.deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getInsertYn() {
		return this.insertYn;
	}

	public void setInsertYn(String insertYn) {
		this.insertYn = insertYn;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(BigDecimal sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getUpdateYn() {
		return this.updateYn;
	}

	public void setUpdateYn(String updateYn) {
		this.updateYn = updateYn;
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

	public String getValidateYn() {
		return this.validateYn;
	}

	public void setValidateYn(String validateYn) {
		this.validateYn = validateYn;
	}

	public String getViewYn() {
		return this.viewYn;
	}

	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}