package com.p.num;

import java.text.Normalizer;

public class StringReplacement {

	public static void main(String[] args) {
		String subjectString = "צהü";
		subjectString = Normalizer.normalize(subjectString, Normalizer.Form.NFD);
		String resultString = subjectString.replaceAll("[^\\x00-\\x7F]", "");
		
		System.out.println(resultString);


	}
	
	
	

}
