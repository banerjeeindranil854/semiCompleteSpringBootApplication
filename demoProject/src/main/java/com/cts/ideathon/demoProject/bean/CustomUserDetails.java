package com.cts.ideathon.demoProject.bean;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@SuppressWarnings("serial")
public class CustomUserDetails extends ResisterUser implements UserDetails{

	public CustomUserDetails(final ResisterUser users) {
        super(users);
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorityRoles=new ArrayList<>();
		for(Role role:getRoles()) {
			SimpleGrantedAuthority SimpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_"+role.getRole());
			simpleGrantedAuthorityRoles.add(SimpleGrantedAuthority);
		}
		return simpleGrantedAuthorityRoles;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
