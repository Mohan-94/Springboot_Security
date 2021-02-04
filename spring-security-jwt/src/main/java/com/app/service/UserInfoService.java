package com.app.service;

import com.app.domain.GenricException;
import com.app.model.UserInfo;

public interface UserInfoService {

	UserInfo createUser(UserInfo user) throws GenricException;
	UserInfo updateUser(UserInfo user) throws GenricException;
	void deleteUser(Integer id) throws GenricException;


}
