package com.climbtogether.climby.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RegularExpression {
	
	public boolean checkPhone(String phoneNumber) {

		if(phoneNumber.matches("%[^0-9]%")||
		   phoneNumber.length()!=9){
			return false;
		}
		
		return true;
	}

}
