package com.study.fastcampus.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private  LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;




    // 1 : N

    // LAZY = 지연로딩, EAGER = 즉시로딩
    // EAGER 너무 많은 테이블이 존재할 경우 문제, LAZY 추천
    // EAGER는 일대일 등 가능

    // LAZY = SELECT * FROM item where id = ?;

    // EAGER =
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?

    //@OneToMany(fetch = FetchType.EAGER,mappedBy = "item")
    //private List<OrderDetail> orderDetailList;

}
