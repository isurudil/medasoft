package com.medasoft.transaction.impl;

import com.medasoft.config.MongoContextLoader;
import com.medasoft.model.dto.User;
import com.medasoft.transaction.AuthUserBo;
import com.medasoft.util.Configuration;
import com.medasoft.util.Keys;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by isurud on 3/5/14.
 */
public class AuthUserBoImpl implements AuthUserBo {

     MongoContextLoader mongoContextLoader =   new MongoContextLoader();
    private static final Logger LOGGER = Logger.getLogger(AuthUserBoImpl.class);


    @Override
    public String getUserFromUsername(String username) {
        JSONObject jsonObject =  new JSONObject();
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
        if(user == null)  {
            try {
                jsonObject.put(Keys.status.name(), Configuration.ERROR_CODE_DEFAULT);
                jsonObject.put(Keys.description.name(),Configuration.ERROR_DESC_DEFAULT);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
            else     {
            try {
                jsonObject.put(Keys.status.name(),Configuration.SUCCESS_CODE_DEFAULT);
                jsonObject.put(Keys.description.name(),Configuration.SUCCESS_DESC_DEFAULT);
                jsonObject.put("password",user.getPassword());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject.toString();
    }


}
