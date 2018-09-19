package com.ttg.service.notice.config;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * <p>Title: JpaAuditorAware</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/19 13:14
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "jpaAuditorAware")
public class JpaAuditorAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("132");
        return Optional.of(2);
    }
}
