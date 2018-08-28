package egovframework.srv.response.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.response.service.ResponseService;

@RestController
@RequestMapping(value="/action/response")
public class ResponseController {
	
	@Autowired
	private ResponseService service;
	
	private ObjectMapper mapper =  new ObjectMapper();
	
	@RequestMapping(value="/view")
	public String respshow(@RequestBody Map<String,Object> map) throws Exception {
		EgovMap showSurvey = service.showSurvey(map);
		return mapper.writeValueAsString(showSurvey);
	}
	
	@RequestMapping(value="srvSubmit")
	public String srvSubmit(@RequestBody Map<String,Object> map) throws Exception {
		service.insert(map);
		return "SUCCESS";
	}

}
