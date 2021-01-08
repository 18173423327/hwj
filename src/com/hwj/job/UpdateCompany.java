package com.hwj.job;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.hwj.dao.LoginSQL;
import com.hwj.dao.PersonalInformation;
public class UpdateCompany extends JFrame{
	
	public UpdateCompany()  {
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
    
	void initialize() throws SQLException  {

		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);
        
		ResultSet rs = null;
		try {
			rs=new PersonalInformation().queryCompany();
			rs.next();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel label = new JLabel("修改信息");
		label.setBounds(380, 60, 100, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel name = new JLabel("账号");
		name.setBounds(322, 120, 30, 25);
		name.setFont(new Font(null, Font.PLAIN, 14));
		name.setForeground(Color.green);
		this.add(name);

		JLabel sex = new JLabel("密码");
		sex.setBounds(322, 170, 30, 25);
		sex.setFont(new Font(null, Font.PLAIN, 14));
		sex.setForeground(Color.green);
		this.add(sex);

		JTextField name2 = new JTextField(rs.getString(1));
		name2.setBounds(380, 120, 120, 25);
		this.add(name2);

		JTextField sex2 = new JTextField(rs.getString(2));
		sex2.setBounds(380, 170, 120, 25);
		this.add(sex2);

		JButton IA = new JButton("保存");
		IA.setBounds(322, 420, 60, 25);
		this.add(IA);

		JButton IB = new JButton("重置");//看看恢复可以不
		IB.setBounds(450, 420, 60, 25);
		this.add(IB);

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
		// 保存
		IA.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ps1 = name2.getText();
				String ps2 = sex2.getText();
				if(ps1.equals("")||ps2.equals("")) {
					JOptionPane.showMessageDialog(null,"请把信息填写完整");
				}
				else {
					try {
					new PersonalInformation().updateCompany(ps1,ps2);
	                 LT.LoginID=ps1;
	                 LT.Password=ps2;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"保存成功");
			}
		}		
	});
		// 重置
		IB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name2.setText(null);
				sex2.setText(null);
			}
		});
	}
}