package com.demo.service;

import java.util.Map;


import com.esint.common.service.BaseService;

public interface DemoService extends BaseService {

	public Map<String, Object> login(Map<String, Object> param);

	public int register(Map<String, Object> param);

	public Map<String,Object> encrypt(Map<String, Object> param);

	public Map<String, Object> decrypt(Map<String, Object> param);
	
	public int isUserExists(Map<String,Object>param);

}
