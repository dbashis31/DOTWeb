package com.dot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dot.data.Connection;
import com.dot.data.model.ConnectionDO;


@Repository("connectionDAO")
public class ConnectionDAOImpl extends AbstractDao implements ConnectionDAO {

	@Override
	public List<Connection> findAll() {
		try {
		    Query query = getSession().createQuery("from Connection c order by c.connectionAddedBy desc ");
		    return (List<Connection>)query.list();
		}catch(NoResultException nr){
			return null;
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public Connection findByID(Long connectionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countConnection() {
		try {
		    Query query = getSession().createQuery("select count(*) from Connection");
		    return ( (Long) query.iterate().next() );
		}catch(NoResultException nr){
			return 0l;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}
   
	@Override
	public List<ConnectionDO> fetchGroupByCount() {
		try {
			List<ConnectionDO> list=new ArrayList<ConnectionDO>();
		    Query query = getSession().createQuery("select count(c.connectionDbtype),c.connectionDbtype from Connection c group by c.connectionDbtype");
		    Iterator it=query.list().iterator();
		    while ( it.hasNext() ) {
		        Object[] tuple = (Object[]) it.next();
		        ConnectionDO dob=new ConnectionDO();
		        dob.setCount((Long)tuple[0]);
		        dob.setDbType((String)tuple[1]);
		        list.add(dob);
		        
		    }
		    return list;
		}catch(NoResultException nr){
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	

}
