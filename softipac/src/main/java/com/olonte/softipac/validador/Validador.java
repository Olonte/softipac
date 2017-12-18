package com.olonte.softipac.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.olonte.softipac.utilidad.Utilidad;

public class Validador {
	
	private static Pattern pattern;  
	
	private static Matcher matcher;
	
	public Validador() {
	}  
	 
	public static boolean emailValido(String email) {
		
		pattern = Pattern.compile(Utilidad.EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		
		if (!matcher.matches()) {
			return false;
		}
		
		return true;
	}

}
