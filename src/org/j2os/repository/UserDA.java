package org.j2os.repository;

import org.j2os.common.JDBC;
import org.j2os.entity.User;
import org.j2os.exception.InvalidUsernameOrPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDA() throws Exception {
        this.connection = JDBC.getConnection();
    }

    public User selectOneByUsernameAndPassword(User user) throws Exception {
        preparedStatement = connection.prepareStatement("select * from users where upper(username)=upper(?) and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return user.setRoleName(resultSet.getString("role_name"));
        throw new InvalidUsernameOrPassword();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
