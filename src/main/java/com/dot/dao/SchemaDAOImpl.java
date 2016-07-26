package com.dot.dao;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("SchemaDAO")
public class SchemaDAOImpl extends AbstractDao implements SchemaDAO {

	@Override
	public Long countSchema() {
		try {
		    Query query = getSession().createQuery("select count(*) from SchemaDOT");
		    return ( (Long) query.iterate().next() );
		}catch(NoResultException nr){
			return 0l;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}

}
