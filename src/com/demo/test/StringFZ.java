package com.demo.test;

import org.junit.Test;

public class StringFZ {

	public static StringBuffer fanzhuanString(String s){
		StringBuffer sb=new StringBuffer();
		for(int i=s.length();i>0;i--){
			sb.append(s.charAt(i-1));
		}
		return sb;
	}
	
	public static void main(String[] args) {
		StringBuffer sb=fanzhuanString("µ÷Ï·×¨ÓÃ°¡");
		System.out.println(sb);
	}
	@Test
	public void test(){
		StringBuffer sb=fanzhuanString("");
		System.out.println(sb);
	}
}
