package egovframework.sym.login.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
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
		return null;
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
