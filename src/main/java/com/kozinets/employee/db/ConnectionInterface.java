package com.kozinets.employee.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionInterface {
    public boolean connectionExist(Connection connection);
    public void newConnection();
    public void closeConnection() throws SQLException;
}
