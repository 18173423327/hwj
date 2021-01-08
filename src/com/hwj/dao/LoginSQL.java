package com.hwj.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
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
	public static void main(String[] args) throws Exception {
    	//queryJobseeker();
    }
}
