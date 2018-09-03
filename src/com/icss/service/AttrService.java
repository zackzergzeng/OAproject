package com.icss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.AttributesDao;

@Transactional
@Service
public class AttrService {
	@Autowired
	private AttributesDao adao;
	public void changemain(Integer attrid,Integer pid) {
		adao.updateIsmainZero(pid);
		adao.updateIsmainOne(attrid);
	}
}
