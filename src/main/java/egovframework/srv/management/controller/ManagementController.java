package egovframework.srv.management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.service.ManagementService;

@RestController
@RequestMapping(value="/action/management")
public class ManagementController{
	
	@Autowired
	public ManagementService service;
	
	private ObjectMapper mapper =  new ObjectMapper();
	
	@RequestMapping(value="/create")
	public String create(@RequestBody Map<String,Object> map) throws Exception {
		service.insert(map);
		return "SUCCESS";
	}
	
	@RequestMapping(value="/update")
	public String update(@RequestBody Map<String,Object> map) throws Exception {
		service.update(map);
		return "SUCCESS";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestBody(required=false) Map<String,Object> map) throws Exception {
		service.delete(map);
		return "SUCCESS";
	}
	
	@RequestMapping(value={"/detail","/modify"})
	public String detail(@RequestBody(required=false) Map<String,Object> map) throws Exception {
		EgovMap detail = service.select(map);
		return mapper.writeValueAsString(detail);
	}
	
	@RequestMapping(value="/list")
	public String list(@RequestBody(required=false) Map<String,Object> map) throws Exception {
		List<EgovMap> list = service.list(map);
		return mapper.writeValueAsString(list);
	}
	
	
	
	
	
	
	
	
}
