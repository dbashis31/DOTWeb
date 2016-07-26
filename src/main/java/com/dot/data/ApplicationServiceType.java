package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the APPLICATION_SERVICE_TYPE database table.
 * 
 */
@Entity
@Table(name="APPLICATION_SERVICE_TYPE")
@NamedQuery(name="ApplicationServiceType.findAll", query="SELECT a FROM ApplicationServiceType a")
public class ApplicationServiceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_SERVICE_ID")
	private long applicationServiceId;

	@Column(name="ACTIVE_YN")
	private String activeYn;

	@Column(name="ADD_YN")
	private String addYn;

	@Column(name="APPLICATION_SERVICE_NAME")
	private String applicationServiceName;

	@Column(name="APPLICATION_SERVICE_TYPE")
	private String applicationServiceType;

	@Column(name="CALL_TREE_YN")
	private String callTreeYn;

	@Column(name="CLASS_ID")
	private BigDecimal classId;

	private String description;

	@Column(name="DPO_MODE")
	private String dpoMode;

	@Column(name="DPO_NAME")
	private String dpoName;

	@Column(name="DPO_TYPE")
	private String dpoType;

	@Column(name="EDIT_YN")
	private String editYn;

	@Column(name="HOT_KEY")
	private String hotKey;

	@Column(name="INVOICE_YN")
	private String invoiceYn;

	@Column(name="IWS_YN")
	private String iwsYn;

	@Column(name="PARENT_APPLICATION_SERVICE_ID")
	private BigDecimal parentApplicationServiceId;

	@Column(name="PICTURE_INDEX")
	private BigDecimal pictureIndex;

	@Column(name="PORTAL_YN")
	private String portalYn;

	@Column(name="REMOVE_YN")
	private String removeYn;

	@Column(name="RFS_STATE_DEPENDENT_YN")
	private String rfsStateDependentYn;

	@Column(name="RFS_TYPE_DEPENDENT_YN")
	private String rfsTypeDependentYn;

	@Column(name="RFS_YN")
	private String rfsYn;

	@Column(name="SELECTED_PICTURE_INDEX")
	private BigDecimal selectedPictureIndex;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="UPDATED_USER_ID")
	private BigDecimal updatedUserId;

	@Column(name="VENDOR_YN")
	private String vendorYn;

	@Column(name="VERIFY_YN")
	private String verifyYn;

	@Column(name="VIEW_YN")
	private String viewYn;

	@Column(name="WEB_YN")
	private String webYn;

	public ApplicationServiceType() {
	}

	public long getApplicationServiceId() {
		return this.applicationServiceId;
	}

	public void setApplicationServiceId(long applicationServiceId) {
		this.applicationServiceId = applicationServiceId;
	}

	public String getActiveYn() {
		return this.activeYn;
	}

	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}

	public String getAddYn() {
		return this.addYn;
	}

	public void setAddYn(String addYn) {
		this.addYn = addYn;
	}

	public String getApplicationServiceName() {
		return this.applicationServiceName;
	}

	public void setApplicationServiceName(String applicationServiceName) {
		this.applicationServiceName = applicationServiceName;
	}

	public String getApplicationServiceType() {
		return this.applicationServiceType;
	}

	public void setApplicationServiceType(String applicationServiceType) {
		this.applicationServiceType = applicationServiceType;
	}

	public String getCallTreeYn() {
		return this.callTreeYn;
	}

	public void setCallTreeYn(String callTreeYn) {
		this.callTreeYn = callTreeYn;
	}

	public BigDecimal getClassId() {
		return this.classId;
	}

	public void setClassId(BigDecimal classId) {
		this.classId = classId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDpoMode() {
		return this.dpoMode;
	}

	public void setDpoMode(String dpoMode) {
		this.dpoMode = dpoMode;
	}

	public String getDpoName() {
		return this.dpoName;
	}

	public void setDpoName(String dpoName) {
		this.dpoName = dpoName;
	}

	public String getDpoType() {
		return this.dpoType;
	}

	public void setDpoType(String dpoType) {
		this.dpoType = dpoType;
	}

	public String getEditYn() {
		return this.editYn;
	}

	public void setEditYn(String editYn) {
		this.editYn = editYn;
	}

	public String getHotKey() {
		return this.hotKey;
	}

	public void setHotKey(String hotKey) {
		this.hotKey = hotKey;
	}

	public String getInvoiceYn() {
		return this.invoiceYn;
	}

	public void setInvoiceYn(String invoiceYn) {
		this.invoiceYn = invoiceYn;
	}

	public String getIwsYn() {
		return this.iwsYn;
	}

	public void setIwsYn(String iwsYn) {
		this.iwsYn = iwsYn;
	}

	public BigDecimal getParentApplicationServiceId() {
		return this.parentApplicationServiceId;
	}

	public void setParentApplicationServiceId(BigDecimal parentApplicationServiceId) {
		this.parentApplicationServiceId = parentApplicationServiceId;
	}

	public BigDecimal getPictureIndex() {
		return this.pictureIndex;
	}

	public void setPictureIndex(BigDecimal pictureIndex) {
		this.pictureIndex = pictureIndex;
	}

	public String getPortalYn() {
		return this.portalYn;
	}

	public void setPortalYn(String portalYn) {
		this.portalYn = portalYn;
	}

	public String getRemoveYn() {
		return this.removeYn;
	}

	public void setRemoveYn(String removeYn) {
		this.removeYn = removeYn;
	}

	public String getRfsStateDependentYn() {
		return this.rfsStateDependentYn;
	}

	public void setRfsStateDependentYn(String rfsStateDependentYn) {
		this.rfsStateDependentYn = rfsStateDependentYn;
	}

	public String getRfsTypeDependentYn() {
		return this.rfsTypeDependentYn;
	}

	public void setRfsTypeDependentYn(String rfsTypeDependentYn) {
		this.rfsTypeDependentYn = rfsTypeDependentYn;
	}

	public String getRfsYn() {
		return this.rfsYn;
	}

	public void setRfsYn(String rfsYn) {
		this.rfsYn = rfsYn;
	}

	public BigDecimal getSelectedPictureIndex() {
		return this.selectedPictureIndex;
	}

	public void setSelectedPictureIndex(BigDecimal selectedPictureIndex) {
		this.selectedPictureIndex = selectedPictureIndex;
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

	public String getVendorYn() {
		return this.vendorYn;
	}

	public void setVendorYn(String vendorYn) {
		this.vendorYn = vendorYn;
	}

	public String getVerifyYn() {
		return this.verifyYn;
	}

	public void setVerifyYn(String verifyYn) {
		this.verifyYn = verifyYn;
	}

	public String getViewYn() {
		return this.viewYn;
	}

	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}

	public String getWebYn() {
		return this.webYn;
	}

	public void setWebYn(String webYn) {
		this.webYn = webYn;
	}

}