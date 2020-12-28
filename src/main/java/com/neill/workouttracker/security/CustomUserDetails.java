/**
 * 
 */
package com.neill.workouttracker.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.neill.workouttracker.model.User;

/**
 * @author neill
 *
 */
public class CustomUserDetails implements UserDetails{
	
	private User user;

	/**
	 * 
	 */
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
		return Arrays.asList(authority);
	}


	@Override
	public String getPassword() {
		
		return user.getPassword();
	}


	@Override
	public String getUsername() {
		
		return user.getUserName();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
