package com.medasoft.transaction;

import com.medasoft.model.dto.User;

import java.util.List;

/**
 * Created by isurud on 3/5/14.
 */
public interface UserLoginBo {

    public abstract long countAllUsers();
    public abstract void deleteUser(User user);
    public abstract User findUser(String id);
    public abstract List findAllUsers();
    public abstract List findUserEntries(int firstResult
            , int maxResults);
    public abstract User findByUsername(String username);
    public abstract void saveUser(User user);
    public abstract User updateUser(User user);

    public abstract List getUserRoles(String id);

}
