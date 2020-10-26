package logic.repositories;

import java.sql.*;

public class DB 
{
    static final String CONN_STR = "jdbc:mysql://localhost:3306/dbinternetprogramminguts1";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    public Statement getStatement()
    throws SQLException
    {
        Connection conn = DriverManager.getConnection(
            CONN_STR, 
            DB_USER, 
            DB_PASS);
        return conn.createStatement();
    }
}
