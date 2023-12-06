package com.project.redditclone.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.redditclone.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByUserName(String userName);
}
