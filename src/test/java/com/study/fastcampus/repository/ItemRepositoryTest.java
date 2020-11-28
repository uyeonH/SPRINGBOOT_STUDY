package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

class ItemRepositoryTest extends MainApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item=new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem=itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }



}