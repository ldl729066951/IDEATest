package com.castor.web.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.castor.web.bean.Demo;

/*
 * 在CrudRepository自带常用的crud方法.
 * 这样一个基本dao就写完了.
 */
public interface DemoRepository extends CrudRepository<Demo, Long>{

}
