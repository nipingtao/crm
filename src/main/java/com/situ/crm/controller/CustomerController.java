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
import com.situ.crm.pojo.Customer;
import com.situ.crm.service.ICustomerService;
import com.situ.crm.vo.CustomerContribute;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/index")
	public String index() {
		return "customer_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Customer customer,Date beginTime,Date endTime) {
		return customerService.findAll(page, rows, customer,beginTime,endTime);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids) {
		return customerService.delete(ids);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Customer customer) {
		return customerService.add(customer);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Customer customer) {
		return customerService.update(customer);
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public ServerResponse findById(Integer id) {
		return customerService.findById(id);
	}
	

	@RequestMapping("/updateDevResult")
	@ResponseBody
	public ServerResponse updateDevResult(Integer customerId, Integer devResult) {
		return customerService.updateDevResult(customerId, devResult);
	}
	
	@RequestMapping("/getCustomerContributePage")
	public String getCustomerContributePage() {
		return "customer_contribute_analysis";
	}
	
	@RequestMapping("/findCustomerContribute")
	@ResponseBody
	public EasyUIDataGrideResult findCustomerContribute(Integer page, Integer rows, CustomerContribute customerContribute) {
		return customerService.findCustomerContribute(page, rows, customerContribute);
	}
	
	@RequestMapping(value="/khgc")
	public String khgc(){
		return "khgcfx";
	}
	

	@RequestMapping(value="/findCustomerConstitute")
	@ResponseBody
	public ServerResponse findCustomerConstitute(){
		return customerService.findCustomerConstitute();
	}
	
	@RequestMapping(value="/khfw")
	public String getkhfw(){
		return "khfwfx";
	}
	
	@RequestMapping(value="/findkhfw")
	@ResponseBody
	public ServerResponse findkhfw(){
		return customerService.findkhfw();
	}
}