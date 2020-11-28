package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends MainApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        // 어떤 사람?
       // orderDetail.setUserId(4L);

        // 어떤 상품?
       // orderDetail.setItemId(1L);

        OrderDetail newOrderDetail= orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }

}