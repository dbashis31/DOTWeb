package com.dot.dao;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("columnDAO")
public class ColumnDAOImpl extends AbstractDao implements ColumnDAO {

	@Override
	public Long countColumn() {
		try {
		    Query query = getSession().createQuery("select count(*) from ColumnDOT");
		    return ( (Long) query.iterate().next() );
		}catch(NoResultException nr){
			return 0l;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}

}
