package com.app.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String jwt;
	private String tokenType;

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

    public AuthenticationResponse(String jwt, String tokenType) {
        this.jwt = jwt;
        this.tokenType = tokenType;
    }
}
