package com.ddzj.mypomaner.utils;

import java.sql.*;

/**
 * @Author:yangzibo
 * @CreateTime:2024-05-01 00:20
 * @Description:
 * @Version:1.0
 **/
public class JdbcUtils {

    // 获取数据库连接
    public static Connection getConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // 关闭连接
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭PreparedStatement
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭ResultSet
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭连接、PreparedStatement和ResultSet（通常用于try-with-resources或手动关闭）
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        close(rs);
        close(pstmt);
        close(conn);
    }
}
