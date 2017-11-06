package com.situ.crm.service;


import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.User;

public interface IUserService {
	/**
	 * 根据分页信息返回所有数据
	 * @param page 当前页
	 * @param rows 一页多少数据
	 * @return
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, User user);

	ServerResponse delete(String ids);

	User findByNameAndPassword(String name, String password);

	ServerResponse add(User user);

	ServerResponse update(User user);
	
	List<User> getCustomerManagerList();
}