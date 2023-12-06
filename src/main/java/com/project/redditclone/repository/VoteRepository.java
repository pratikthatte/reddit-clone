package com.project.redditclone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.redditclone.model.Post;
import com.project.redditclone.model.User;
import com.project.redditclone.model.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long>{
	Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User user);
}
