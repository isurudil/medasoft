package com.medasoft.transaction.impl;

import com.medasoft.model.dto.User;
import com.medasoft.transaction.UserLoginBo;

import java.util.List;

/**
 * Created by isurud on 3/5/14.
 */
public class UserLoginBoImpl implements UserLoginBo {



    @Override
    public long countAllUsers() {
        return 0;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User findUser(String id) {
        return null;
    }

    @Override
    public List findAllUsers() {
        return null;
    }

    @Override
    public List findUserEntries(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List getUserRoles(String id) {
        return null;
    }
}
