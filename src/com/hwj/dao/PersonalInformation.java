package com.hwj.dao;
import java.sql.Statement;

import com.hwj.job.LT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PersonalInformation {
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
    public static void updateJobseeker(String LoginID,String Password)throws Exception {
    	Connection conn=init();
    	String sql="Update JobseekerLogin set LoginID=?,Password=? where LoginID=?";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, Password);
    	pstmt.setString(3, LT.LoginID);
    	pstmt.executeUpdate();
    }
    public static void updateCompany(String LoginID,String Password)throws Exception {
    	Connection conn=init();
    	String sql="Update CompanyLogin set LoginID=?,Password=? where LoginID=?";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, Password);
    	pstmt.setString(3, LT.LoginID);
    	pstmt.executeUpdate();
    }
    public static void updateResume(String name,String sex,String age,String phone,String major,String salary)throws Exception {
    	Connection conn=init();
    	String sql="Update JobInformation set name=?,sex=?,age=?,phone=?,major=?,salary=? where LoginID=?";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, major);
    	pstmt.setString(6, salary);
    	pstmt.setString(7, LT.LoginID);
    	pstmt.executeUpdate();
    	pstmt.executeUpdate();
    }
    public static void updateCompany(String name,String sex,String age,String phone,String email)throws Exception{
    	Connection conn=init();
    	String sql="Update JobseekerLogin set LoginID=?,Password=? where LoginID=?";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, email);
    	pstmt.setString(6, LT.LoginID);
    	pstmt.executeUpdate();
    }
    public static ResultSet queryJobseeker()throws Exception {
    	Connection conn=init();
    	String sql="select * from JobseekerLogin where LoginID='"+LT.LoginID+"'";
    	Statement pstmt=conn.createStatement();
    	ResultSet rs=null;
    	rs=pstmt.executeQuery(sql);
    	//rs.next();
    	   return rs;
    }
    public static ResultSet queryResume()throws Exception {
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select * from JobInformation where LoginID='"+LT.LoginID+"'";
    	ResultSet rs=null;
    	rs=stmt.executeQuery(sql);
    	//rs.next();
    	   return rs;
    }
    public static ResultSet queryCompany()throws Exception{
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select * from CompanyLogin where LoginID='"+LT.LoginID+"'";
    	ResultSet rs=null;
    	rs=stmt.executeQuery(sql);
    	//rs.next();
    		return rs;
    }
    public static void insertJobseeker(String name,String sex,String age,String phone,String major,String salary)throws Exception {
    	Connection conn=init();
    	String sql="insert into JobInformation(name,sex,age,phone,major,salary,LoginID) values(?,?,?,?,?,?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, major);
    	pstmt.setString(6, salary);
    	pstmt.setString(7, LT.LoginID);
    	pstmt.executeUpdate();
    }
    public static void insertResume(String name,String sex,String age,String phone,String major,String salary)throws Exception {
    	Connection conn=init();
    	String sql="insert into ResumeInformation(name,sex,age,phone,major,salary) values(?,?,?,?,?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, major);
    	pstmt.setString(6, salary);
    	pstmt.executeUpdate();
    }
    public static void insertCResume(String name,String major,String salary,String num,String address)throws Exception {
    	Connection conn=init();
    	String sql="insert into SeekInformation(name,major,salary,num,address) values(?,?,?,?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, major);
    	pstmt.setString(3, salary);
    	pstmt.setString(4, num);
    	pstmt.setString(5, address);
    	pstmt.executeUpdate();
    }
//    public static void deleteJobseeker(String LoginID) throws Exception {
//    	Connection conn=init();
//    	String sql="delete JobseekerLogin where LoginID=?";
//    	PreparedStatement pstmt=conn.prepareStatement(sql);
//    	pstmt.setString(1, LoginID);
//    	pstmt.executeUpdate();
//    }
	
}
