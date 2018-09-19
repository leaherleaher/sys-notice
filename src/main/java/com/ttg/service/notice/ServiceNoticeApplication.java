package com.ttg.service.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServiceNoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNoticeApplication.class, args);
    }
}
