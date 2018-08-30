package egovframework.srv.response.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.srv.response.service.ResponseService;

@RestController
@RequestMapping(value="/action/response")
public class ResponseController {
	
	@Autowired
	private ResponseService service;
	
	@RequestMapping(value="srvSubmit")
	public String srvSubmit(@RequestBody Map<String,Object> map) throws Exception {
		service.insert(map);
		return "SUCCESS";
	}
	
	@RequestMapping(value="srvRespTotal")
	public String totalResponse(@RequestBody Map<String,Object> map) throws Exception {
		service.srvCount(map);
		return "SUCCESS";
	}

}
