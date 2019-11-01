package com.yusys.yusp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yusys.yusp.domain.Employee;
import com.yusys.yusp.mapper.EmployeeMapper;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

}
