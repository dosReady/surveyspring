package egovframework.survey.main.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.survey.comn.util.ISurveyCommonService;
import egovframework.survey.main.dao.MainDAO;

@Service
public class MainService implements ISurveyCommonService {
	
	
	@Autowired
	public MainDAO dao;

	@Override
	public void insert(Map<String, Object> map) throws Exception {
	}

	@Override
	public void update(Map<String, Object> map) throws Exception {
	}

	@Override
	public void delete(Map<String, Object> map) throws Exception {
	}

	@Override
	public Map<String, Object> select(Map<String, Object> map) throws Exception {
		return null;
	}

}
