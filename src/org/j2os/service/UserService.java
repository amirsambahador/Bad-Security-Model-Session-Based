package org.j2os.service;

import org.j2os.entity.User;
import org.j2os.repository.UserDA;

public class UserService {
    private static final UserService USER_SERVICE = new UserService();

    public static UserService getInstance() {
        return USER_SERVICE;
    }
    private UserService(){}
    public User login(User user) throws Exception {
        try (UserDA userDA = new UserDA()) {
            return userDA.selectOneByUsernameAndPassword(user);
        }
    }
}
