package com.castor.web.test.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.castor.web.bean.Demo;

@Repository
public class DemoDao {

	@Resource
    private JdbcTemplate jdbcTemplate;
	
	public Demo getById(long id){
		String sql = "select * from Demo where id = ?";
		RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,id);
	}
	
}
