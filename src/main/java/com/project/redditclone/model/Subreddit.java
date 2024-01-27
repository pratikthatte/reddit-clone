package com.project.redditclone.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Subreddit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subredditId;
	private Instant subredditCreationTime;
	private String subredditDescription;
	private String subredditName;
	@ManyToOne
	private User user;
	
	/**
	 * @return the subredditId
	 */
	public long getSubredditId() {
		return subredditId;
	}
	@OneToMany
	private List<Post> posts;
	/**
	 * @return the subredditCreationTime
	 */
	public Instant getSubredditCreationTime() {
		return subredditCreationTime;
	}
	/**
	 * @param subredditCreationTime the subredditCreationTime to set
	 */
	public void setSubredditCreationTime(Instant subredditCreationTime) {
		this.subredditCreationTime = subredditCreationTime;
	}
	/**
	 * @return the subredditDescription
	 */
	public String getSubredditDescription() {
		return subredditDescription;
	}
	/**
	 * @param subredditDescription the subredditDescription to set
	 */
	public void setSubredditDescription(String subredditDescription) {
		this.subredditDescription = subredditDescription;
	}
	/**
	 * @return the subredditName
	 */
	public String getSubredditName() {
		return subredditName;
	}
	/**
	 * @param subredditName the subredditName to set
	 */
	public void setSubredditName(String subredditName) {
		this.subredditName = subredditName;
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
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
