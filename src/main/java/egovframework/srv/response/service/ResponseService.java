package egovframework.srv.response.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.dao.IManagementDAO;
import egovframework.srv.response.dao.IResponseDAO;

@Service
public class ResponseService{

	@Autowired
	private IResponseDAO dao;
	
	@Autowired
	private IManagementDAO managementDao;
	
	@SuppressWarnings("unchecked")
	public void insert(Map<String,Object> map) throws Exception {
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) paramMap.get("array");
		for (HashMap<String,Object> inputMap : list) {
			dao.insert(inputMap);
		}
	}
	public String srvCount(Map<String,Object> map) throws Exception {
		Integer srvMstrId = (Integer) map.get("srvMstrId");
		
		Integer countSrvRespns = dao.countSrvRespns(srvMstrId);
		if( countSrvRespns >  0) {
			dao.deleteRespnstt(srvMstrId);
			dao.insertRespnstt(srvMstrId);
			return "0";
		}else {
			return "1";
		}
	}
	
	public EgovMap showStt(Map<String,Object> map) throws Exception {
		Integer srvMstrId = Integer.parseInt( map.get("srvMstrId").toString() );
		
		HashMap<String, Object> inputMap = new HashMap<String,Object>();
		inputMap.put("value", srvMstrId);
		EgovMap srvMstr = managementDao.selectSrvMstr(inputMap);
		List<EgovMap> srvMtrItemsMap = dao.selectSttObjLabel(srvMstrId);
		
		for (EgovMap egovMap : srvMtrItemsMap) {
			inputMap = new HashMap<String,Object>();
			inputMap.put("srvMstrId", srvMstrId);
			inputMap.put("srvMtritemsId", Integer.parseInt(egovMap.get("srvMtritemsId").toString()));
			List<EgovMap> selectSttObjData = dao.selectSttObjData(inputMap);
			egovMap.put("sttObjData", selectSttObjData);
		}
		
		EgovMap resultMap = new EgovMap(); 
		resultMap.put("srvMstr",srvMstr);
		resultMap.put("srvMtrItems", srvMtrItemsMap);
		return resultMap;
	}

}
