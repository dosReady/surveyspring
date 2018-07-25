package egovframework.sym.common.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public abstract class FormController implements IFormController {

	@Override
	public String view(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return null;
	}

	@Override
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return null;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return null;
	}

}
