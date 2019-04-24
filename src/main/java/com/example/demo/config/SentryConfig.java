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
        Sentry.init("http://1add998a8d6842929ab37035f2bc76cf:57481e4a6dd0405b92328fdcdf90e665@sentry.qfang.com:9000/2");
    }
}
