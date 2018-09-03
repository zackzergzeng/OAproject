package com.icss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.AttributesDao;
import com.icss.dao.ProcessBasicInfoDao;
import com.icss.dao.StepsDao;
import com.icss.entity.Attributes;
import com.icss.entity.ProcessBasicInfo;
import com.icss.entity.Steps;

@Transactional
@Service
public class UpdateService {
	@Autowired
	ProcessBasicInfoDao pbidao;
	@Autowired
	StepsDao sdao;
	@Autowired
	AttributesDao adao;
	public void updateProcessBasicInfo(ProcessBasicInfo basicInfo) {
		pbidao.deleteProcessInfoById(basicInfo.getPid());
		pbidao.insertProcess(basicInfo);
	}
	public void updateStep(Steps step) {
		sdao.deleteSteps(step.getStep_id());
		sdao.insertSteps(step);
	}
	public void updateAttr(Attributes attributes) {
		adao.deleteAttr(attributes.getAttrid());
		adao.insertAttr(attributes);
	}
}
