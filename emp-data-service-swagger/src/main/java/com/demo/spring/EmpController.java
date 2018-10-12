package com.demo.spring;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

import io.swagger.annotations.Api;

@RestController
@Api
public class EmpController {

	@Autowired
	private HrService hr;

	@RequestMapping(path = "/empfind/{id}", method = RequestMethod.GET, produces = "application/json")
	public Emp findEmpById(@PathVariable("id") int id) {
		Optional<Emp> o = hr.displayEmpInfo(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new RuntimeException("No Employee found");
		}
	}

	@RequestMapping(path = "emp/list", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> findAll() {
		return hr.getAll();

	}

	@RequestMapping(path = "/emp/save", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public String addEmp(@RequestBody Emp e) {
		return hr.registerEmployee(e);
	}
	
	@RequestMapping(path = "/emp/update", method = RequestMethod.PUT, consumes = "application/json", produces = "text/plain")
	public String updateEmp(@RequestBody Emp e) {
		return hr.updateEmployee(e);
	}
	
	@RequestMapping(path = "/emp/delete", method = RequestMethod.DELETE,  produces = "text/plain")
	public String deleteEmp(@RequestParam("id") int id) {
		return hr.deleteById(id);
	}
	
	

}
