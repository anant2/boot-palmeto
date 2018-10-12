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

public class HrService {

	@Autowired
	private EmpRepository repo;

	@Transactional
	public String registerEmployee(Emp e) {
		if (repo.existsById(e.getEmpId())) {
			return "Emp Already Exists";
		} else {
			repo.save(e);
			return "Emp saved successfully";
		}
	}

	public String updateEmployee(Emp e) {
		repo.save(e);
		return "Emp updated successfully";
	}

	public Optional<Emp> displayEmpInfo(int id) {
		return repo.findById(id);

	}

	public List<Emp> getAll() {
		return (List<Emp>) repo.findAll();
	}

	public String deleteById(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Emp deleted";
		} else {
			return "Emp not found";
		}

	}

	public void listWithSalaryRange(double s1, double s2) {
		repo.getsalaryBetween(s1, s2).stream().forEach(
				e -> System.out.println(e.getEmpId() + " " + e.getCity() + " " + e.getName() + " " + e.getSalary()));
	}

}
