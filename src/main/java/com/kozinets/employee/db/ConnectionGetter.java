package com.kozinets.employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGetter implements ConnectionInterface {
    private Connection connection;

    public ConnectionGetter(){

    }

    public Connection getConnection() {
        Connection connection;
        if(!connectionExist(this.connection)){
            newConnection();
        }
        System.out.println("ConnectionGetter.Connection: " + this.connection);
        return this.connection;
    }

    @Override
    public boolean connectionExist(Connection connection) {
        boolean result;
        if(connection == null){
            result = false;
        }else{
            result = true;
        }
        return result;
    }

    @Override
    public void newConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","crmuser","oroot");
            this.connection = connection;
        } catch (SQLException e) {
            System.out.println(); e.getMessage();
        }
    }

    @Override
    public void closeConnection(){
        try {
            this.connection.close();
        }catch(SQLException e){
            e.getMessage();
        }finally {

        }
    }

}
