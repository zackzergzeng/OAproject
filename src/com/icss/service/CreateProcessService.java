package com.icss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.AttributesDao;
import com.icss.dao.AuditingDao;
import com.icss.dao.ProAttrValueDao;
import com.icss.dao.StepsDao;
import com.icss.dao.UserProcessDao;
import com.icss.entity.Auditing;
import com.icss.entity.ProAttrValue;
import com.icss.entity.Steps;
import com.icss.entity.UserProcess;

@Transactional
@Service
public class CreateProcessService {
	@Autowired
	private ProAttrValueDao pavdao;
	@Autowired
	private UserProcessDao updao;
	@Autowired
	private AuditingDao audao;
	@Autowired
	private StepsDao sdao;
	public void createProcess(List<ProAttrValue> pavlist,UserProcess userProcess){
		updao.insertProcess(userProcess);
		for (ProAttrValue pav : pavlist) {
			pav.setProcess_id(userProcess.getProcess_id());
			pavdao.insertProAttrValue(pav);
		}
		List<Steps> slist=sdao.findStepsByProcess(userProcess.getPid());
		for (Steps steps : slist) {
			Auditing auditing=new Auditing();
			auditing.setAud_time(userProcess.getTime());
			auditing.setProcess_id(userProcess.getProcess_id());
			auditing.setStep_id(steps.getStep_id());
			//auditing.setUser_Id(userProcess.getUser_id());
			audao.insertAuditing(auditing);
		}
	}
}
