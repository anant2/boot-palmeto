package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository("empJpa")
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "success::Emp saved";
	}

	@Override
	public Emp findbyId(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	public String delete(int id) {
		String response = "";
		Query query = em.createQuery("delete from Emp where empno="+id);
		
		if (query.executeUpdate()>0) {
			response = "Deleted successfully";

		} else {
			response = "Employee not found";

		}
		return response;
	}

	@Override
	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		return query.getResultList();
	}

}
