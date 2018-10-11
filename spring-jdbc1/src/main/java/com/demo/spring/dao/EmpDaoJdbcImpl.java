package com.demo.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository("empJdbc")
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	private JdbcTemplate jt;

	public String save(Emp e) {

		String response = "";
		try {
			String insert_sql = "insert into EMP(empno,name,address,salary) values(?,?,?,?)";

			jt.update(ton -> {
				PreparedStatement pst = ton.prepareStatement(insert_sql);
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			});
			response = "Data Saved";
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("Duplicate key");
		}

		return response;

	}

	@Override
	public Emp findbyId(int id) {
		Emp e = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});

		return e;
	}

	@Override
	public String delete(int id) {

		String response = "";
		try {
			String insert_sql = "delete from emp where empno=" + id;
			int count=jt.update(ton -> {
				PreparedStatement pst = ton.prepareStatement(insert_sql);
				return pst;
			});
			if(count==1) {
				response = "Data  Deleted";
			}else {
				throw new RuntimeException("employee not found");
			}
		} catch (DataAccessException e1) {
			throw new RuntimeException("employee not found");
		}

		return response;
	}

	@Override
	public List<Emp> getAll() {

		String retrieve = "select * from EMP";

		List<Emp> empList = jt.query(retrieve, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});

		return empList;
	}

}
