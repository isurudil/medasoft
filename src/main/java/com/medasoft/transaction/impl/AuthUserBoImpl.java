package com.medasoft.transaction.impl;

import com.medasoft.config.MongoContextLoader;
import com.medasoft.model.dto.User;
import com.medasoft.transaction.UserLoginBo;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by isurud on 3/5/14.
 */
public class AuthUserBoImpl implements UserLoginBo {

     MongoContextLoader mongoContextLoader =   new MongoContextLoader();
    private static final Logger LOGGER = Logger.getLogger(AuthUserBoImpl.class);


    @Override
    public String getUserFromUsername(String username) {
        User user = new User();
        Query searchUserQuery = new Query(Criteria.where("username").is(username));
        LOGGER.debug("Getting username : " +username);

//        User user = new User();
//        user.set_id("3");
//        user.setPassword("prabha");
//        user.setUsername("dilshan");
        try{


            user = mongoContextLoader.getMongoOperation().findOne(searchUserQuery,User.class);
            LOGGER.debug(user.getPassword());
        }catch (Exception ex){

             LOGGER.error(ex.getMessage());

        }
        if(user == null)
            return "USER_NOT_FOUND";
            else
        return user.getPassword();
    }


}
