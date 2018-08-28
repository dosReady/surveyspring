package egovframework.srv.response.dao;

import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.sym.common.helper.ICommonDAO;

@Mapper(value="egovframework.srv.response.dao.IResponseDAO")
public interface IResponseDAO extends ICommonDAO {
	public EgovMap showSurvey(Map<String,Object> map) throws Exception;
	public void insert(Map<String,Object> map) throws Exception;
}
