package com.study.fastcampus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration  // 설정파일
@EnableJpaAuditing // JPA 감시 활성화
public class JpaConfig {
}
