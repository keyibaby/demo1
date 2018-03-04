package com.demo.util;

import java.security.MessageDigest;
/**
 * MD5做消息摘要
 */
public class MD5Util {
		
		private static String md5Method="MD5";
		/**
		 * 
		 * @param msg
		 * @return 消息摘要
		 */
		public static String getMD5(String msg){
			String md5str="";
			try{
				MessageDigest md=MessageDigest.getInstance(md5Method);
				byte[] inputStr=msg.getBytes();
				byte[] buff=md.digest(inputStr);
				md5str=bytesToHex(buff);
			}catch(Exception e){
				e.printStackTrace();
			}
			return md5str;
		}
		
		/**
		 * 比特串转16进制
		 * @param bytes 
		 * @return 16进制字符串
		 */
		private static String bytesToHex(byte[] bytes) {
			StringBuffer md5str=new StringBuffer();
			int digital;
			for(int i=0;i<bytes.length;i++){
				digital=bytes[i];
				
				if(digital<0){
					digital+=256;
				}
				if(digital<16){
					md5str.append("0");
				}
				md5str.append(Integer.toHexString(digital));
			}
			
			return md5str.toString().toUpperCase();
				
		}
		
//		public static void main(String[] args) {
//			String s="hello world";
//			System.out.println(getMD5(s));
//		}
}
