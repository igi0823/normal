package com.example.demo.controller;

import com.example.demo.exc.MyException;
import com.example.demo.exc.SentryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resolved")
public class SentryEventController {

    private final Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @RequestMapping(value = "/myexcept",method = RequestMethod.GET)
    @ResponseBody
    public String recordException(@RequestParam String name) {

        try{
            throw new MyException("我是MyException，参数是："+name);
        }catch (Exception msg){
            logger.error(msg.getMessage(),msg);
        }
        return "resolved MyException successful!";
    }

    @RequestMapping(value = "/sentryexcept",method = RequestMethod.GET)
    @ResponseBody
    public String recordSentryException(@RequestParam String name) {

        try{
            throw new SentryException("我是SentryException，参数是："+name);
        }catch (Exception msg){
            logger.error(msg.getMessage(),msg);
        }
        return "resolved SentryException successful!";
    }
}
