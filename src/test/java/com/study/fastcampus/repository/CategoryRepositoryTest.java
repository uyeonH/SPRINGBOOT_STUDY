package com.study.fastcampus.repository;

import com.study.fastcampus.MainApplicationTests;
import com.study.fastcampus.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends MainApplicationTests {


    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();

        category.setTitle(title);
        category.setType(type);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory=categoryRepository.save(category);
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(),type);
        Assert.assertEquals(newCategory.getTitle(),title);

    }

    @Test
    public void read() {
        Optional<Category> optionalCategory=categoryRepository.findById(1L);
        optionalCategory.ifPresent(c->{
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());

        });
    }
}