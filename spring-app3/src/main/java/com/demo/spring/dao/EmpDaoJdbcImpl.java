package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

//@Repository("empJdbc")
public class EmpDaoJdbcImpl implements EmpDao{

	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("JDBC saved.....");
		return "success";
	}

}
