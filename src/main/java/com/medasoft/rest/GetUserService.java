package com.medasoft.rest;

import com.medasoft.transaction.UserLoginBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by isurud on 3/8/14.
 */
@Component
@Path("/user")
public class GetUserService {

    @Autowired
    UserLoginBo userLoginBo;

    @GET
    @Path("/getuser")
    public Response getUser(){

         String result = userLoginBo.countAllUsers();
        return Response.status(200).entity(result).build();

    }

}
