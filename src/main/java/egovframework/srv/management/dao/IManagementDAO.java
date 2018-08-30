package egovframework.srv.management.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper(value= "egovframework.srv.management.dao.IManagementDAO")
public interface IManagementDAO {
	
	public EgovMap selectSrvMstr(Map<String,Object> map) throws Exception;
	public List<EgovMap> srvMstrList(Map<String,Object> map) throws Exception;
	public void insertSrvMstr(Map<String,Object> map) throws Exception;
	public void updateSrvMstr(Map<String,Object> map) throws Exception;
	public void deleteSrvMstr(String srvMstrId) throws Exception;
	
	public List<EgovMap> selectSrvMtritems(Map<String,Object> map) throws Exception;
	public List<EgovMap> selectSrvItems(Map<String,Object> map) throws Exception;
	
	public void insertSrvMtritems(Map<String,Object> map) throws Exception;
	public void deleteSrvMtritems(String srvMstrId) throws Exception;
	
	public void insertSrvitems(Map<String,Object> map) throws Exception;
	public void deleteSrvItems(String srvMstrId) throws Exception;
	
}
