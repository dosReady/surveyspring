package egovframework.srv.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.srv.index.service.IndexService;
import egovframework.sym.common.helper.CommonController;

@Controller
public class IndexController extends CommonController {
	
	
	@Autowired
	public IndexService service;
	
	@Override
	@RequestMapping(value="/survey/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		return "/srv/main/view";
	}
	
}
