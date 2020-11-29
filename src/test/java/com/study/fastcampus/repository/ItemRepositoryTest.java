package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class ItemRepositoryTest extends MainApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(90000);
        item.setContent("HP 노트북");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id=1L;
        Optional<Item> item=itemRepository.findById(id);

//        item.ifPresent(i->{
//            System.out.println(i);
//        });

        Assert.assertTrue(item.isPresent());




    }

}