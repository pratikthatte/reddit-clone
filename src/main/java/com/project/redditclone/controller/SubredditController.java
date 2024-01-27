package com.project.redditclone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.redditclone.dto.SubredditDto;
import com.project.redditclone.service.SubredditService;

@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
	private final SubredditService subredditService;

	public SubredditController(SubredditService subredditService) {
		super();
		this.subredditService = subredditService;
	}
	@GetMapping
	public List<SubredditDto> getAllSubreddits(){
		return subredditService.getAll();
	}
	@GetMapping("/{id}")
	public SubredditDto getSubredditById(@PathVariable Long id) {
		return subredditService.getSubredditById(id);
	}
	@PostMapping
	public SubredditDto createSubreddit(@RequestBody SubredditDto subredditDto) {
		return subredditService.createSubreddit(subredditDto);

	}
	
	
	
}
