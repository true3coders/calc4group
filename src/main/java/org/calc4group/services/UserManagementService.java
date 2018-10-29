package org.calc4group.services;

import org.calc4group.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
    //some dummy for now service, just to make project architecture

    public User getUserById(String usedId) {
        // TODO: 29.10.2018 Get User from DB
        User user = new User();
        return user;
    }

    public List<User> parseListOfUsers(String[] usedIds) {
        // TODO: 29.10.2018 WORK with DB
        List<User> result = new ArrayList<>();
        for (String usedId : usedIds) {
            result.add(getUserById(usedId));
        }
        return result;
    }
}
