package com.study.fastcampus.model;
// {"account":"", "email":"", "page":""} json 형태로

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;


}
