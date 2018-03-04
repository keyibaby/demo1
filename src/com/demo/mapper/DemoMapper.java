package com.demo.mapper;

import java.util.Map;


import com.esint.common.mapper.BaseMapper;

public interface DemoMapper extends BaseMapper{

	Map<String, Object> login(Map<String, Object> param);
	
	int register(Map<String, Object> param);

	String selectTel(String uuid);

	int isUserExists(String uname);

}
