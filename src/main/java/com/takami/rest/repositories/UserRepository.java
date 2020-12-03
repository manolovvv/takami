package com.takami.rest.repositories;

import com.takami.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    public User getUserByUsernameAndPassword(String email, String password);
    public Boolean existsUserByEmail(String email);
    public User getByUsername(String username);

    Optional<User> findAllByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
