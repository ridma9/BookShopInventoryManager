package com.dbmanager;

import com.inventoryManager.Item;

import java.sql.*;
import java.util.Map;

public class DbHandler {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","ridma");

    public DbHandler() throws SQLException {
    }

    public ResultSet GetStatementExecute() throws SQLException {
        Statement statement = connection.createStatement();
        String text="select * from books";
        ResultSet resultSet = statement.executeQuery(text);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4));
        }
        return resultSet;
    }

    public void AddStatementExecute(Item book) throws SQLException {
        String query = "insert into books values"+"(?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, book.getItemName());
        statement.setInt(2,book.getItemId());
        statement.setInt(3,book.getItemqty());
        statement.setInt(4,book.getItemPrice());

        statement.execute();

        //connection.close();

    }

    public void updateStatementExecute(Map<String,Integer> map) throws SQLException {
        String name1=map.keySet().toArray()[0].toString();
        String query = "select * from books where Name=?";
        PreparedStatement statement1 = connection.prepareStatement(query);
        statement1.setString(1,name1);
        ResultSet resultSet=statement1.executeQuery();
        int qty = 0;

        while (resultSet.next()){
            qty=resultSet.getInt("Quantity");
            System.out.println(qty);
        }
        System.out.println(qty);

        qty=qty+Integer.parseInt(map.values().toArray()[0].toString());
        System.out.println(qty);
        query = "update books set Quantity=? where Name=?";
        PreparedStatement statement2 = connection.prepareStatement(query);
        statement2.setInt(1,qty);
        statement2.setString(2,name1);
        statement2.execute();
    }

    public void deleteStatementExceute(String name) throws SQLException {
        String query = "DELETE FROM books WHERE Name=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.execute();
    }

    public void searchStatementExecute(String name) throws SQLException {
        String query = "select * from books where Name=?";
        PreparedStatement statement1 = connection.prepareStatement(query);
        statement1.setString(1,name);
        ResultSet resultSet=statement1.executeQuery();
        if (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4));
        }else {
            System.out.println("Book not found");
        }

    }
}
