package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SERVER database table.
 * 
 */
@Entity
@NamedQuery(name="Server.findAll", query="SELECT s FROM Server s")
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SERVER_ID")
	private String serverId;

	@Column(name="SERVER_HOST")
	private String serverHost;

	@Column(name="SERVER_NAME")
	private String serverName;

	@Column(name="SERVER_PORT")
	private int serverPort;

	@Column(name="SERVER_STATUS")
	private String serverStatus;

	public Server() {
	}

	public String getServerId() {
		return this.serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerHost() {
		return this.serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getServerPort() {
		return this.serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerStatus() {
		return this.serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

}