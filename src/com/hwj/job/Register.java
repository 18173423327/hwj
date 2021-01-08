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
import com.hwj.dao.RegisterSQL;
public class Register extends JFrame{

	public Register() {
		initialize();
		this.setTitle("ע�����");
		this.setBounds(500, 300, 800, 560);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 void initialize() {
		
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);
		
		JLabel label = new JLabel("��ӭע��");
		label.setBounds(380, 180, 120, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel User = new JLabel("�˺�");
		User.setBounds(322, 222, 30, 25);
		User.setFont(new Font(null, Font.PLAIN, 14));
		this.add(User);

		JLabel Password = new JLabel("����");
		Password.setBounds(322, 254, 30, 25);
		Password.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Password);
       
		JLabel Password2 = new JLabel("ȷ������");
		Password2.setBounds(300, 286, 100, 25);
		Password2.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Password2);
		
		JLabel Type = new JLabel("�û�");
		Type.setBounds(322, 316, 30, 25);
		Type.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Type);
		
		JTextField User2 = new JTextField();
		User2.setBounds(380, 222, 120, 25);
		this.add(User2);

		JPasswordField Password3 = new JPasswordField();
		Password3.setBounds(380, 254, 120, 25);
		this.add(Password3);
		
		JPasswordField Password4 = new JPasswordField();
		Password4.setBounds(380, 284, 120, 25);
		this.add(Password4);

		String[] listData = new String[] { "��ְ��", "��ҵ������" };
		JComboBox<String> type1 = new JComboBox<String>(listData);
		type1.setBounds(380, 314, 120, 25);
		this.add(type1);
		
		// �ı���Ͱ�ť
        JPanel panel = new JPanel(null);
		panel.setBounds(290, 170, 245, 250);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(panel);
		
		JButton btn = new JButton("ע��");
		btn.setBounds(320, 366, 180, 25);
		this.add(btn);
		
		JButton return1=new JButton("����");
		return1.setBounds(10, 10, 60, 25);
		this.add(return1);
		//����
		return1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Login();
			}
		});
		//ע��
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String LoginID = User2.getText();
				String password = Password3.getText();
				String password2 = Password4.getText();
				String type = listData[type1.getSelectedIndex()];
				if (LoginID.equals("") || password.equals("")||password2.equals("")) {
					JOptionPane.showMessageDialog(null, "��д��Ϣ������", "����", JOptionPane.INFORMATION_MESSAGE);
				} else {
				try {
					if (type.equals("��ְ��")) {
						ResultSet rs = null;
						rs = new LoginSQL().queryJobseeker();
						boolean flag = true;
						while (rs.next()) {
							if (LoginID.equals(rs.getString("LoginID"))) {
								flag = false;
								break;
							}
						}
						if (flag == false) {
							User2.setText(null);
							JOptionPane.showMessageDialog(null, "�˺��Ѵ��ڣ������������˺�", "����", JOptionPane.INFORMATION_MESSAGE);
						} else {
							if (password.equals(password2)) {
								new RegisterSQL().insertJobseeker(LoginID, password);
								dispose();
								JOptionPane.showMessageDialog(null, "ע��ɹ�");
								new Login();
							} else {
								Password3.setText(null);
								Password4.setText(null);
								JOptionPane.showMessageDialog(null, "���������������������", "����",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					} else if (type.equals("��ҵ������")) {
						ResultSet rs = null;
						rs = new LoginSQL().queryCompany();
						boolean flag = true;
						while (rs.next()) {
							if (LoginID.equals(rs.getString("LoginID"))) {
								flag = false;
								break;
							}
						}
						if (flag == false) {
							User2.setText(null);
							JOptionPane.showMessageDialog(null, "�˺��Ѵ��ڣ������������˺�", "����", JOptionPane.INFORMATION_MESSAGE);
						} else {
							if (password.equals(password2)) {
								new RegisterSQL().insertCompany(LoginID, password);
								dispose();
								JOptionPane.showMessageDialog(null, "ע��ɹ�");
								new Login();
							} else {
								Password3.setText(null);
								Password4.setText(null);
								JOptionPane.showMessageDialog(null, "���������������������", "����",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
			}
		});
	 }
}

