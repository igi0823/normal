package com.example.demo.config;

import io.sentry.Sentry;
import io.sentry.spring.SentryExceptionResolver;
import io.sentry.spring.SentryServletContextInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.PostConstruct;

/**
 * Author: Yang Naihua<br>
 * Description:com.example.demo <br>
 * Date: Create in 15:15 2018/4/13<br>
 * Modified By:
 */
// 可以调用生产环境
//@ActiveProfiles("prod")
//@Configuration
public class SentryConfig {
    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new SentryExceptionResolver();
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new SentryServletContextInitializer();
    }

    @PostConstruct
    public void init(){
        Sentry.init("https://2df32d9ff1d848d39d198c9dac372fe3:e0a2310c8d2e485b93ac837fab72e74a@sentry.io/1425079");
    }
}
