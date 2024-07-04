package com.jianzj.controller;

import com.jianzj.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 3:22
 */

@RestController
public class RequestController {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + " : " + age);
//        return "OK!";
//    }

    // springboot方式
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, int age) {
//        System.out.println(name + " : " + age);
//        return "OK!";
//    }

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name") String username, int age) {
        System.out.println(username + " : " + age);
        return "OK!";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "simplePojo OK!";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "simplePojo OK!";
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "arrayParam OK!";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "listParam OK!";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "dateParam OK!";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "jsonParam OK!";
    }

//    @RequestMapping("/path/{id}")
//    public String pathParam(@PathVariable int id) {
//        System.out.println(id);
//        return "pathParam OK!";
//    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "pathParam OK!";
    }
}