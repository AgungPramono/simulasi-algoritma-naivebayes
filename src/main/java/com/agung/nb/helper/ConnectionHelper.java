/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.nb.helper;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author agung
 */
public class ConnectionHelper {

    private static Connection conn = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/nasabah";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "admin";
    private static HikariDataSource ds = new HikariDataSource();

    public static HikariDataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USERNAME);
        config.setPassword(DB_PASSWORD);
        return new HikariDataSource(config);
    }
}
