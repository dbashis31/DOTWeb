package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 * The persistent class for the NOTIFICATION database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NOTIFICATION_ID")
	private String notificationId;

	@Column(name="NOTIFICATION_ADDED_ON")
	private Long notificationAddedOn;

	@Column(name="NOTIFICATION_NAME")
	private String notificationName;

	@Column(name="NOTIFICATION_PROCESS_GROUP")
	private String notificationProcessGroup;
	

	public Notification() {
	}

	public String getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public Long getNotificationAddedOn() {
		return this.notificationAddedOn;
	}
	
	public String getNotificationDate(){
		SimpleDateFormat datformat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date=new Date(this.notificationAddedOn);
        return datformat.format(date).toString(); 
	}

	public void setNotificationAddedOn(Long notificationAddedOn) {
		this.notificationAddedOn = notificationAddedOn;
	}

	public String getNotificationName() {
		return this.notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	public String getNotificationProcessGroup() {
		return this.notificationProcessGroup;
	}

	public void setNotificationProcessGroup(String notificationProcessGroup) {
		this.notificationProcessGroup = notificationProcessGroup;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Process)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return notificationName;
    }

}