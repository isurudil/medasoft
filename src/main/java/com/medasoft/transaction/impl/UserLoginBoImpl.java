package com.medasoft.transaction.impl;

import com.medasoft.config.SpringMongoConfig;
import com.medasoft.model.dto.User;
import com.medasoft.transaction.UserLoginBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by isurud on 3/5/14.
 */
public class UserLoginBoImpl implements UserLoginBo {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoTemplate");


    @Override
    public String countAllUsers() {
        User user = new User();
        user.set_id("2");
        user.setPassword("dilshan");
        user.setUsername("dilshan");
        mongoOperations.save(user);
        return "Hi Isuru Please Work";
    }


}
