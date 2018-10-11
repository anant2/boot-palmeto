package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
@EnableTransactionManagement
public class HrService {

	@Autowired
	@Qualifier("empJdbc")
	private EmpDao dao;

	
	public void registerEmployee(Emp e) {
		System.out.println(dao.save(e));
	}

	public void displayEmpInfo(int id) {
		try {
			Emp emp = dao.findbyId(id);
			System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getSalary());
		} catch (Exception e) {
			System.out.println("No such employee exists");
		}
	}

	public void getAll() {
		List<Emp> empList = dao.getAll();
		empList.stream().forEach(
				e -> System.out.println(e.getEmpId() + " " + e.getCity() + " " + e.getName() + " " + e.getSalary()));
	}

	public void deleteById(int id) {
		System.out.println(dao.delete(id));
	}

}
