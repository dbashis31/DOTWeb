package com.dot.dao;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
@Repository("tableDAO")
public class TableDAOImpl extends AbstractDao implements TableDAO{

	@Override
	public Long countTable() {
		try {
		    Query query = getSession().createQuery("select count(*) from TableDOT");
		    return ( (Long) query.iterate().next() );
		}catch(NoResultException nr){
			return 0l;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}

}
