package com.yusys.yusp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yusys.yusp.domain.Employee;
import com.yusys.yusp.service.EmployeeService;
/**
 * 处理员工CRUD请求
 * @author FFF
 *
 */
@Controller
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	/**
	 * 查询员工数据（分页查询）
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model) {
		//这不是一个分页查询
		//引入PageHelper分页插件
		//在查询之前调用,传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		//startPage后面紧跟的查询就是一个分页查询
		List <Employee> emps = employeeService.getAll();
		
		//使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就行了。
		//封装了详细的分页信息，包括有我们查询出来的数据传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		
		
		return "list";
	}

}
