package com.study.fastcampus.ifs;

import com.study.fastcampus.model.network.Header;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Header<Req> request);    // todo request object 추가가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
