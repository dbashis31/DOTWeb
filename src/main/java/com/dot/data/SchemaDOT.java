package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the "SCHEMA" database table.
 * 
 */
@Entity
@Table(name="\"SCHEMA\"")
@NamedQuery(name="SchemaDOT.findAll", query="SELECT s FROM SchemaDOT s")
public class SchemaDOT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SCHEMA_ID")
	private String schemaId;

	@Column(name="SCHEMA_ADDED_BY")
	private String schemaAddedBy;

	@Column(name="SCHEMA_ADDED_ON")
	private BigDecimal schemaAddedOn;

	@Column(name="SCHEMA_BYTES")
	private BigDecimal schemaBytes;

	@Column(name="SCHEMA_COLUMN_COUNT")
	private BigDecimal schemaColumnCount;

	@Column(name="SCHEMA_GROUP")
	private String schemaGroup;

	@Column(name="SCHEMA_NAME")
	private String schemaName;

	@Column(name="SCHEMA_PASSWORD")
	private String schemaPassword;

	@Column(name="SCHEMA_TABLE_COUNT")
	private BigDecimal schemaTableCount;

	@Column(name="SCHEMA_TYPE")
	private String schemaType;

	@Column(name="SCHEMA_USERNAME")
	private String schemaUsername;
	
	@Column(name="SCHEMA_CONNECTION_ID")
	private String connectionId;

	//bi-directional many-to-one association to Connection
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SCHEMA_CONNECTION_ID")
	private Connection connection;*/

	/*//bi-directional many-to-one association to SimilarTable
	@OneToMany(mappedBy="schema1")
	private List<SimilarTable> similarTables1;

	//bi-directional many-to-one association to SimilarTable
	@OneToMany(mappedBy="schema2")
	private List<SimilarTable> similarTables2;*/

	/*//bi-directional many-to-one association to Table
	@OneToMany(mappedBy="schema")
	private List<Table> tables;*/

	public SchemaDOT() {
	}

	public String getSchemaAddedBy() {
		return this.schemaAddedBy;
	}

	public void setSchemaAddedBy(String schemaAddedBy) {
		this.schemaAddedBy = schemaAddedBy;
	}

	public BigDecimal getSchemaAddedOn() {
		return this.schemaAddedOn;
	}

	public void setSchemaAddedOn(BigDecimal schemaAddedOn) {
		this.schemaAddedOn = schemaAddedOn;
	}

	public BigDecimal getSchemaBytes() {
		return this.schemaBytes;
	}

	public void setSchemaBytes(BigDecimal schemaBytes) {
		this.schemaBytes = schemaBytes;
	}

	public BigDecimal getSchemaColumnCount() {
		return this.schemaColumnCount;
	}

	public void setSchemaColumnCount(BigDecimal schemaColumnCount) {
		this.schemaColumnCount = schemaColumnCount;
	}

	public String getSchemaGroup() {
		return this.schemaGroup;
	}

	public void setSchemaGroup(String schemaGroup) {
		this.schemaGroup = schemaGroup;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	
	public String getSchemaId() {
		return this.schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getSchemaPassword() {
		return this.schemaPassword;
	}

	public void setSchemaPassword(String schemaPassword) {
		this.schemaPassword = schemaPassword;
	}

	public BigDecimal getSchemaTableCount() {
		return this.schemaTableCount;
	}

	public void setSchemaTableCount(BigDecimal schemaTableCount) {
		this.schemaTableCount = schemaTableCount;
	}

	public String getSchemaType() {
		return this.schemaType;
	}

	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
	}

	public String getSchemaUsername() {
		return this.schemaUsername;
	}

	public void setSchemaUsername(String schemaUsername) {
		this.schemaUsername = schemaUsername;
	}
	
	public String getConnectionId() {
		return this.connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	/*public Connection getConnection() {
		return this.connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}*/

	/*public List<SimilarTable> getSimilarTables1() {
		return this.similarTables1;
	}

	public void setSimilarTables1(List<SimilarTable> similarTables1) {
		this.similarTables1 = similarTables1;
	}*/

	/*public SimilarTable addSimilarTables1(SimilarTable similarTables1) {
		getSimilarTables1().add(similarTables1);
		similarTables1.setSchema1(this);

		return similarTables1;
	}

	public SimilarTable removeSimilarTables1(SimilarTable similarTables1) {
		getSimilarTables1().remove(similarTables1);
		similarTables1.setSchema1(null);

		return similarTables1;
	}*/

	/*public List<SimilarTable> getSimilarTables2() {
		return this.similarTables2;
	}

	public void setSimilarTables2(List<SimilarTable> similarTables2) {
		this.similarTables2 = similarTables2;
	}*/

	/*public SimilarTable addSimilarTables2(SimilarTable similarTables2) {
		getSimilarTables2().add(similarTables2);
		similarTables2.setSchema2(this);

		return similarTables2;
	}

	public SimilarTable removeSimilarTables2(SimilarTable similarTables2) {
		getSimilarTables2().remove(similarTables2);
		similarTables2.setSchema2(null);

		return similarTables2;
	}*/

	/*public List<Table> getTables() {
		return this.tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}*/

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (schemaId != null ? schemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchemaDOT)) {
            return false;
        }
        SchemaDOT other = (SchemaDOT) object;
        if ((this.schemaId == null && other.schemaId != null) || (this.schemaId != null && !this.schemaId.equals(other.schemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return schemaName;
    }

}