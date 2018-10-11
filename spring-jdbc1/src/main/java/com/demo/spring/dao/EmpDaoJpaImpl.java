package com.demo.spring.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository("empJpa")
public class EmpDaoJpaImpl implements EmpDao{

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
