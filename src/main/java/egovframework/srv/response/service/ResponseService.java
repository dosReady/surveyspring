package egovframework.srv.response.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.response.dao.IResponseDAO;

@Service
public class ResponseService{

	@Autowired
	private IResponseDAO dao;
	
	public EgovMap showSurvey(Map<String,Object> map) throws Exception {
		return dao.showSurvey(map);
	}
	
	@SuppressWarnings("unchecked")
	public void insert(Map<String,Object> map) throws Exception {
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		
		HashMap<String, Object> inputMap = new HashMap<String,Object>();
		inputMap.put("srvMstrId", paramMap.get("srvMstrId"));
		inputMap.put("srvRespnsJson", paramMap.get("array"));
		inputMap.put("instUsrid", Math.random()); //임시
		dao.insert(inputMap);
	}

}
