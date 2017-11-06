package com.situ.crm.service;

import java.util.Date;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Customer;
import com.situ.crm.vo.CustomerContribute;

public interface ICustomerService {
	
	void checkCustomerLoss();
	/**
	 * 根据分页信息返回所有数据
	 * @param page 当前页
	 * @param rows 一页多少数据
	 * @param endTime 
	 * @param beginTime 
	 * @return
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, Customer customer, Date beginTime, Date endTime);

	ServerResponse delete(String ids);

	ServerResponse add(Customer customer);

	ServerResponse update(Customer customer);

	ServerResponse findById(Integer id);
	
	ServerResponse updateDevResult(Integer customerId, Integer devResult);
	EasyUIDataGrideResult findCustomerContribute(Integer page, Integer rows, CustomerContribute customerContribute);
	ServerResponse findCustomerConstitute();
	ServerResponse findkhfw();
}
