package com.medasoft.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by isurud on 3/5/14.
 */
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private List roles;





}
