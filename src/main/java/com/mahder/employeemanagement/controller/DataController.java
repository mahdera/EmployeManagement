/**
 * 
 */
package com.mahder.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mahder.employeemanagement.domain.Employee;
import com.mahder.employeemanagement.service.DataService;

import java.util.List;

/**
 * @author mneway
 *
 */

@Controller
public class DataController {
	@Autowired  
	 DataService dataService;  
	  
	 @RequestMapping("form")  
	 public ModelAndView getForm(@ModelAttribute Employee employee) {  
	  return new ModelAndView("form");  
	 }  
	  
	 @RequestMapping("register")  
	 public ModelAndView registerUser(@ModelAttribute Employee employee) {  
	  dataService.saveEmployee(employee);  
	  return new ModelAndView("redirect:list");  
	 }  
	  
	 @RequestMapping("list")  
	 public ModelAndView getList() {  
	  List<Employee> employeeList = dataService.listEmployee();  
	  return new ModelAndView("list", "employeeList", employeeList);  
	 }  
	  
	 @RequestMapping("delete")  
	 public ModelAndView deleteUser(@RequestParam int id) {  
	  dataService.deleteEmployee(id);  
	  return new ModelAndView("redirect:list");  
	 }  
	  
	 @RequestMapping("edit")  
	 public ModelAndView editUser(@RequestParam int id,  
	   @ModelAttribute Employee employee) {  
	  Employee employeeObject = dataService.getEmployee(id);  
	  return new ModelAndView("edit", "employeeObject", employeeObject);  
	 }  
	  
	 @RequestMapping("update")  
	 public ModelAndView updateUser(@ModelAttribute Employee employee) {  
	  dataService.updateEmployee(employee);  
	  return new ModelAndView("redirect:list");  
	 }  
	 
}//end class