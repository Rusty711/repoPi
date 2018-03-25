/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rusty
 */
public class BDConn {
             String url="jdbc:mysql://localhost:3306/fosuser";
    String login="root";
    String pwd="";
    Connection cnx;
    public static BDConn instance;
    private BDConn() throws SQLException
    {
          cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("etablie");
        
    
    }
    public Connection getConnection()
    {
        return cnx;
    }
    public static BDConn getInstance() throws SQLException
    {
                if (instance==null)
        {
           instance=new BDConn();
        }
        return instance;        
    }
}
