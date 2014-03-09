package com.medasoft.transaction.impl;

import com.medasoft.config.MongoContextLoader;
import com.medasoft.model.dto.User;
import com.medasoft.transaction.UserLoginBo;

/**
 * Created by isurud on 3/5/14.
 */
public class UserLoginBoImpl implements UserLoginBo {

     MongoContextLoader mongoContextLoader =   new MongoContextLoader();

    @Override
    public String countAllUsers() {
        User user = new User();
        user.set_id("3");
        user.setPassword("prabha");
        user.setUsername("dilshan");
        mongoContextLoader.getMongoOperation().save(user);
        return "Hi Please Work Always";
    }


}
