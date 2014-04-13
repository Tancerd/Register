package org.pwr.register.support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String getHash(String phrase) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			return (messageDigest.digest(phrase.getBytes())).toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	} 

}
