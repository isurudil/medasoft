package com.medasoft.rest;

import com.medasoft.transaction.AuthUserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by isurud on 3/8/14.
 */
@Component
@Path("/user")
public class AuthUserService {

    @Autowired
    AuthUserBo authUserBo;

    @POST
    @Path("/get/{username}")
    public Response getUser(@PathParam("username") String name){
         String result = authUserBo.getUserFromUsername(name);
        return Response.status(200).entity(result).build();

    }


}
