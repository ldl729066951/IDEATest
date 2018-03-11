package com.castor.web.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.castor.web.bean.Demo;
import com.castor.web.test.dao.DemoDao;
import com.castor.web.test.dao.DemoRepository;

@Service
public class DemoService {

	@Resource
	private DemoRepository demoRepository;
	
	@Resource
	private DemoDao demoDao;
	
	@Transactional
	public void save(Demo demo){
		demoRepository.save(demo);
	}
	
	@Transactional
	public void udpate(Demo demo){		
		demoRepository.save(demo);
	}
	
	public Demo get(long id){
		return demoDao.getById(id);
	}
	
}
