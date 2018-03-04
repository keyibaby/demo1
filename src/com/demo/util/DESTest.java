package com.demo.util;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class DESTest {
	  
	 	
	    public static void main(String[] args) {  
	       String src="Hello,world!";
	       System.out.println(encrypt(src));
	       System.out.println(decrypt(encrypt(src)));
	    }  
	  
	    public static String getKey(){
	    	 KeyGenerator keyGenerator;
			try {
				keyGenerator = KeyGenerator.getInstance("DES");
				 keyGenerator.init(56);// ������Կ�ĳ���Ϊ56λ  
		            // ����һ��Key  
		            SecretKey generateKey = keyGenerator.generateKey();  
		            // ת��Ϊ�ֽ�����  
		            byte[] encoded = generateKey.getEncoded();  
		            // ������Կ�ַ���  
		            String encodeHexString = Hex.encodeHexString(encoded);  
//		            System.out.println("Key �� " + encodeHexString);  
		            return  encodeHexString;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	           return "12345678";
	    }
	    public static String encrypt(String str){
	    	
	    	String keyStr=getKey();
	    	System.out.println("����key"+keyStr);
	        byte[] decodeHex;
			try {
				decodeHex = Hex.decodeHex(keyStr.toCharArray());
				 // ������Կ����  
	            SecretKeySpec secretKeySpec = new SecretKeySpec(decodeHex, "DES");  
	            // ��ȡ�ӽ���ʵ��  
	            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  
	            // ��ʼ������ģʽ  
	            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);  
	            // ����  
	            byte[] encByt = cipher.doFinal(str.getBytes());  
	            return parseByte2HexStr(encByt);
			} catch (Exception e) {
				e.printStackTrace();
			}  
	           
	           
	    	return "����ʧ��";
	    }
	    
	    public static String decrypt(String encStr){
	    	String keyStr=getKey();
	    	System.out.println("����key"+keyStr);
		       
	    	 byte[] decodeHex;
			try {
				decodeHex = Hex.decodeHex(keyStr.toCharArray());
				 // ������Կ����  
	            SecretKeySpec secretKeySpec = new SecretKeySpec(decodeHex, "DES");  
	            // ��ȡ�ӽ���ʵ��  
	            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  
	            // ��ʼ������ģʽ  
	            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);  
	            // ����  
	            byte[] encByt = cipher.doFinal(encStr.getBytes());  
	            return parseByte2HexStr(encByt);
			} catch (Exception e) {
				e.printStackTrace();
			}  
	           
	           
	    	return "����ʧ��";
	    }

	    /**��������ת����16���� 
	     * @param buf 
	     * @return 
	     */  
	    public static String parseByte2HexStr(byte buf[]) {  
	            StringBuffer sb = new StringBuffer();  
	            for (int i = 0; i < buf.length; i++) {  
	                    String hex = Integer.toHexString(buf[i] & 0xFF);  
	                    if (hex.length() == 1) {  
	                            hex = '0' + hex;  
	                    }  
	                    sb.append(hex.toUpperCase());  
	            }  
	            return sb.toString();  
	    }  
	    
	    /**��16����ת��Ϊ������ 
	     * @param hexStr 
	     * @return 
	     */  
	    public static byte[] parseHexStr2Byte(String hexStr) {  
	            if (hexStr.length() < 1)  
	                    return null;  
	            byte[] result = new byte[hexStr.length()/2];  
	            for (int i = 0;i< hexStr.length()/2; i++) {  
	                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                    result[i] = (byte) (high * 16 + low);  
	            }  
	            return result;  
	    }  
	    
}  

