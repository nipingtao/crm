package com.situ.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.service.ISaleChanceService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

	
	@Autowired
	private ISaleChanceService saleChanceService;

	@RequestMapping("/index")
	public String index() {
		return "sale_chance_manager";
	}
	
	@RequestMapping("/cusDevPlan")
	public String cusDevPlan() {
		return "cus_dev_plan_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance,Date beginTime,Date endTime) {
		return saleChanceService.findAll(page, rows, saleChance,beginTime,endTime);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids) {
		return saleChanceService.delete(ids);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(SaleChance saleChance) {
		return saleChanceService.add(saleChance);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(SaleChance saleChance) {
		return saleChanceService.update(saleChance);
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public ServerResponse findById(Integer id) {
		return saleChanceService.findById(id);
	}
	

	@RequestMapping("/updateDevResult")
	@ResponseBody
	public ServerResponse updateDevResult(Integer saleChanceId, Integer devResult) {
		return saleChanceService.updateDevResult(saleChanceId, devResult);
	}
}
