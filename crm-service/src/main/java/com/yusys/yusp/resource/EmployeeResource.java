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
 * ����Ա��CRUD����
 * @author FFF
 *
 */
@Controller
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	/**
	 * ��ѯԱ�����ݣ���ҳ��ѯ��
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model) {
		//�ⲻ��һ����ҳ��ѯ
		//����PageHelper��ҳ���
		//�ڲ�ѯ֮ǰ����,����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
		List <Employee> emps = employeeService.getAll();
		
		//ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��PageInfo����ҳ������ˡ�
		//��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ���������ݴ���������ʾ��ҳ��
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		
		
		return "list";
	}

}
