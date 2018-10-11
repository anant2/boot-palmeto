package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcMain1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		String insert_sql = "insert into EMP(empno,name,address,salary) values(?,?,?,?)";
			
		
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insert_sql);
				pst.setInt(1, 108);
				pst.setString(2, "Paul");
				pst.setString(3, "LA");
				pst.setDouble(4, 36000);
				return pst;
			}
		});

		System.out.println("Rows inserted:::" + count);

		int count1 = jt.update(ton -> {
			PreparedStatement pst = ton.prepareStatement(insert_sql);
			pst.setInt(1, 109);
			pst.setString(2, "Dina");
			pst.setString(3, "Dallas");
			pst.setDouble(4, 40000);
			return pst;
		});

		System.out.println("Rows inserted:::" + count1);

	}

}
