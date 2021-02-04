package com.app.service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TransactionRequiredException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.domain.GenricException;
import com.app.model.UserInfo;
import com.app.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Override
	@Transactional
	public UserInfo createUser(UserInfo user) throws GenricException {
		try {
			return userInfoRepo.save(user);
		} catch (ConstraintViolationException ex) {
			throw new GenricException(HttpStatus.CONFLICT, ex.getMessage());
		} catch (IllegalArgumentException | EntityNotFoundException | TransactionRequiredException | IllegalStateException ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@Override
	@Transactional
	public UserInfo updateUser(UserInfo user) throws GenricException {
		try {
			return userInfoRepo.save(user);
		} catch (IllegalArgumentException | EntityNotFoundException | TransactionRequiredException | IllegalStateException ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@Override
	public void deleteUser(Integer id) throws GenricException {
		try {
			userInfoRepo.deleteById(id);
		} catch (IllegalArgumentException | EntityNotFoundException | TransactionRequiredException | IllegalStateException ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

}
