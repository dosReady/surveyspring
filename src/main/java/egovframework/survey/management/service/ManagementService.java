package egovframework.survey.management.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.survey.comn.util.ISurveyCommonService;
import egovframework.survey.management.dao.ManagementDAO;

@Service
public class ManagementService implements ISurveyCommonService  {
	
	
	@Autowired
	public ManagementDAO dao;
	
	
	@Override
	public void insert(Map<String, Object> map) throws Exception {
		dao.insert(map);
	}

	@Override
	public void update(Map<String, Object> map) throws Exception {
	}

	@Override
	public void delete(Map<String, Object> map) throws Exception {
	}

	@Override
	public Map<String, Object> select(Map<String, Object> map) throws Exception {
		return dao.select(map);
	}
	

}
