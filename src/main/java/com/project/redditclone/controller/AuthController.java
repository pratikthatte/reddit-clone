package com.project.redditclone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.redditclone.service.AuthService;
import com.project.redditclone.dto.AuthenticationResponse;
import com.project.redditclone.dto.LoginRequest;
import com.project.redditclone.dto.RegisterRequest;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;
	//Constructor-based injection for AuthService dependency
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	@PostMapping("/signup")
	public ResponseEntity<String> singup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<String>("User signup successful.",HttpStatus.OK);
	}
	@GetMapping("/accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token){
		authService.verifyToken(token);
		return new ResponseEntity<String>("Account activated successfully.",HttpStatus.OK);
	}
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
}
