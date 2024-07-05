package com.jianzj.controller;

import com.jianzj.pojo.Address;
import com.jianzj.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 22:20
 */

@RestController
public class ResponseController {
//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("hello SpringBoot~");
//        return "Hello SpringBoot~";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address address = new Address();
//        address.setProvince("安徽");
//        address.setCity("宣城");
//        return address;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        List<Address> list = new ArrayList<>();
//        Address addr1 = new Address();
//        addr1.setProvince("安徽");
//        addr1.setCity("宣城");
//        Address addr2 = new Address();
//        addr2.setProvince("安徽");
//        addr2.setCity("屯溪");
//        Collections.addAll(list, addr1, addr2);
//        return list;
//    }

    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("hello SpringBoot~");
        return Result.success("hello SpringBoot~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address();
        address.setProvince("安徽");
        address.setCity("宣城");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();
        Address addr1 = new Address();
        addr1.setProvince("安徽");
        addr1.setCity("宣城");
        Address addr2 = new Address();
        addr2.setProvince("安徽");
        addr2.setCity("屯溪");
        Collections.addAll(list, addr1, addr2);
        return Result.success(list);
    }

}