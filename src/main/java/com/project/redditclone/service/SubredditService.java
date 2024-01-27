package com.project.redditclone.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.redditclone.dto.SubredditDto;
import com.project.redditclone.exception.RedditErrorException;
import com.project.redditclone.model.Subreddit;
import com.project.redditclone.repository.SubredditRepository;

@Service
public class SubredditService {
	
	private final SubredditRepository subredditRepository;
	private final AuthService authService;
	
	public SubredditService(AuthService authService, SubredditRepository subredditRepository) {
		super();
		this.subredditRepository = subredditRepository;
		this.authService = authService;
	}

	public List<SubredditDto> getAll() {
		return subredditRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public SubredditDto getSubredditById(Long id) {
		// TODO Auto-generated method stub
		return mapToDto(subredditRepository.findById(id).orElseThrow(()->new RedditErrorException("Subreddit not found for id: "+id)));
		
	}
	
	@Transactional
	public SubredditDto createSubreddit(SubredditDto subredditDto) {
		Subreddit subreddit = subredditRepository.save(mapToSubreddit(subredditDto));
		subredditDto.setId(subreddit.getSubredditId());
		return subredditDto;
		// TODO Auto-generated method stub
		
	}
	
	private Subreddit mapToSubreddit(SubredditDto subredditDto) {
		Subreddit subreddit = new Subreddit();
		subreddit.setSubredditName("r/" + subredditDto.getName());
		subreddit.setSubredditDescription(subredditDto.getDescription());
		subreddit.setUser(authService.getCurrentUser());
		subreddit.setSubredditCreationTime(Instant.now());
		return subreddit;
		
	}

	private SubredditDto mapToDto(Subreddit subreddit) {
		SubredditDto subredditDto = new SubredditDto();
		subredditDto.setName(subreddit.getSubredditName());
		subredditDto.setDescription(subreddit.getSubredditDescription());
		subredditDto.setId(subreddit.getSubredditId());
		subredditDto.setPostCount(subreddit.getPosts().size());
		return subredditDto;
	}

}
