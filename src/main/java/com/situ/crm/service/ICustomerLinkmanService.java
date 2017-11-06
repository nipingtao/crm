package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLinkman;
import com.situ.crm.pojo.DataDic;

public interface ICustomerLinkmanService {
	/**
	 * 根据分页信息返回所有数据
	 * @param page 当前页
	 * @param rows 一页多少数据
	 * @return
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerLinkman customerLinkman);

	ServerResponse delete(String ids);
	
	ServerResponse deleteById(Integer id);

	ServerResponse add(CustomerLinkman customerLinkman);

	ServerResponse update(CustomerLinkman customerLinkman);


}
