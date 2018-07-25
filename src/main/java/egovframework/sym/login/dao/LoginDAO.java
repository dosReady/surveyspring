package egovframework.sym.login.dao;

import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("egovframework.sym.login.dao.LoginDAO")
public interface LoginDAO {
	
	public EgovMap selectUser(Map<String,Object> paramMap) throws Exception;
}
