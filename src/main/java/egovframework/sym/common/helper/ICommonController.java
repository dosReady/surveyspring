package egovframework.sym.common.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

/**
 * @개발자 도오성
 * @날짜 2018. 7. 25.
 * @설명 공통 컨트롤러 인터페이스 :
 * 이 인터페이스는 반복적인 작업을 단축하기 위해 만들어진 것으로 반복적인 행위를 그룹으로 묶어서 사용하기 위함이다.<br>
 * 구현클래스에서 처리함수를 하단부에 배치한 후 그룹함수 안에서 분기문을 통해 처리함수를 호출하는방식으로 사용하기바랍니다.    
 * 
 * @VERSION_1 view,action,getData 그룹함수 추가 
 */
public interface ICommonController {
	
	
	/**
	 * 초기 진입 그룹함수
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception;
	
	/**
	 * 데이터 처리를 위한 그룹함수
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String action(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception;
	
	/**
	 * 단순 데이터만 가져올 경우 사용  
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String getData(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception;
	
	
	/**
	 * Ajax 처리를 위한 함수  
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Model actionAjax(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception;
}
