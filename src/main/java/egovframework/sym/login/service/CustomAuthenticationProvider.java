package egovframework.sym.login.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.sym.login.dao.LoginDAO;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	public LoginDAO loginDAO;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		
		String usrid  = (String) auth.getPrincipal();
		String usrpwd = (String) auth.getCredentials();
		
		
		UsernamePasswordAuthenticationToken result = null;
		
		try {
			
			CustomUserDetail customUserDetail = new CustomUserDetail();
			
			Map<String, Object> paramMap = new HashMap<String,Object>();
			paramMap.put("usrid", usrid);
			
			EgovMap userMap = (EgovMap) loginDAO.selectUser(paramMap);
			
			if(userMap == null ) throw new UsernameNotFoundException("사용자 정보가 없습니다.");
			
			customUserDetail.setEgovMap(userMap);
			
			String getStrPwd = (String) userMap.get("userPwd");
			
			if(!usrpwd.equals(getStrPwd)) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			result = new UsernamePasswordAuthenticationToken(usrid, usrpwd, roles);
			result.setDetails(customUserDetail);
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		} catch (BadCredentialsException  e) {
			e.printStackTrace();
			throw new BadCredentialsException(e.getMessage());
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}	
		
			
		
		return result;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
