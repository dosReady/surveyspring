package egovframework.srv.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.srv.management.service.ManagementService;

public class ManagementController{
	
	@Autowired
	public ManagementService service;
	
	
	// VIEW 
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, EgovMap map) throws Exception {
		return"결과";
	}
	
	public String createSurveyTmplt(HttpServletRequest request, HttpServletResponse response, HttpSession session, EgovMap map) throws Exception {
		return "SUCCESS";
	}
	public void goWorkspace(HttpServletRequest request, HttpServletResponse response, HttpSession session, EgovMap map) throws Exception {}
	public void regToolForm(HttpServletRequest request, HttpServletResponse response, HttpSession session, EgovMap map) throws Exception {}
	
	
	
	
	
	
	
	
}
