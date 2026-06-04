package com.rigel.user.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rigel.user.dao.IUserDao;
import com.rigel.user.model.Roles;
import com.rigel.user.model.User;


@Component
@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	IUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("User name >>> "+username);
		User user = userDao.findUserByEmailId(username,0);
//		System.out.println("User name >>> "+user.getId());
        if (user!= null) {
        	return new JwtUser(user.getId(), user.getEmail_id(),
        			user.getPassword(), mapToGrantedAuthorities(user.getRoles()),
        			user.getStatus(), user.getLastPasswordResetDate());
          }else {
        	throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));	
        }
	}
	
	 private static Set<GrantedAuthority> mapToGrantedAuthorities(Set<Roles> rolesSet) {
		 Roles firstRole = rolesSet.stream()
                 .findFirst()
                 .orElse(null);
    	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(firstRole!=null?firstRole.getRole():"NA"));
//	    System.out.println(grantedAuthorities.contains(new SimpleGrantedAuthority("user")));
    	return grantedAuthorities;
    }

}
