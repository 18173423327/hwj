package com.hwj.job;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.hwj.dao.LoginSQL;
public class Login extends JFrame {
	
	public static void main(String args[]) {
		new Login();
	}
	
	public Login() {
		Content();
		this.setTitle("招聘求职管理系统");
		this.setSize(800, 560);
		this.setLocation(600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void Content() {
		
		// 背景设置
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);

		// 登陆板块内容
		JLabel logo = new JLabel("2021求职招聘");
		logo.setBounds(370, 20, 150, 250);
		logo.setFont(new Font(null, Font.BOLD, 16));
		logo.setForeground(Color.orange);
		this.add(logo);

		JLabel label = new JLabel("欢迎登陆");
		label.setBounds(380, 80, 120, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel User = new JLabel("账号");
		User.setBounds(320, 222, 30, 25);
		User.setFont(new Font(null, Font.PLAIN, 14));
		this.add(User);

		JLabel Password = new JLabel("密码");
		Password.setBounds(320, 254, 30, 25);
		Password.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Password);

		JLabel Type = new JLabel("用户");
		Type.setBounds(320, 286, 30, 25);
		Type.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Type);

		// 文本框和按钮
		JButton btn = new JButton("登陆");
		btn.setBounds(320, 320, 70, 25);
		this.add(btn);

		JButton btn1 = new JButton("重置");
		btn1.setBounds(430, 320, 70, 25);
		this.add(btn1);
		
		JButton btn2=new JButton("去注册");
		btn2.setBounds(20, 20, 80, 25);
		this.add(btn2);

		JTextField User2 = new JTextField();
		User2.setBounds(380, 222, 120, 25);
		this.add(User2);

		JPasswordField Password2 = new JPasswordField();
		Password2.setBounds(380, 254, 120, 25);
		this.add(Password2);

		String[] listData = new String[] { "求职者", "企业管理者" };
		JComboBox<String> type1 = new JComboBox<String>(listData);
		type1.setBounds(380, 284, 120, 25);
		this.add(type1);

		JPanel panel = new JPanel(null);
		panel.setBounds(290, 170, 245, 200);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(panel);

		// 登陆事件
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String LoginID = User2.getText();
				String password = Password2.getText();
				String type = listData[type1.getSelectedIndex()];
				if (LoginID.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "填写信息不完整", "警告", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						if (type.equals("求职者")) {
							ResultSet rs = null;
							rs = new LoginSQL().queryJobseeker();
							boolean flag1 = false, flag2 = false;
							while (rs.next()) {
								if (LoginID.equals(rs.getString("LoginID"))) {
									flag1 = true;
									if (password.equals(rs.getString("Password"))) {
										flag2 = true;
									} else {
										break;
									}
								}
							}
							if (flag1 == true && flag2 == false) {
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "密码输入错误，请重新输入", "警告",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == false && flag2 == false) {
								User2.setText(null);
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "此账号不存在，请进行注册", "警告",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == true && flag2 == true) {
								dispose();
								LT.LoginID=LoginID;
								LT.Password=password;
								 new Jobseeker();
							}
						} else if (type.equals("企业管理者")) {
							ResultSet rs = null;
							rs = new LoginSQL().queryCompany();
							boolean flag1 = false, flag2 = false;
							while (rs.next()) {
								if (LoginID.equals(rs.getString("LoginID"))) {
									flag1 = true;
									if (password.equals(rs.getString("Password"))) {
										flag2 = true;
									} else {
										break;
									}
								}
							}
							if (flag1 == true && flag2 == false) {
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "密码输入错误，请重新输入", "警告",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == false && flag2 == false) {
								User2.setText(null);
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "此账号不存在，请进行注册", "警告",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == true && flag2 == true) {
								dispose();
								LT.LoginID=LoginID;
								LT.Password=password;
								new Company();
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// 重置
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User2.setText(null);
				Password2.setText(null);
			}
		});
		//去注册
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Register();
			}
		});
	}
}
//没有填写还没判断