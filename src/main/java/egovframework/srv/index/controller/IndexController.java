package egovframework.srv.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import dosframework.invoker.CommonController;
import egovframework.srv.index.service.IndexService;


public class IndexController{
	
	
	@Autowired
	public IndexService service;
	
	public void view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {}
	
}
