package egovframework.srv.management.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.srv.management.dao.ManagementDAO;
import egovframework.sym.common.helper.ICommonService;

@Service
public class ManagementService implements ICommonService  {
	
	
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
