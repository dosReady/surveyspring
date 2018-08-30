package egovframework.srv.response.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.srv.response.dao.IResponseDAO;

@Service
public class ResponseService{

	@Autowired
	private IResponseDAO dao;
	
	@SuppressWarnings("unchecked")
	public void insert(Map<String,Object> map) throws Exception {
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) paramMap.get("array");
		for (HashMap<String,Object> inputMap : list) {
			dao.insert(inputMap);
		}
	}
	public void srvCount(Map<String,Object> map) throws Exception {
		Integer srvMstrId = (Integer) map.get("srvMstrId");
		dao.deleteRespnstt(srvMstrId);
		dao.insertRespnstt(srvMstrId);
	}

}
