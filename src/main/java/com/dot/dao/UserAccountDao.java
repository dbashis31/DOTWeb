package com.dot.dao;

import java.util.List;

import com.dot.data.DBResult;
import com.dot.data.UserAccount;

public interface UserAccountDao {
	DBResult saveUA(UserAccount employee);
    List<UserAccount> findAllUA();
	UserAccount find(UserAccount employee);
}
