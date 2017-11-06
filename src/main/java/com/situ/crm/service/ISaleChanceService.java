package com.situ.crm.service;

import java.util.Date;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.SaleChance;

public interface ISaleChanceService {
	/**
	 * 根据分页信息返回所有数据
	 * @param page 当前页
	 * @param rows 一页多少数据
	 * @param endTime 
	 * @param beginTime 
	 * @return
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance, Date beginTime, Date endTime);

	ServerResponse delete(String ids);

	ServerResponse add(SaleChance saleChance);

	ServerResponse update(SaleChance saleChance);

	ServerResponse findById(Integer id);
	
	ServerResponse updateDevResult(Integer saleChanceId, Integer devResult);
}
