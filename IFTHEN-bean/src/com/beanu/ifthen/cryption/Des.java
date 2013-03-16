package com.beanu.ifthen.cryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Des {
	public static final String KEY = "GKDJHSUG";
	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static String encryptDES(byte[] encryptString, String encryptKey){
		// IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
		String data="";
		try {
			IvParameterSpec zeroIv = new IvParameterSpec(iv);
			SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
			byte[] encryptedData = cipher.doFinal(encryptString);
			data=Base64.encode(encryptedData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public static byte[] decryptDES(String decryptString, String decryptKey) {
		
		byte[] decryptedData = null;
		try {
			byte[] byteMi = Base64.decode(decryptString);
			IvParameterSpec zeroIv = new IvParameterSpec(iv);
			// IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
			SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
			decryptedData = cipher.doFinal(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return decryptedData;
	}
}
