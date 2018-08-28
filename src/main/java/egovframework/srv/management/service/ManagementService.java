package egovframework.srv.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.dao.IManagementDAO;
import egovframework.sym.common.helper.ICommonService;

@Service
public class ManagementService implements ICommonService  {
	
	
	@Autowired
	public IManagementDAO dao;
	

	@Override
	@SuppressWarnings("unchecked")
	public void insert(Map<String,Object> map) throws Exception {
		HashMap<String,Object> inputMap = (HashMap<String, Object>) map.get("value");
		inputMap.put("srvMstItems", inputMap.get("srvMstItems").toString());
		dao.insert(inputMap);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void update(Map<String,Object> map) throws Exception {
		HashMap<String,Object> inputMap = (HashMap<String, Object>) map.get("value");
		inputMap.put("srvMstItems", inputMap.get("srvMstItems").toString());
		dao.update(inputMap);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void delete(Map<String,Object> map) throws Exception {
		HashMap<String,Object> inputMap = new HashMap<String,Object>();
		ArrayList<Integer> list =  (ArrayList<Integer>) map.get("value");
		for (Integer integer : list) {
			inputMap.put("srvMstrId", integer);
			dao.delete(inputMap);
		}
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
