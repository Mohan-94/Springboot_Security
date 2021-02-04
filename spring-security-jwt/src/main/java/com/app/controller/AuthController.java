package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Constants;
import com.app.domain.GenricException;
import com.app.model.AuthenticationRequest;
import com.app.model.AuthenticationResponse;
import com.app.util.JwtUtil;
import com.app.util.ValidateUserService;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private ValidateUserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt,Constants.TOKEN_TYPE);
			return ResponseEntity.ok(authenticationResponse);
		} catch (BadCredentialsException e) {
			throw new GenricException(HttpStatus.UNAUTHORIZED,Constants.ERROR_MSG_INCORR_PASS);
		} catch (Exception e) {
			throw new GenricException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
}
