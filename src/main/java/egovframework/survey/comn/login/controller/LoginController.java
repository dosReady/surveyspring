package egovframework.survey.comn.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.survey.comn.login.service.CustomUserDetail;

@Controller
public class LoginController {
	
	//sss
	@RequestMapping(value = "/login/view.do")
	public String loginview() {
		System.out.println("test");
		return "/login/view";
	}
	
	@RequestMapping(value = "/login/session.do")
	public String loginSession(HttpSession session) {
		
		CustomUserDetail usrVO = 
				(CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		EgovMap egovMap = usrVO.getEgovMap();
		session.setAttribute("id", egovMap.get("usrId"));
		session.setAttribute("role", egovMap.get("usrRole"));
		
		return "redirect:/survey/index.do";
	}
	
	@RequestMapping(value = "/login/duplicate.do")
	public String loginDuplicate() {
		return "/login/duplicate";
	}
}
