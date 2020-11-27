package com.study.fastcampus.controller;

import com.study.fastcampus.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    // ajax 검색
    //http post body -> data
    // json, xml, multipart-form / text-plain


    @PostMapping(value = "/postMethod") //, produces = {"application-json"}
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {

        return searchParam;

    }
    @PutMapping("/putMethod") // 이렇게 사용x
    public void put(){

    }

    @PatchMapping("/patchMethod") // 이렇게 사용x
    public void patch(){

    }
}
