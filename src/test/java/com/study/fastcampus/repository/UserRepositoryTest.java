package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.MainApplication;
import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends MainApplicationTests {
    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        //spring aql = insert into user(%s, %s,%d) value (account, email, age)
        User user = new User();
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setAccount("TestUser02");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User numUser = userRepository.save(user);
        System.out.println(numUser);
    }

    @Test
    public void read() {

        //Optional 제네릭?
        Optional<User> user = userRepository.findById(2L); //Long Type, id가 2인 user

        //있을 때 출력하기
        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
            System.out.println("email: " + selectUser.getEmail());
        });

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
    public void delete() {
        Optional<User> user = userRepository.findById(2L); //Long Type, id가 2인 user
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);
        if (deleteUser.isPresent()) {
            System.out.println("데이터 존재: " + deleteUser.get());
        } else {
            System.out.println("데이터 삭제 데이터 없음");

        }
    }
}
