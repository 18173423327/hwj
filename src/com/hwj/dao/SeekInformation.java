package com.hwj.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SeekInformation {
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
    public static ResultSet queryJob() throws Exception {
    	Connection conn=init();
    	String sql="select * from SeekInformation";
    	Statement stmt=conn.createStatement();
    	ResultSet rs=stmt.executeQuery(sql);
    	return rs;
    }
    public static void updateJobseeker(String LoginID,String Password,String Loginid)throws Exception {
    	Connection conn=init();
    	String sql="Update JobseekerLogin set LoginID=?,Password=? where LoginID=Loginid";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, Password);
    	pstmt.executeUpdate();
    }
    public static void updateCompany(String LoginID,String Password,String Loginid)throws Exception {
    	Connection conn=init();
    	String sql="Update CompanyLogin set LoginID=?,Password=? where LoginID=Loginid";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, LoginID);
    	pstmt.setString(2, Password);
    	pstmt.executeUpdate();
    }
    public static void updateResume(String name,String sex,String age,String phone,String major,String salary,String LoginID)throws Exception {
    	Connection conn=init();
    	String sql="Update JobInformation set name=?,sex=?,age=?,phone=?,major=?,salary=? where LoginID=Loginid";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, major);
    	pstmt.setString(6, salary);
    	pstmt.executeUpdate();
    	pstmt.executeUpdate();
    }
    public static void updateCompany(String name,String sex,String age,String phone,String email,String LoginID,String Password)throws Exception{
    	Connection conn=init();
    	String sql="Update JobseekerLogin set LoginID=?,Password=? where LoginID=Loginid";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, email);
    	pstmt.executeUpdate();
    }
    public static ResultSet queryseeker(String major,String salary)throws Exception {
    	Connection conn=init();
    	String sql="select * from SeekInformation where major=? and salary>=?";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, major);
    	pstmt.setString(2, salary);
    	ResultSet rs=pstmt.executeQuery();
    	return rs;
    }
    public static ResultSet queryResume(String Loginid)throws Exception {
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select * from JobInformation where LoginID=Loginid";
    	ResultSet rs=null;
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	   return rs;
    }
    public static ResultSet queryCompany(String name,String sex,String age,String phone,String email)throws Exception{
    	Connection conn=init();
    	Statement stmt=conn.createStatement();
    	String sql="select * from CompanyLogin where LoginID=Loginid";
    	ResultSet rs=null;
    	rs=stmt.executeQuery(sql);
    		return rs;
    }
    public static void insertJobseeker(String name,String sex,String age,String phone,String major,String salary,String LoginID)throws Exception {
    	Connection conn=init();
    	String sql="insert into JobInformation(name,sex,age,phone,major,salary,LoginID) values(?,?,?,?,?,?,?)";
    	PreparedStatement pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, name);
    	pstmt.setString(2, sex);
    	pstmt.setString(3, age);
    	pstmt.setString(4, phone);
    	pstmt.setString(5, major);
    	pstmt.setString(6, salary);
    	pstmt.setString(7, LoginID);
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
	public static void main(String[] args) throws Exception {
    	//queryJobseeker();
    }
}
