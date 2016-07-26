package com.dot.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="USERS")
public class UserAccount {
	@Id  @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "USER_ID", nullable = false)
	String userID;
	@Column(name = "USERNAME", nullable = false)
	String userName;
	@Column(name = "PASSWORD", nullable = false)
	String password;
	@Column(name = "EMAILID", nullable = false)
	String emailID;
	@Column(name = "FULL_NAME", nullable = false)
	String fullName;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (userID != null ? userID.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof UserAccount)) {
	            return false;
	        }
	        UserAccount other = (UserAccount) object;
	        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
	            return false;
	        }
	        return true;
	    }
 
    @Override
    public String toString() {
        return "Employee [id=" + userID + ", name=" + userName + ", joiningDate="
                + "" + ", salary=" + "" + ", ssn=" + "" + "]";
    }

}
