package com.kozinets.employee.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private ConnectionPool(){
        //private constructor
    }

    private static ConnectionPool connectionPool = null;

    public static ConnectionPool getConnectionPool(){
        if (connectionPool==null)
            connectionPool = new ConnectionPool();
        return connectionPool;
    }

    public Connection getConnection(){
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/pool");
            connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
/*
public class ConnectionPool {
    private ConnectionPool(){

    }

    private static ConnectionPool connectionPool = null;

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null){
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection(){
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            System.out.println("catch 1");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("catch 2");
            e.printStackTrace();
        }
        return connection;
    }
}
*/