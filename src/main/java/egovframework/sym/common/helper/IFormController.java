package egovframework.sym.common.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;



/**
 * @개발자 도오성
 * @날짜 2018. 7. 25.
 * @설명 반복 작업 단축을 위한 컨트롤러 인터페이스 
 */
public interface IFormController {
	
	/**
	 * VIEW FORM 
	 *  
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	public String view(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
	
	/**
	 * REG FORM
	 *  
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
	
	/**
	 * EDIT FORM
	 *  
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
	
	/**
	 * DELETE FORM
	 *  
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
}
