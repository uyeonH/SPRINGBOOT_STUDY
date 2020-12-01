package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.User;
import org.junit.Assert;
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

        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";


        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        //System.out.println(userRepository);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read() {

        // 폰 번호로 유저 찾기
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("======== 주문 묶음 ========");
            System.out.println("수령인: " + orderGroup.getRevName());
            System.out.println("수령자: " + orderGroup.getRevAddress());
            System.out.println("총금액: " + orderGroup.getTotalPrice());
            System.out.println("총수량: " + orderGroup.getTotalQuantity());

            System.out.println("======== 주문 상세 ========");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품: " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태: " + orderDetail.getStatus());
                System.out.println("도착 예정 일자: " + orderDetail.getArrivalDate());


            });

        });
        Assert.assertNotNull(user);


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
