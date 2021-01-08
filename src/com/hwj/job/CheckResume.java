package com.hwj.job;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import com.hwj.dao.PersonalInformation;
public class CheckResume extends JFrame{
	public CheckResume() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("简历管理中心");
		this.setBounds(500, 300, 800, 560);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void initialize() throws SQLException {

		ResultSet rs = null;
		try {
			rs=new PersonalInformation().queryResume();
			rs.next();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);

		JLabel label = new JLabel("查看简历");
		label.setBounds(380, 60, 100, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel name = new JLabel("姓名");
		name.setBounds(322, 110, 30, 25);
		name.setFont(new Font(null, Font.PLAIN, 14));
		name.setForeground(Color.green);
		this.add(name);

		JLabel sex = new JLabel("性别");
		sex.setBounds(322, 160, 30, 25);
		sex.setFont(new Font(null, Font.PLAIN, 14));
		sex.setForeground(Color.green);
		this.add(sex);

		JLabel age = new JLabel("年龄");
		age.setBounds(322, 210, 30, 25);
		age.setFont(new Font(null, Font.PLAIN, 14));
		age.setForeground(Color.green);
		this.add(age);

		JLabel phone = new JLabel("电话");
		phone.setBounds(322, 260, 30, 25);
		phone.setFont(new Font(null, Font.PLAIN, 14));
		phone.setForeground(Color.green);
		this.add(phone);
		
		JLabel major = new JLabel("专业");
		major.setBounds(322, 310, 60, 25);
		major.setFont(new Font(null, Font.PLAIN, 14));
		major.setForeground(Color.green);
		this.add(major);

		JLabel salary = new JLabel("薪资期望");
		salary.setBounds(300, 360, 60, 25);
		salary.setFont(new Font(null, Font.PLAIN, 14));
		salary.setForeground(Color.green);
		this.add(salary);

		JLabel name2 = new JLabel(rs.getString(1));
		name2.setBounds(380, 110, 220, 25);
		this.add(name2);

		JLabel sex2 = new JLabel(rs.getString(2));
		sex2.setBounds(380, 160, 220, 25);
		this.add(sex2);

		JLabel age2 = new JLabel(rs.getString(3));
		age2.setBounds(380, 210, 220, 25);
		this.add(age2);

		JLabel phone2 = new JLabel(rs.getString(4));
		phone2.setBounds(380, 260, 220, 25);
		this.add(phone2);

		JLabel major2 = new JLabel(rs.getString(5));
		major2.setBounds(380, 310, 220, 25);
		this.add(major2);
		
		JLabel salary2=new JLabel(rs.getString(6));
		salary2.setBounds(380,360,220,25);
		this.add(salary2);

		JButton return1 = new JButton("返回");
		return1.setBounds(10, 10, 60, 25);
		this.add(return1);

		// 返回
		return1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ResumeInformation();
			}
		});
	}
}