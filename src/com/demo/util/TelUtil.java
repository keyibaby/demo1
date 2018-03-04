package com.demo.util;

import java.math.BigInteger;

public class TelUtil {
	public static void main(String[] args) throws Exception {
		String tel="13702060176";
		String encTel=telEnc(tel);
		System.out.println("加密后的手机号："+encTel);
	}
	private static  String dec2Hex(String decimal){
		BigInteger intTel=new BigInteger(decimal);
		return intTel.toString(16).toUpperCase();
	}
	
	
	/**
	 * 将输入的手机号tel首末位调换得到tel1，将tel1的第六位取出得到mid，
	 * tel1*mid得到telMul，将telMul转16进制得到telHex，用tel的MD5拼接telHex作为返回值
	 * @param tel
	 * @return encTel
	 */
	public static String telEnc(String tel){
		//得到第六位数
		int midTel=getMidOfTel(tel);
		long lTel=Long.valueOf(tel);
		lTel=Long.valueOf(exTel(String.valueOf(lTel)));
		lTel*=Long.valueOf(midTel);
		String md5Tel=MD5Util.getMD5(tel);
		return md5Tel+dec2Hex(String.valueOf(lTel));
	}
	
	/*
	 * 得到tel的中间位，如果为0则返回1
	 */
	private static int getMidOfTel(String tel){
		int len=tel.length();
		if(len!=11){
			return 1;
		}else{
			char[] charTel=tel.toCharArray();
			return charTel[5]=='0'?1:charToInt(charTel[5]);
		}
	}
	
	/*
	 * 交换tel的首末位
	 */
	private static String exTel(String tel){
		int len=tel.length();
		if(len!=11){
			return null;
		}else{
			char[] charTel=tel.toCharArray();
			char temp;
			//交换首位和末位
			temp=charTel[0];
			charTel[0]=charTel[len-1];
			charTel[len-1]=temp;
			return String.valueOf(charTel);
		}
	}
	
	/**
	 * 字符转int
	 * @param string
	 * @return int
	 */
	private static int charToInt(char c){
		return (int)"0123456789".indexOf(c);
	}
	
}
