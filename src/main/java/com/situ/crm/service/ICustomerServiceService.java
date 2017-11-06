package com.situ.crm.service;


import java.util.Date;
import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;

public interface ICustomerServiceService {
	/**
	 * 根据分页信息返回所有数据
	 * @param page 当前页
	 * @param rows 一页多少数据
	 * @return
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService, Date beginTime,
			Date endTime);
	ServerResponse delete(String ids);

	ServerResponse add(CustomerService customerService);

	ServerResponse update(CustomerService customerService);
	EasyUIDataGrideResult findAll1(Integer page, Integer rows, CustomerService customerService, Date beginTime,
			Date endTime);
	EasyUIDataGrideResult findAll2(Integer page, Integer rows, CustomerService customerService, Date beginTime,
			Date endTime);
	EasyUIDataGrideResult findAll3(Integer page, Integer rows, CustomerService customerService, Date beginTime,
			Date endTime);




}