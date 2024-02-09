package com.project.redditclone.model;

import java.time.Instant;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	private Instant postCreationTime;
	private String postName;
	private String postUrl;
	private String postDescription;
	
	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	private User user;
	@ManyToOne
	@JoinColumn(name="subredditId", referencedColumnName="subredditId")
	private Subreddit subreddit;
	/**
	 * @return the postCreationTime
	 */
	public Instant getPostCreationTime() {
		return postCreationTime;
	}
	/**
	 * @param postCreationTime the postCreationTime to set
	 */
	public void setPostCreationTime(Instant postCreationTime) {
		this.postCreationTime = postCreationTime;
	}
	/**
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	/**
	 * @return the postUrl
	 */
	public String getPostUrl() {
		return postUrl;
	}
	/**
	 * @param postUrl the postUrl to set
	 */
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
	/**
	 * @return the postDescription
	 */
	public String getPostDescription() {
		return postDescription;
	}
	/**
	 * @param postDescription the postDescription to set
	 */
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the subreddit
	 */
	public Subreddit getSubreddit() {
		return subreddit;
	}
	/**
	 * @param subreddit the subreddit to set
	 */
	public void setSubreddit(Subreddit subreddit) {
		this.subreddit = subreddit;
	}
}
