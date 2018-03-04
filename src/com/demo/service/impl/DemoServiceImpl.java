package com.demo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.mapper.DemoMapper;
import com.demo.service.DemoService;
import com.demo.util.DESUtil;
import com.demo.util.MD5Util;
import com.demo.util.MyEncriptUtil;
import com.esint.common.mapper.BaseMapper;
import com.esint.common.service.impl.BaseServiceImpl;

@Service("demoService")
public class DemoServiceImpl extends BaseServiceImpl implements DemoService{
	//加密方式
	private static final String MD5METHOD="MD5";
	private static final String DESMETHOD="DES";
	private static final String DIYMETHOD="DIY";
	
	@Autowired
	@Qualifier("demoMapper")
	private DemoMapper demoMapper;
	
	/**
	 * param中包含用户名和密码，将密码加密，与数据库中密码进行比较
	 */
	public Map<String, Object> login(Map<String, Object> param){
		String pwd=param.get("pwd").toString();
		String encPwd="";
		encPwd=MD5Util.getMD5(pwd);
		param.put("pwd",encPwd);
		Map<String, Object> returnMap=new HashMap<String, Object>();
		String uuid="";
		System.out.println(demoMapper.login(param));
		if(demoMapper.login(param)!=null){
			uuid=demoMapper.login(param).get("uuid").toString();
		}
		returnMap.put("uuid",uuid);
		return returnMap;
	}
	
	/**
	 * 注册时候把密码按照选定方式加密
	 */
	public int register(Map<String, Object> param) {
		//先查询该用户是否已存在
		int isExists=demoMapper.isUserExists(param.get("uname").toString());
		int flag=0;
		if(isExists>0){
		}else{
			String pwd=param.get("pwd").toString();
			String encPwd="";
			encPwd=MD5Util.getMD5(pwd);
			param.put("pwd",encPwd);
			String uuid=newGuid();
			param.put("uuid", uuid);
			if(demoMapper.register(param)>0){
				flag=1;
			}
		}
		return flag;
	}
	
	/**
	 * 加密
	 */
	@Override
	public Map<String, Object> encrypt(Map<String, Object> param) {
		
		String encType=param.get("encType").toString();
		String str=param.get("str").toString();
		String uuid=param.get("uuid").toString();
		String tel=demoMapper.selectTel(uuid);
		String encString="";
		System.out.println("加密ing");
		System.out.println(uuid+","+tel);
		if(encType.equals(MD5METHOD)){
			encString=MD5Util.getMD5(str);
		}else if(encType.equals(DESMETHOD)){
			 encString=DESUtil.encrypt(str);
		}else if(encType.equals(DIYMETHOD)){
			encString=MyEncriptUtil.encrypt(str,tel);
		}
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("encStr", encString);
		return returnMap;
	}
	
	/**
	 * 解密
	 */
	@Override
	public Map<String, Object> decrypt(Map<String, Object> param) {
		String encStr=param.get("encStr").toString();
		String encType=param.get("encType").toString();
		String tel=param.get("decKey").toString();
		String uuid=param.get("uuid").toString();
		String correctTel=demoMapper.selectTel(uuid);
		System.out.println("解密ing");
		System.out.println(tel+","+correctTel);
		String str="";
		if(encType.equals(MD5METHOD)){
			str="MD5是消息摘要，不能解密";
		}else if(encType.equals(DESMETHOD)){
			try{
	    	str = DESUtil.decrypt(encStr);  
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				str="密文格式不正确";
			}
		}else if(encType.equals(DIYMETHOD)) {
			if(!tel.equals(correctTel)){
				str="解密密钥输入有误！";
			}else{
				try{
			    	str = MyEncriptUtil.decrypt(encStr,tel);  
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						str="密文格式不正确";
					}
			}
			
		}
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("str", str);
		return returnMap;
	}
	
	
	@Override
	protected BaseMapper getMapper() {
		return null;
	}

	public static String newGuid() {
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}

	@Override
	public int isUserExists(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return demoMapper.isUserExists(param.get("uname").toString());
	}


	

}
