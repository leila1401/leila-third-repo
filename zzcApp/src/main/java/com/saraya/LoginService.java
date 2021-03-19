package com.saraya;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean ValidUser(String user , String password) {
		return user.equals("Leila") && password.equals("niang");
		
		
	}

}
