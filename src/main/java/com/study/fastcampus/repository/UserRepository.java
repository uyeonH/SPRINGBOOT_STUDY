package com.study.fastcampus.repository;

import com.study.fastcampus.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // Long 식별자 타입


}
