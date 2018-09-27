package com.tcm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcm.framework.core.dao.query.page.v2.BaseServiceImpl;

@Service
public class UserV2ServicesImpl extends BaseServiceImpl<UserV2> implements IUserV2Services {


    @Transactional
    @Override
    public void testuserUp(String trueName) {
        UserV2 objById = getObjById(32904L);
        objById.setTrueName(trueName);
        update(objById);

        // if(true){
        // throw new NullPointerException();
        // }
    }

}
