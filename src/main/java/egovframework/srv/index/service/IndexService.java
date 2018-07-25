package egovframework.srv.index.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.srv.index.dao.IndexDAO;
import egovframework.sym.common.helper.ICommonService;

@Service
public class IndexService implements ICommonService {

	@Autowired
	public IndexDAO dao;
	
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
