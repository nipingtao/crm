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
import com.situ.crm.pojo.CusDevPlan;
import com.situ.crm.service.ICusDevPlanService;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

	
	@Autowired
	private ICusDevPlanService cusDevPlanService;

	@RequestMapping("/index")
	public String index() {
		return "cus_dev_plan_item_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CusDevPlan cusDevPlan) {
		return cusDevPlanService.findAll(page, rows, cusDevPlan);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids) {
		return cusDevPlanService.delete(ids);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return cusDevPlanService.deleteById(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CusDevPlan cusDevPlan) {
		return cusDevPlanService.add(cusDevPlan);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CusDevPlan cusDevPlan) {
		return cusDevPlanService.update(cusDevPlan);
	}
	
}