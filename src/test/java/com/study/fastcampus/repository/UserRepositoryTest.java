package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
//import static org.junit.Assert.*;

public class UserRepositoryTest extends MainApplicationTests {
    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {

    }

    @Test
    @Transactional
    public void read() {



    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L); //Long Type, id가 2인 user
        user.ifPresent(selectUser -> {
            // selectUser.setId(3L); -> 이렇게 해버리면 id가 3인 곳 데이터가 바뀌므로 주의하기
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");
            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 데이터베이스에서 동작이 일어나지 않음, 롤백?
    public void delete() {
        Optional<User> user = userRepository.findById(2L); //Long Type, id가 2인 user

        //Assert.assertTrue(user.isPresent());
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);
        //Assert.assertFalse(deleteUser.isPresent());
    }
}
