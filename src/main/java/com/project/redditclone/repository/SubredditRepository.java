package com.project.redditclone.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.redditclone.model.Subreddit;

public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
    Optional<Subreddit> findBySubredditName(String subredditName);
}
