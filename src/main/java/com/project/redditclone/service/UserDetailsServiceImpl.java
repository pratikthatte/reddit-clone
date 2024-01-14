package com.project.redditclone.service;

import java.util.Collection;
import java.util.Optional;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.redditclone.model.User;
import com.project.redditclone.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> tempUser = userRepository.findByUserName(username);
		User user = tempUser.orElseThrow(()-> new UsernameNotFoundException("No user found for username: "+username));
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),user.isEnabled(),true, true, true, getAuthorites("USER"));
	}

	private Collection<? extends GrantedAuthority> getAuthorites(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}
	
}
