package egovframework.sym.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.sym.common.helper.CommonController;
import egovframework.sym.common.helper.ICommonController;
import egovframework.sym.login.service.CustomUserDetail;

@Controller
public class LoginController extends CommonController {

	@Override
	@RequestMapping(value = "/login/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		
		String id = (String) session.getAttribute("id");
		if(!StringUtils.isEmpty(id)){
			return "forward:/survey/view.do";
		}
		return "/sym/login/view";
		
	}

	@Override
	@RequestMapping(value = "/login/action.do")
	public String action(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String type= request.getParameter("type");
			
		switch (type) {
		case "session":
				setSession(session);
			break;
		default:
			throw new Exception();
		}
		
		return "redirect:/survey/view.do";
	}

	/**
	 * 로그인 성공 후 세션처리 함수 
	 *
	 * @param session
	 */
	protected void setSession(HttpSession session) {
		CustomUserDetail usrVO = 
				(CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
		EgovMap egovMap = usrVO.getEgovMap();
		session.setAttribute("id", egovMap.get("userId"));
		session.setAttribute("role", egovMap.get("userRole"));
	}
	
	
}
