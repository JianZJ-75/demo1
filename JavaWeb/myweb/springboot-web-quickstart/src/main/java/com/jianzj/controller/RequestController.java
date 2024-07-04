package com.jianzj.controller;

import com.jianzj.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}