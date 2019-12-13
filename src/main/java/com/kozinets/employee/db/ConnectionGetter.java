package com.kozinets.employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGetter {
    private Connection connection;

    public Connection getConnection() {

        if(!connectionExist(this.connection)){
            newConnection();
        }
        return this.connection;
    }

    public boolean connectionExist(Connection connection) {
        boolean result;
        if(connection == null){
            result = false;
        }else{
            result = true;
        }
        return result;
    }

    public void newConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","crmuser","oroot");
        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }

}
