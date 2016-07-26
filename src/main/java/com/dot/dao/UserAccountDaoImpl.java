package com.dot.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dot.data.DBResult;
import com.dot.data.UserAccount;

@Repository("userAccountDao")
public class UserAccountDaoImpl extends AbstractDao implements UserAccountDao {
    
	
	
	@Override
	public DBResult saveUA(UserAccount employee) {
		DBResult db=new DBResult();
		if(isUserPresent(employee)){
			db.setMessage("User is exist");
		} else {
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		  employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		  getSession().save(employee);
		  db.setMessage("User registered!!!");
		}
		return db;
		
	}

	@Override
	public List<UserAccount> findAllUA() {
		System.out.println( getSession());
		Criteria criteria = getSession().createCriteria(UserAccount.class);
		return (List<UserAccount>) criteria.list();
	}

	@Override
	public UserAccount find(UserAccount employee){
		UserAccount ua=null;
		try {
		 Query query = getSession().createQuery("from UserAccount where userName = :userName ");
		 query.setParameter("userName", employee.getUserName());
		 return (UserAccount)query.list().get(0);
		}catch(NoResultException nr){
			return null;
		}catch(Exception ex){
			return null;
		}
		
	}
	
	private boolean isUserPresent(UserAccount employee){
		UserAccount ua=find(employee);
		//System.out.println(ua.getUserName());	
		if(ua!=null){
			
			System.out.println(ua.getUserName());	
			return true;
		}else {
			return false;
		}
	}

}
