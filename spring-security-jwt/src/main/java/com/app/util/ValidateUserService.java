package com.app.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.domain.Constants;
import com.app.model.UserInfo;
import com.app.repository.UserInfoRepository;

@Service
public class ValidateUserService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserInfo user = userRepository.findByUserName(userName);
		if (null != user && null != user.getUserName()) {

			return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException(Constants.ERROR_MSG_401);
		}

		//return new User("Mohan", "Test@123", new ArrayList<>());
	}
}
