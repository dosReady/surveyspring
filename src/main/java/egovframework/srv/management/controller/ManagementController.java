package egovframework.srv.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import dosframework.invoker.CommonController;
import egovframework.srv.management.service.ManagementService;

public class ManagementController{
	
	@Autowired
	public ManagementService service;
	
	
	// VIEW 
	public void list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	public void regForm(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	public void goWorkspace(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	public void regToolForm(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	
	
	
	
	
	
	
	
}
