package com.hwj.job;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.hwj.dao.PersonalInformation;
public class CheckCompany extends JFrame{
	public CheckCompany() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("个人信息中心");
		this.setBounds(500, 300, 800, 560);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void initialize() throws SQLException {

		ResultSet rs = null;
		try {
			rs=new PersonalInformation().queryCompany();
			rs.next();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);

		JLabel label = new JLabel("查看信息");
		label.setBounds(380, 60, 100, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel id = new JLabel("账号");
		id.setBounds(322, 120, 30, 25);
		id.setFont(new Font(null, Font.PLAIN, 14));
		id.setForeground(Color.green);
		this.add(id);

		JLabel password = new JLabel("密码");
		password.setBounds(322, 170, 30, 25);
		password.setFont(new Font(null, Font.PLAIN, 14));
		password.setForeground(Color.green);
		this.add(password);

		JLabel id2 = new JLabel(rs.getString(1));
		id2.setBounds(380, 120, 220, 25);
		this.add(id2);

		JLabel password2 = new JLabel(rs.getString(2));
		password2.setBounds(380, 170, 220, 25);
		this.add(password2);

		JButton return1 = new JButton("返回");
		return1.setBounds(10, 10, 60, 25);
		this.add(return1);

		// 返回
		return1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new CompanyInformation();
			}
		});
	}
}