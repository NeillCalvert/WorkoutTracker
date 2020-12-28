/**
 * 
 */
package com.neill.workouttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.neill.workouttracker.dao.UserRepository;
import com.neill.workouttracker.model.User;
import com.neill.workouttracker.security.CustomUserDetails;

/**
 * @author neill
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	/**
	 * 
	 */
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new CustomUserDetails(user);
    }
    
    public User findUserByUserName(String username) {
    	return userRepository.findUserByUserName(username);
    }

}
