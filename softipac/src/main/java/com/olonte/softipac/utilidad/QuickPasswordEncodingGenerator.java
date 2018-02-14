package com.olonte.softipac.utilidad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class QuickPasswordEncodingGenerator {

	public QuickPasswordEncodingGenerator() {
	}

	public static String passwordEncoder(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(password);
	}
	
}
