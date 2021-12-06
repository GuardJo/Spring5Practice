package com.spring5.chapter08.dbquery;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {
    private DataSource dataSource;

    public DbQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count() {
        Connection conn = null;
        try {
            // 커넥션 풀에서 커넥션을 구함
            conn = dataSource.getConnection();
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("select count(*) from MEMBER")) {
                resultSet.next();
                return resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            if (conn != null) {
                try {
                    // 커넥션 풀에 커넥션 반환
                    conn.close();
                } catch (SQLException throwables) {
                }
            }
        }
    }
}
