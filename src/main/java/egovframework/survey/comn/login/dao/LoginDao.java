package egovframework.survey.comn.login.dao;

import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("egovframework.survey.comn.login.dao.LoginDao")
public interface LoginDao {
	
	public EgovMap selectUser(Map<String,Object> paramMap) throws Exception;
}
