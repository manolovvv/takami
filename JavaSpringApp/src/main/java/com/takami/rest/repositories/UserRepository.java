package com.takami.rest.repositories;

import com.takami.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    public User getUserByUsernameAndPassword(String email, String password);
    public Boolean existsUserByEmail(String email);
    public User getByUsername(String username);

    Optional<User> findAllByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

//    @Modifying
//    @Transactional
//    @Query("UPDATE User u SET u.password=?1 WHERE u.id = ?1")
//    public void changeUserPassword(String password, Long id);

}
