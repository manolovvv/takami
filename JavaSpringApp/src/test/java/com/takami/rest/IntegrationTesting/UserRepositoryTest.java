package com.takami.rest.IntegrationTesting;


import com.takami.rest.model.User;
import com.takami.rest.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;



    @Test
    public void whenFindById(){
        User user = new User();
        user.setUsername("test");
        testEntityManager.persist(user);
        testEntityManager.flush();

        User found = userRepository.getByUsername("test");

        assertEquals(found.getUsername(),"test");
    }

    @Test
    public void whenChangePassword(){
        User user = new User();
        user.setPassword("test");
        testEntityManager.persist(user);
        testEntityManager.flush();

        User found = userRepository.getOne(1L);

        assertEquals("test",found.getPassword());

        user.setPassword("test123");

        testEntityManager.merge(user);

        User f = userRepository.getOne(1L);
        Assert.assertEquals("test123",f.getPassword());

        


    }

    @Test
    public void existsByEmailTest(){
        User u1 = new User();
        u1.setEmail("test@");
        testEntityManager.persist(u1);
        testEntityManager.flush();
        assertEquals(userRepository.existsByEmail("test@"),true);

    }

    @Test
    public void existsByUsernameTest(){
        User u1 = new User();
        u1.setUsername("test");
        testEntityManager.persist(u1);
        testEntityManager.flush();
        assertEquals(userRepository.existsByUsername("test"),true);

    }

}
