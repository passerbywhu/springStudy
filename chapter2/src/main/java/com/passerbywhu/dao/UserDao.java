package com.passerbywhu.dao;

import com.passerbywhu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate template) {
        jdbcTemplate = template;
    }

    public User findUserByUserName(String userName) {
        String sql = "select * from t_user where user_name = ?";
        final User user = new User();
        user.userName = userName;
        jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                String password = rs.getString(rs.findColumn("password"));
                user.password = password;
            }
        });
        return user;
    }
}
