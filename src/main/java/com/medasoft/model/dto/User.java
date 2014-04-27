package com.medasoft.model.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by isurud on 3/8/14.
 */
@Document(collection = "doctor_info")
public class User {

    @Id
    private String _id;
    String password;
    String dName;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String get_id() {
        return _id;

    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
