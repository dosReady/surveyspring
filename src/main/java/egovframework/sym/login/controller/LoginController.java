package egovframework.sym.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.sym.login.service.CustomUserDetail;

@Controller
public class LoginController{

	@RequestMapping(value = "/login/view")
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		
		String id = (String) session.getAttribute("id");
		if(!StringUtils.isEmpty(id)){
			return "forward:/survey/view";
		}
		return "/sym/login/view";
		
	}

	@RequestMapping(value = "/login/setSession")
	public String setSession(HttpSession session) throws Exception {
		return "redirect:/survey/view";
	}
	
	@RequestMapping(value = "/survey/view")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		return "/srv/main/view";
	}
	
	@RequestMapping(value = "/action/getSession")
	@ResponseBody
	public String getSession(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		SecurityContext  securityContext  = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		CustomUserDetail details = (CustomUserDetail) securityContext.getAuthentication().getDetails();
		return details.getEgovMap().toString() ;
	}
	
}
