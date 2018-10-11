package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class Singer implements Performer {

	/*@Autowired
	Audience audience;*/
	
	@Override
	public void perform() throws Exception {
		//audience.takeSeat();
		//audience.switchOffMobile();
		System.out.println("Singer is now singing");
		//audience.applaud();
		//throw new Exception();
	}

}
