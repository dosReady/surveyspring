package egovframework.survey.comn.login.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public class CustomUserDetail implements UserDetails {

	private static final long serialVersionUID = -1411270427766698360L;
	
	private EgovMap egovMap;
	
	public EgovMap getEgovMap() {
		return egovMap;
	}
	
	public void setEgovMap(EgovMap egovMap) {
		this.egovMap = egovMap;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ANY"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
