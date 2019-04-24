package com.example.demo.controller;

import com.example.demo.exc.MyException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import com.example.demo.forms.TrailForm;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/sentry")
public class LogbackController {

    /** 方法会发生500错误
     * @return
     */

    private final Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("/send")
    public String sendError()throws Exception{
        Integer r = 2/0;
        return "finished";
    }


    //  post方式，参数是json类型
    @PostMapping("/trail1")
    public TrailForm taril1(@RequestBody TrailForm trailForm){

        return trailForm;
    }

//  post方式，参数不是json类型
    @PostMapping("/trail4")
    public TrailForm taril4(TrailForm trailForm){

        return trailForm;
    }

//  post方式，参数不是json类型
    @PostMapping("/trail5")
    public String taril5(@RequestParam String name,
                            @RequestParam String address,
                            @RequestParam Integer age){

        return "hello";
    }


    @GetMapping("/trail2")
    public Map taril2(@RequestParam String name,
                                     @RequestParam String address,
                                     @RequestParam Integer age){
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("name", name);
        resultMap.put("addr", address);
        resultMap.put("age", String.valueOf(age));
        return resultMap;
    }

    @GetMapping("/trail3")
    public TrailForm taril3(TrailForm trailForm){

        return trailForm;
    }
}