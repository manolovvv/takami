package com.takami.rest.repositories;

import com.takami.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {
    public User getUserByEmailAndPassword(String email, String password);
    public boolean existsUserByEmail(String email);
}
