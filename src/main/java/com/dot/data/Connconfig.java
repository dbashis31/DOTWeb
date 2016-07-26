package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the CONNCONFIG database table.
 * 
 */
@Entity
@NamedQuery(name="Connconfig.findAll", query="SELECT c FROM Connconfig c")
public class Connconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CONNCONFIG_CAST_ROWCOUNT")
	private String connconfigCastRowcount;

	@Column(name="CONNCONFIG_COL_REQ_QUOTES")
	private String connconfigColReqQuotes;

	@Column(name="CONNCONFIG_DBTYPE")
	private String connconfigDbtype;

	@Column(name="CONNCONFIG_DRIVER")
	private String connconfigDriver;

	@Column(name="CONNCONFIG_HAS_SQL_TIMEOUT")
	private String connconfigHasSqlTimeout;

	@Id
	@Column(name="CONNCONFIG_ID")
	private String connconfigId;

	@Column(name="CONNCONFIG_INS_TEMPLATE")
	private String connconfigInsTemplate;

	@Column(name="CONNCONFIG_MAXCONN")
	private BigDecimal connconfigMaxconn;

	@Column(name="CONNCONFIG_MAXCURSER")
	private BigDecimal connconfigMaxcurser;

	@Column(name="CONNCONFIG_PORT")
	private BigDecimal connconfigPort;

	@Column(name="CONNCONFIG_QUOTE_CHAR")
	private String connconfigQuoteChar;

	@Column(name="CONNCONFIG_ROW_CNT_QRY")
	private String connconfigRowCntQry;

	@Column(name="CONNCONFIG_ROW_TEMPLATE")
	private String connconfigRowTemplate;

	@Column(name="CONNCONFIG_SCPATMASK")
	private String connconfigScpatmask;

	@Column(name="CONNCONFIG_SQL_DIALECT")
	private String connconfigSqlDialect;

	@Column(name="CONNCONFIG_TABLE_FORMAT")
	private String connconfigTableFormat;

	@Column(name="CONNCONFIG_TEMPLATE")
	private String connconfigTemplate;

	@Column(name="CONNCONFIG_VWBODY_QUERY")
	private String connconfigVwbodyQuery;

	public Connconfig() {
	}

	public String getConnconfigCastRowcount() {
		return this.connconfigCastRowcount;
	}

	public void setConnconfigCastRowcount(String connconfigCastRowcount) {
		this.connconfigCastRowcount = connconfigCastRowcount;
	}

	public String getConnconfigColReqQuotes() {
		return this.connconfigColReqQuotes;
	}

	public void setConnconfigColReqQuotes(String connconfigColReqQuotes) {
		this.connconfigColReqQuotes = connconfigColReqQuotes;
	}

	public String getConnconfigDbtype() {
		return this.connconfigDbtype;
	}

	public void setConnconfigDbtype(String connconfigDbtype) {
		this.connconfigDbtype = connconfigDbtype;
	}

	public String getConnconfigDriver() {
		return this.connconfigDriver;
	}

	public void setConnconfigDriver(String connconfigDriver) {
		this.connconfigDriver = connconfigDriver;
	}

	public String getConnconfigHasSqlTimeout() {
		return this.connconfigHasSqlTimeout;
	}

	public void setConnconfigHasSqlTimeout(String connconfigHasSqlTimeout) {
		this.connconfigHasSqlTimeout = connconfigHasSqlTimeout;
	}

	public String getConnconfigId() {
		return this.connconfigId;
	}

	public void setConnconfigId(String connconfigId) {
		this.connconfigId = connconfigId;
	}

	public String getConnconfigInsTemplate() {
		return this.connconfigInsTemplate;
	}

	public void setConnconfigInsTemplate(String connconfigInsTemplate) {
		this.connconfigInsTemplate = connconfigInsTemplate;
	}

	public BigDecimal getConnconfigMaxconn() {
		return this.connconfigMaxconn;
	}

	public void setConnconfigMaxconn(BigDecimal connconfigMaxconn) {
		this.connconfigMaxconn = connconfigMaxconn;
	}

	public BigDecimal getConnconfigMaxcurser() {
		return this.connconfigMaxcurser;
	}

	public void setConnconfigMaxcurser(BigDecimal connconfigMaxcurser) {
		this.connconfigMaxcurser = connconfigMaxcurser;
	}

	public BigDecimal getConnconfigPort() {
		return this.connconfigPort;
	}

	public void setConnconfigPort(BigDecimal connconfigPort) {
		this.connconfigPort = connconfigPort;
	}

	public String getConnconfigQuoteChar() {
		return this.connconfigQuoteChar;
	}

	public void setConnconfigQuoteChar(String connconfigQuoteChar) {
		this.connconfigQuoteChar = connconfigQuoteChar;
	}

	public String getConnconfigRowCntQry() {
		return this.connconfigRowCntQry;
	}

	public void setConnconfigRowCntQry(String connconfigRowCntQry) {
		this.connconfigRowCntQry = connconfigRowCntQry;
	}

	public String getConnconfigRowTemplate() {
		return this.connconfigRowTemplate;
	}

	public void setConnconfigRowTemplate(String connconfigRowTemplate) {
		this.connconfigRowTemplate = connconfigRowTemplate;
	}

	public String getConnconfigScpatmask() {
		return this.connconfigScpatmask;
	}

	public void setConnconfigScpatmask(String connconfigScpatmask) {
		this.connconfigScpatmask = connconfigScpatmask;
	}

	public String getConnconfigSqlDialect() {
		return this.connconfigSqlDialect;
	}

	public void setConnconfigSqlDialect(String connconfigSqlDialect) {
		this.connconfigSqlDialect = connconfigSqlDialect;
	}

	public String getConnconfigTableFormat() {
		return this.connconfigTableFormat;
	}

	public void setConnconfigTableFormat(String connconfigTableFormat) {
		this.connconfigTableFormat = connconfigTableFormat;
	}

	public String getConnconfigTemplate() {
		return this.connconfigTemplate;
	}

	public void setConnconfigTemplate(String connconfigTemplate) {
		this.connconfigTemplate = connconfigTemplate;
	}

	public String getConnconfigVwbodyQuery() {
		return this.connconfigVwbodyQuery;
	}

	public void setConnconfigVwbodyQuery(String connconfigVwbodyQuery) {
		this.connconfigVwbodyQuery = connconfigVwbodyQuery;
	}

}