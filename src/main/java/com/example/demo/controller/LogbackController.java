package com.example.demo.controller;

import com.example.demo.exc.MyException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {

    /** 方法会发生500错误
     * @return
     */

    private final Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("/helloworld")
    public String helloworld() {

        try{
             throw new MyException("这是一个错误！");
        }catch (Exception msg){
            logger.error(msg.getMessage(),msg);
        }
        return "Hello World!";
    }
}