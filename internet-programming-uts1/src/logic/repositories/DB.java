package logic.repositories;

import java.sql.*;

public class DB 
{
    static final String CONN_STR = "jdbc:mysql://localhost:3306/dbinternetprogramminguts1";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    static Connection _conn;

    void init()
    throws SQLException
    {
        if (_conn == null)
        {
            _conn = DriverManager.getConnection(
                CONN_STR, 
                DB_USER, 
                DB_PASS);
        }
    }

    public Statement getStatement()
    throws SQLException
    {
        init();        
        return _conn.createStatement();
    }

    public PreparedStatement prepareStatement(String q)
    throws SQLException
    {
        init();
        return _conn.prepareStatement(q);
    }

    public PreparedStatement prepareStatementReturn(String q)
    throws SQLException
    {
        init();
        return _conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
    }
}
