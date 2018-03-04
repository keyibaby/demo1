package com.demo.util;

/**
 * 	
		DIY加密过程：
		1.得到用户注册手机号，首末位交换，得到tel1
		2.tel1乘手机号中间位（第六位， 注：当第六位为0时，取1）
		3.转为16进制
		4.用原手机号的MD5拼接处理后的手机号的16进制
		5.将第四步得到的结果作为DES加密的密钥
		6.明文通过此密钥进行DES加密得到密文。
		
		
		13633410113
		33633410111
		33633410111*4
		转为16进制
 */



public class MyEncriptUtil {
	/**先将手机号的首末位交换，取出中间位，两者相乘，
	 * @param str
	 * @param tel
	 * @return
	 */
	public static String encrypt(String str,String tel){
		String afterDES=DESUtil.encrypt(str);
		String encTel=TelUtil.telEnc(tel);
		String afterDiy=DESUtil.encrypt(afterDES,encTel);
		return afterDiy;
	}
	
	public static String decrypt(String encStr,String tel){
		String encTel=TelUtil.telEnc(tel);	
		String beforeDiy=DESUtil.decrypt(encStr, encTel);
		String beforeDes=DESUtil.decrypt(beforeDiy);
		return beforeDes;
	}
	
	
	
	
	public static void main(String[] args) {
		String encStr=encrypt("1","18663817521");
		System.out.println(encStr);
		String str=decrypt(encStr,"18663817521");
		System.out.println(str);
	}
	
	
}
