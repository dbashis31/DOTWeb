package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the COLUMN_INDEX database table.
 * 
 */
@Entity
@Table(name="COLUMN_INDEX")
@NamedQuery(name="ColumnIndex.findAll", query="SELECT c FROM ColumnIndex c")
public class ColumnIndex implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="COLUMN_INDEX_ID")
	private String columnIndexId;

	@Column(name="COLUMN_INDEX_ADDED_BY")
	private String columnIndexAddedBy;

	@Column(name="COLUMN_INDEX_ADDED_ON")
	private BigDecimal columnIndexAddedOn;

	@Column(name="COLUMN_INDEX_NAME")
	private String columnIndexName;

	@Column(name="COLUMN_INDEX_ORDER")
	private String columnIndexOrder;

	@Column(name="COLUMN_INDEX_TYPE")
	private String columnIndexType;

	/*//bi-directional many-to-one association to Column
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COLUMN_INDEX_COLUMN_ID", referencedColumnName="COLUMN_ID")
	private Column column;*/

	public ColumnIndex() {
	}

	public String getColumnIndexId() {
		return this.columnIndexId;
	}

	public void setColumnIndexId(String columnIndexId) {
		this.columnIndexId = columnIndexId;
	}

	public String getColumnIndexAddedBy() {
		return this.columnIndexAddedBy;
	}

	public void setColumnIndexAddedBy(String columnIndexAddedBy) {
		this.columnIndexAddedBy = columnIndexAddedBy;
	}

	public BigDecimal getColumnIndexAddedOn() {
		return this.columnIndexAddedOn;
	}

	public void setColumnIndexAddedOn(BigDecimal columnIndexAddedOn) {
		this.columnIndexAddedOn = columnIndexAddedOn;
	}

	public String getColumnIndexName() {
		return this.columnIndexName;
	}

	public void setColumnIndexName(String columnIndexName) {
		this.columnIndexName = columnIndexName;
	}

	public String getColumnIndexOrder() {
		return this.columnIndexOrder;
	}

	public void setColumnIndexOrder(String columnIndexOrder) {
		this.columnIndexOrder = columnIndexOrder;
	}

	public String getColumnIndexType() {
		return this.columnIndexType;
	}

	public void setColumnIndexType(String columnIndexType) {
		this.columnIndexType = columnIndexType;
	}

	/*public Column getColumn() {
		return this.column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}*/
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (columnIndexId != null ? columnIndexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnIndex)) {
            return false;
        }
        ColumnIndex other = (ColumnIndex) object;
        if ((this.columnIndexId == null && other.columnIndexId != null) || (this.columnIndexId != null && !this.columnIndexId.equals(other.columnIndexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return columnIndexName;
    }

}