package com.yusys.yusp.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yusys.yusp.domain.Employee;
import com.yusys.yusp.mapper.DepartmentMapper;
import com.yusys.yusp.mapper.EmployeeMapper;

/**
 * ����mapper��Ĺ���
 * @author FFF
 *�Ƽ�Spring����Ŀ�Ϳ���ʹ��Spring�ĵ�Ԫ���ԣ������Զ�ע����ô��Ҫ���
 *1.����Sring-testģ��
 *2.@ContextConfigurationָ��Spring�����ļ���λ��
 *3.ֱ��autowiredҪʹ�õ��������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapeer;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * ����DepartmentMapper
	 */
	@Test
	public void testCRUD() {
		/*
		 * //1.����Spring��Ioc���� ClassPathXmlApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2.�������л�ȡmapper
		 * ioc.getBean(DepartmentMapper.class);
		 */
		//System.out.print(departmentMapper);
		//1.���뼸������
		/*
		 * departmentMapper.insertSelective(new Department(1001,"������"));
		 * departmentMapper.insertSelective(new Department(1002,"���Բ�"));
		 */
		//2.����Ա�����ݣ�����Ա������
		//employeeMapeer.insertSelective(new Employee(1, "Jerry", "M", "Jerry@qq.com", 1001));
		
		//3.����������Ա����������ʹ�ÿ���ִ������������sqlSession
		/*
		 * for() {
		 * 
		 * }
		 */
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<100;i++) {
			String uid = UUID.randomUUID().toString().substring(0,5) + "" +i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 1001));
		}
	}

}
