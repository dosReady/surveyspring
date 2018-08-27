package egovframework.srv.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.dao.ManagementDAO;
import egovframework.sym.common.helper.ICommonService;

@Service
public class ManagementService implements ICommonService  {
	
	
	@Autowired
	public ManagementDAO dao;
	

	@Override
	@SuppressWarnings("unchecked")
	public void insert(Map<String,Object> map) throws Exception {
		HashMap<String,Object> inputMap = (HashMap<String, Object>) map.get("value");
		inputMap.put("srvMstItems", inputMap.get("srvMstItems").toString());
		dao.insert(inputMap);
	}

	@Override
	public void update(Map<String,Object> map) throws Exception {
	}

	@Override
	public void delete(Map<String,Object> map) throws Exception {
	}

	@Override
	public List<EgovMap> list(Map<String, Object> map) throws Exception {
		return dao.list(map);
	}

	@Override
	public EgovMap select(Map<String, Object> map) throws Exception {
		return dao.select(map);
	}

	
	

}
