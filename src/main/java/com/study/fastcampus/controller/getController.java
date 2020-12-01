package com.study.fastcampus.controller;

import com.study.fastcampus.model.SearchParam;
import com.study.fastcampus.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class getController {

    //Method를 GET 타입으로 받는다.
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMNethod
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = "bbbb";
        System.out.println("id: " + id + ", password:" + password);
        return id + password;


    }

    //여러개의 Param을 받아올 때
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // {"account":"", "email":"", "page":0} json 형태로
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {

        // {"resultCode": "OK, "description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
