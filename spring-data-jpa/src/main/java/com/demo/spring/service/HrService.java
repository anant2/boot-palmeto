package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service
@Transactional
public class HrService {

	@Autowired
	private EmpRepository repo;

	
	public void registerEmployee(Emp e) {
		Emp e1 = repo.save(new Emp(e.getEmpId(),e.getName(),e.getCity(),e.getSalary()));
		System.out.println("Data Saved");
	}

	public void displayEmpInfo(int id) {
		Optional<Emp> o = repo.findById(id);
		if(o.isPresent()) {
			Emp e = o.get();
			System.out.println(e.getEmpId()+ " " + e.getCity() + " " + e.getName() + " " + e.getSalary());
		}else {
			System.out.println("No Data found");
		}
	}

	public void getAll() {
		List<Emp> empList =repo.findAll();
		empList.stream().forEach(
				e -> System.out.println(e.getEmpId() + " " + e.getCity() + " " + e.getName() + " " + e.getSalary()));
	}

	public void deleteById(int id) {
		repo.deleteById(id);
		System.out.println("Deleted Successfully");
	}
	
	public void listWithSalaryRange(double s1,double s2) {
		 repo.getsalaryBetween(s1, s2).stream().forEach(e->System.out.println(e.getEmpId() + " " + e.getCity() + " " + e.getName() + " " + e.getSalary()));
	}

}
