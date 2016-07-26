package com.dot.dao;

import java.util.List;

import com.dot.data.Connection;
import com.dot.data.model.ConnectionDO;


public interface ConnectionDAO {
	List<Connection> findAll();
	Connection findByID(Long connectionID);
	Long countConnection();
	public List<ConnectionDO> fetchGroupByCount();
}
