package egovframework.sym.common.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class CommonController implements ICommonController {

	@Override
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		return null;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		return null;
	}

	@Override
	public String getData(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		return null;
	}

	@Override
	public Model actionAjax(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		return null;
	}

}
