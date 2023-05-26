package org.j2os.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String roleName;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password, String roleName) {
        this.roleName = roleName;
        this.username = username;
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public User setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
