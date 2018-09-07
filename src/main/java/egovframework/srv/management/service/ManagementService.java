package egovframework.srv.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.dao.IManagementDAO;
import egovframework.srv.response.dao.IResponseDAO;
import egovframework.sym.common.helper.ICommonService;

@Service
public class ManagementService  {
	
	
	@Autowired
	public IManagementDAO dao;
	
	@Autowired
	public IResponseDAO repDao;
	
	private JSONParser parser = new JSONParser();
	
	// 설문지 관리 데이터 생성
	@SuppressWarnings("unchecked")
	public void processCreate(Map<String,Object> map) throws Exception {
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		HashMap<String,Object> srvMstrMap = (HashMap<String, Object>) paramMap.get("srvMstr");
		
		HashMap<String,Object> inputMap = new HashMap<String,Object>();
		inputMap.put("srvMstNm", srvMstrMap.get("srvMstNm"));
		inputMap.put("srvMstTg", srvMstrMap.get("srvMstTg"));
		inputMap.put("srvMstDc", srvMstrMap.get("srvMstDc"));
		inputMap.put("instUsrId", null);
		inputMap.put("updtUsrId", null);
		
		dao.insertSrvMstr(inputMap);
		Long srvMstrId =  (Long) inputMap.get("srvMstrId");
		
		JSONArray srvMstItems = (JSONArray) parser.parse(paramMap.get("srvMtritems").toString());
		
		for (Object srvMstObj : srvMstItems) {
			
			JSONObject jsonobj = (JSONObject) srvMstObj;
			
			inputMap = new HashMap<String,Object>();
			inputMap.put("srvMstrId", srvMstrId);
			inputMap.put("srvMtritemsTitle", jsonobj.get("srvMtritemsTitle"));
			inputMap.put("srvMtritemsType", jsonobj.get("srvMtritemsType"));
			
			dao.insertSrvMtritems(inputMap);
			Long srvMtritemsId =  (Long) inputMap.get("srvMtritemsId");
			
			JSONArray srvItems  = (JSONArray) parser.parse(jsonobj.get("srvItems").toString());
			
			for (int i =0; i <srvItems.size(); i++) {
				inputMap = new HashMap<String,Object>();
				
				JSONObject srvItemsObj= (JSONObject) srvItems.get(i);
				inputMap.put("srvMstrId", srvMstrId);
				inputMap.put("srvMtritemsId", srvMtritemsId);
				inputMap.put("srvItemNm", srvItemsObj.get("srvItemNm"));
				inputMap.put("srvItemIdx", i);
				dao.insertSrvitems(inputMap);
			}
			
			
		}
		
	}

	// 설문지 데이터 수정
	public void processUpdate(Map<String,Object> map) throws Exception {
		_processUpdate(map);
		_processCreate(map);
	}
	
	// 설문지 데이터 수정처리
	@SuppressWarnings("unchecked")
	protected void _processUpdate(Map<String,Object> map) throws Exception{
		//관리테이블만 UPDATE, 하위 항목들은 DELETE , INSERT 작업으로 데이터를 수정한다.
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		HashMap<String,Object> srvMstrMap = (HashMap<String, Object>) paramMap.get("srvMstr");
		dao.updateSrvMstr(srvMstrMap);
	}
	
	// 설문 수정처리시 질문내용과 응답내용만 다시 재 생성
	@SuppressWarnings("unchecked")
	protected void _processCreate(Map<String,Object> map) throws Exception {
		HashMap<String,Object> paramMap = (HashMap<String, Object>) map.get("value");
		HashMap<String,Object> srvMstrMap = (HashMap<String, Object>) paramMap.get("srvMstr");
		
		
		String srvMstrId = srvMstrMap.get("srvMstrId").toString();
		dao.deleteSrvMtritems(Integer.parseInt(srvMstrId));
		dao.deleteSrvItems(Integer.parseInt(srvMstrId));
		
		// 설문응답 삭제
		repDao.deleteRespns(Integer.parseInt(srvMstrId));
		// 설문 응답통계 삭제
		repDao.deleteRespnstt(Integer.parseInt(srvMstrId));
		
		JSONArray srvMstItems = (JSONArray) parser.parse(paramMap.get("srvMtritems").toString());
		
		for (Object srvMstObj : srvMstItems) {
			
			JSONObject jsonobj = (JSONObject) srvMstObj;
			
			HashMap<String,Object> inputMap = new HashMap<String,Object>();
			inputMap.put("srvMstrId", srvMstrId);
			inputMap.put("srvMtritemsTitle", jsonobj.get("srvMtritemsTitle"));
			inputMap.put("srvMtritemsType", jsonobj.get("srvMtritemsType"));
			
			dao.insertSrvMtritems(inputMap);
			Long srvMtritemsId =  (Long) inputMap.get("srvMtritemsId");
			
			JSONArray srvItems  = (JSONArray) parser.parse(jsonobj.get("srvItems").toString());
			
			for (int i =0; i <srvItems.size(); i++) {
				inputMap = new HashMap<String,Object>();
				
				JSONObject srvItemsObj= (JSONObject) srvItems.get(i);
				inputMap.put("srvMstrId", srvMstrId);
				inputMap.put("srvMtritemsId", srvMtritemsId);
				inputMap.put("srvItemNm", srvItemsObj.get("srvItemNm"));
				inputMap.put("srvItemIdx", i);
				dao.insertSrvitems(inputMap);
			}
			
			
		}
	}

	// 설문지 데이터 삭제
	@SuppressWarnings("unchecked")
	public void processDelete(Map<String,Object> map) throws Exception {
		ArrayList<Integer> list =  (ArrayList<Integer>) map.get("value");
		for (Integer srvMstrId : list) {
			_processDelete(srvMstrId);
		}
	}
	
	// 설문지 데이터 삭제처리
	protected void _processDelete(Integer srvMstrId) throws Exception {
		dao.deleteSrvMstr(srvMstrId);
		dao.deleteSrvMtritems(srvMstrId);
		dao.deleteSrvItems(srvMstrId);
		
		// 응답 및 통계 데이터 삭제
		repDao.deleteRespns(srvMstrId);
		repDao.deleteRespnstt(srvMstrId);
	}
	
	// 설문지 목록
	public List<EgovMap> getList(Map<String, Object> map) throws Exception {
		return dao.srvMstrList(map);
	}
	
	// 설문지 상세
	public EgovMap getDetail(Map<String, Object> map) throws Exception {
		EgovMap resultMap = new EgovMap();
		EgovMap selectSrvMstrt = dao.selectSrvMstr(map);
		List<EgovMap> selectSrvMtritems = dao.selectSrvMtritems(map);
		
		HashMap<String, Object> inputMap = new HashMap<String,Object>();
		inputMap.put("srvMstrId",map.get("value"));
		for (EgovMap srvMtritemsMap : selectSrvMtritems) {
			inputMap.put("srvMtritemsId",(Long) srvMtritemsMap.get("srvMtritemsId"));
			List<EgovMap> selectSrvItems = dao.selectSrvItems(inputMap);
			srvMtritemsMap.put("srvItems", selectSrvItems);
		}
		resultMap.put("srvMstr", selectSrvMstrt);
		resultMap.put("srvMtritems", selectSrvMtritems);
		return resultMap;
	}

	
	

}
