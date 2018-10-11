package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class EmpDaoJpaImpl implements EmpDao{

	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("JPA implemented");
		return "JPA Success";
	}

}
