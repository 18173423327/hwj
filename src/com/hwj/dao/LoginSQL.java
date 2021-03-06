package com.hwj.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginSQL {
    public static Connection init() throws Exception{
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
       String uri="jdbc:sqlserver://localhost:1433;Database=stu";     
       String use="sa";   
       String password="huangjia2002"; 
       Connection conn=null;
    	        Class.forName(driverName);
    	         conn=DriverManager.getConnection(uri,use,password);
    	            return conn;
    }
    public static ResultSet queryJobseeker()throws Exception {
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select LoginID,Password from JobseekerLogin";
    	ResultSet rs=stmt.executeQuery(sql);
    		return rs;
    }
    public static ResultSet queryCompany()throws Exception{
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select LoginID,Password from CompanyLogin";
    	ResultSet rs=stmt.executeQuery(sql);
    		return rs;
    }
    public static void insertJobseeker(String LoginID,String password)throws Exception {
    	Connection conn=init();
    	String sql="insert into JobseekerLogin(LoginID,Password) values(?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, password);
    	pstmt.executeUpdate();
    }
    public static void insertCompany(String LoginID,String password)throws Exception{
    	Connection conn=init();
    	String sql="insert into CompanyLogin(LoginID,Password) values(?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, password);
    	pstmt.executeUpdate();
    }
}
