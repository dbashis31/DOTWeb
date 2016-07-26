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
 * The persistent class for the "CONNECTION" database table.
 * 
 */
@Entity
@Table(name="\"CONNECTION\"")
@NamedQuery(name="Connection.findAll", query="SELECT c FROM Connection c")
public class Connection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CONNECTION_ID")
	private String connectionId;

	@Column(name="CONNECTION_ADDED_BY")
	private String connectionAddedBy;

	@Column(name="CONNECTION_ADDED_ON")
	private BigDecimal connectionAddedOn;

	@Column(name="CONNECTION_DATABASE_NAME")
	private String connectionDatabaseName;

	@Column(name="CONNECTION_DBTYPE")
	private String connectionDbtype;

	@Column(name="CONNECTION_ENVIRONMENT")
	private String connectionEnvironment;

	@Column(name="CONNECTION_NAME")
	private String connectionName;

	@Column(name="CONNECTION_PASSWORD")
	private String connectionPassword;

	@Column(name="CONNECTION_PORT")
	private String connectionPort;

	@Column(name="CONNECTION_SYSTEM")
	private String connectionSystem;

	@Column(name="CONNECTION_SYSTEM_IP")
	private String connectionSystemIp;

	@Column(name="CONNECTION_USERNAME")
	private String connectionUsername;

	/*//bi-directional many-to-one association to Schema
	@OneToMany(mappedBy="connection")
	private List<Schema> schemas;*/

	public Connection() {
	}

	public String getConnectionId() {
		return this.connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionAddedBy() {
		return this.connectionAddedBy;
	}

	public void setConnectionAddedBy(String connectionAddedBy) {
		this.connectionAddedBy = connectionAddedBy;
	}

	public BigDecimal getConnectionAddedOn() {
		return this.connectionAddedOn;
	}

	public void setConnectionAddedOn(BigDecimal connectionAddedOn) {
		this.connectionAddedOn = connectionAddedOn;
	}

	public String getConnectionDatabaseName() {
		return this.connectionDatabaseName;
	}

	public void setConnectionDatabaseName(String connectionDatabaseName) {
		this.connectionDatabaseName = connectionDatabaseName;
	}

	public String getConnectionDbtype() {
		return this.connectionDbtype;
	}

	public void setConnectionDbtype(String connectionDbtype) {
		this.connectionDbtype = connectionDbtype;
	}

	public String getConnectionEnvironment() {
		return this.connectionEnvironment;
	}

	public void setConnectionEnvironment(String connectionEnvironment) {
		this.connectionEnvironment = connectionEnvironment;
	}

	public String getConnectionName() {
		return this.connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getConnectionPassword() {
		return this.connectionPassword;
	}

	public void setConnectionPassword(String connectionPassword) {
		this.connectionPassword = connectionPassword;
	}

	public String getConnectionPort() {
		return this.connectionPort;
	}

	public void setConnectionPort(String connectionPort) {
		this.connectionPort = connectionPort;
	}

	public String getConnectionSystem() {
		return this.connectionSystem;
	}

	public void setConnectionSystem(String connectionSystem) {
		this.connectionSystem = connectionSystem;
	}

	public String getConnectionSystemIp() {
		return this.connectionSystemIp;
	}

	public void setConnectionSystemIp(String connectionSystemIp) {
		this.connectionSystemIp = connectionSystemIp;
	}

	public String getConnectionUsername() {
		return this.connectionUsername;
	}

	public void setConnectionUsername(String connectionUsername) {
		this.connectionUsername = connectionUsername;
	}

	/*public List<Schema> getSchemas() {
		return this.schemas;
	}

	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}*/

	/*public Schema addSchema(Schema schema) {
		getSchemas().add(schema);
		schema.setConnection(this);

		return schema;
	}

	public Schema removeSchema(Schema schema) {
		getSchemas().remove(schema);
		schema.setConnection(null);

		return schema;
	}*/
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (connectionId != null ? connectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) object;
        if ((this.connectionId == null && other.connectionId != null) || (this.connectionId != null && !this.connectionId.equals(other.connectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return connectionName;
    }

}