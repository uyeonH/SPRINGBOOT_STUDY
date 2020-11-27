package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.MainApplication;
import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends MainApplicationTests {
    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;
    @Test
    public void create() {
        //spring aql = insert into user(%s, %s,%d) value (account, email, age)
        User user = new User();
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setAccount("TestUser01");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User numUser=userRepository.save(user);
        System.out.println(numUser);
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
