package com.demo.spring.dao;


import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

//@Repository("empJpa")
public class EmpDaoJpaImpl implements EmpDao{

	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("JPA implemented");
		return "JPA Success";
	}

}
