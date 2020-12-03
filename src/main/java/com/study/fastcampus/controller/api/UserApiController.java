package com.study.fastcampus.controller.api;

import com.study.fastcampus.ifs.CrudInterface;
import com.study.fastcampus.model.network.Header;
import com.study.fastcampus.model.network.request.UserApiRequest;
import com.study.fastcampus.model.network.response.UserApiResponse;
import com.study.fastcampus.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {


    @Autowired
    private UserApiLogicService userApiLogicService;


    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        //Log.info("{}",request);
        return userApiLogicService.create(request);

    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")  // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }


}
