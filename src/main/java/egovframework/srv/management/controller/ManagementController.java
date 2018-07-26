package egovframework.srv.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import dosframework.invoker.CommonController;
import egovframework.srv.management.service.ManagementService;

public class ManagementController extends CommonController {
	
	@Autowired
	public ManagementService service;
	
	public void list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	
	public void regForm(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	
	public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		System.out.println("qwewqe");
		return "{}";
	}
	
	
}
