package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer> {

	@Query(name="name1",value="select e from Emp e where salary between ?1 and ?2")
	public List<Emp> getsalaryBetween(double sal1,double sal2);
	
}
