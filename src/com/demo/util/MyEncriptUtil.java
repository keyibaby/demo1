package com.demo.util;

/**
 * 	
		DIY���ܹ��̣�
		1.�õ��û�ע���ֻ��ţ���ĩλ�������õ�tel1
		2.tel1���ֻ����м�λ������λ�� ע��������λΪ0ʱ��ȡ1��
		3.תΪ16����
		4.��ԭ�ֻ��ŵ�MD5ƴ�Ӵ������ֻ��ŵ�16����
		5.�����Ĳ��õ��Ľ����ΪDES���ܵ���Կ
		6.����ͨ������Կ����DES���ܵõ����ġ�
		
		
		13633410113
		33633410111
		33633410111*4
		תΪ16����
 */



public class MyEncriptUtil {
	/**�Ƚ��ֻ��ŵ���ĩλ������ȡ���м�λ��������ˣ�
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
