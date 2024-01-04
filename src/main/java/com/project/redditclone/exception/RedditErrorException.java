package com.project.redditclone.exception;

@SuppressWarnings("serial")
public class RedditErrorException extends RuntimeException {
	public RedditErrorException(String message) {
		super(message);
	}
	public RedditErrorException(String message, Throwable err) {
		super(message,err);
	}
}
