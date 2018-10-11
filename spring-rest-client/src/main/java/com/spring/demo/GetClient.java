package com.spring.demo;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "text/plain");
		
		Emp e = new Emp();
		e.setEmpId(300);
		HttpEntity req = new HttpEntity<>(e,headers);
		
		ResponseEntity<String> resp = rt.exchange("http://localhost:9000/emp/delete", HttpMethod.GET, req, String.class);
		System.out.println(resp.getBody());
		
		/*ResponseEntity<String> resp = rt.exchange("http://localhost:9000/empfind/111", HttpMethod.GET, req, String.class);
		System.out.println(resp.getBody());

		ResponseEntity<Emp> resp1 = rt.exchange("http://localhost:9000/empfind/104", HttpMethod.GET, req, Emp.class);
		System.out.println(resp1.getBody().getName());

		ResponseEntity<List<Emp>> resp2 = rt.exchange("http://localhost:9000/emp/list", HttpMethod.GET, req, new ParameterizedTypeReference<List<Emp>>() {});
		resp2.getBody().stream().forEach(e->System.out.println(e.getName()+" "+e.getEmpId()+" "+e.getSalary()));*/

		/*RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Accept", "text/plain");
		Emp e = new Emp(300, "Ankit", "Hyderabad", 50000);
		HttpEntity req = new HttpEntity<>(e,headers);
		
		
		ResponseEntity<String> resp3 = rt.exchange("http://localhost:9000/emp/save", HttpMethod.POST, req, String.class);
		System.out.println(resp3.getBody().toString());*/
	}

}
