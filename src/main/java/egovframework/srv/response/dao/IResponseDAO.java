package egovframework.srv.response.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.sym.common.helper.ICommonDAO;

@Mapper(value="egovframework.srv.response.dao.IResponseDAO")
public interface IResponseDAO extends ICommonDAO {
	public void insert(Map<String,Object> map) throws Exception;
	public void deleteRespns(Integer srvMstrId) throws Exception;
	public void deleteRespnstt(Integer srvMstrId) throws Exception;
	public void insertRespnstt(Integer srvMstrId) throws Exception;
	public Integer countSrvRespns(Integer srvMstrId) throws Exception;
	public List<EgovMap> selectSttObjLabel(Integer srvMstrId) throws Exception;
	public List<EgovMap> selectSttObjData(Map<String,Object> map) throws Exception;
}
