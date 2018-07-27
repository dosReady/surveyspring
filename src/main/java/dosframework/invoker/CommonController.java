package dosframework.invoker;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.XmlWebApplicationContext;

import dosframework.bean.ActionMappingBean;

@Controller
public class CommonController{
	
	@Autowired
	private XmlWebApplicationContext context;
	
	@RequestMapping(value = "/survey/**")
	public String call(HttpServletRequest request, HttpServletResponse response,HttpSession session, Model model) {
		
		String actionId = request.getServletPath();
		
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		ActionMappingBean bean = (ActionMappingBean) beanFactory.getBean(actionId);
		
		String view = bean.getView();
		String classNm = bean.getClassNm();
		String classMethod = bean.getClassMethod();
		
		try {
			
			Class<?> loadClass = Class.forName(classNm);
			Object instance = loadClass.newInstance();
			Class<?>[] paramClassType = new Class[] {HttpServletRequest.class, HttpServletResponse.class,HttpSession.class, Model.class};
			Method method = loadClass.getMethod(classMethod,paramClassType);
			Object[] param = new Object[] {request, response,session,model};
			
			method.invoke(instance,param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}

}
