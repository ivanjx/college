package logic.repositories;

import java.sql.*;

public class DB 
{
    static final String CONN_STR = "jdbc:mysql://localhost:3306/dbinternetprogramminguts1";
    static final String DB_USER = "internetprogramminguts1";
    static final String DB_PASS = "internetprogramminguts1";

    static Connection _conn;

    void init()
    throws SQLException, ClassNotFoundException
    {
        if (_conn == null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            _conn = DriverManager.getConnection(
                CONN_STR, 
                DB_USER, 
                DB_PASS);
        }
    }

    public Statement getStatement()
    throws SQLException, ClassNotFoundException
    {
        init();        
        return _conn.createStatement();
    }

    public PreparedStatement prepareStatement(String q)
    throws SQLException, ClassNotFoundException
    {
        init();
        return _conn.prepareStatement(q);
    }

    public PreparedStatement prepareStatementReturn(String q)
    throws SQLException, ClassNotFoundException
    {
        init();
        return _conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
    }
}
