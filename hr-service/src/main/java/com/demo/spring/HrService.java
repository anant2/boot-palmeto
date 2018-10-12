package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	ServletRequest re;
	
	public ResponseEntity<Emp> getEmpDetails(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity req = new HttpEntity<>(headers);
		
		ResponseEntity<Emp> resp1 = rt.exchange("http://emp-service/empfind/"+id, HttpMethod.GET, req, Emp.class);
		System.out.println("Port "+ re.getServerPort());
		return resp1;
	}
	
	@HystrixCommand(fallbackMethod="getFallBack")
	public ResponseEntity<List<Emp>> getAllEmps() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity req = new HttpEntity<>(headers);
		ResponseEntity<List<Emp>> resp2 = rt.exchange("http://emp-service/emp/list", HttpMethod.GET, req, new ParameterizedTypeReference<List<Emp>>() {});
		System.out.println("port "+re.getServerPort());
		return resp2;
		
	}
	
	public ResponseEntity<List<Emp>> getFallBack() {
		Emp e =new Emp();
		e.setName("Try after sometime");
		List li = new ArrayList();
		li.add(e);
		return ResponseEntity.ok(li);
	}
	
}
