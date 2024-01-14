package com.project.redditclone.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.project.redditclone.exception.RedditErrorException;

import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;

@Service
public class JwtProvider {
	private KeyStore keyStore;
	
	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceStream = getClass().getResourceAsStream("/springredditclone.jks");
			char[] pwdArray = "keystore".toCharArray();
			keyStore.load(resourceStream, pwdArray);
		}
		catch(KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			throw new RedditErrorException("Error loading Keystore: ",e);
		}	
	}
	public String generateToken(Authentication authenticate) {
		User principal = (User) authenticate.getPrincipal();
		return Jwts.builder().setSubject(principal.getUsername()).signWith(getPrivateKey()).compact();
	}
	private Key getPrivateKey() {
		try {
			return keyStore.getKey("springredditclone", "keystore".toCharArray());
		}
		catch(KeyStoreException | UnrecoverableKeyException | NoSuchAlgorithmException e) {
			throw new RedditErrorException("Error loading Keystore: ",e);
		}
	}
}