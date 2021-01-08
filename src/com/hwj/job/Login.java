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
		this.setTitle("��Ƹ��ְ����ϵͳ");
		this.setSize(800, 560);
		this.setLocation(600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void Content() {
		
		// ��������
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);

		// ��½�������
		JLabel logo = new JLabel("2021��ְ��Ƹ");
		logo.setBounds(370, 20, 150, 250);
		logo.setFont(new Font(null, Font.BOLD, 16));
		logo.setForeground(Color.orange);
		this.add(logo);

		JLabel label = new JLabel("��ӭ��½");
		label.setBounds(380, 80, 120, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel User = new JLabel("�˺�");
		User.setBounds(320, 222, 30, 25);
		User.setFont(new Font(null, Font.PLAIN, 14));
		this.add(User);

		JLabel Password = new JLabel("����");
		Password.setBounds(320, 254, 30, 25);
		Password.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Password);

		JLabel Type = new JLabel("�û�");
		Type.setBounds(320, 286, 30, 25);
		Type.setFont(new Font(null, Font.PLAIN, 14));
		this.add(Type);

		// �ı���Ͱ�ť
		JButton btn = new JButton("��½");
		btn.setBounds(320, 320, 70, 25);
		this.add(btn);

		JButton btn1 = new JButton("����");
		btn1.setBounds(430, 320, 70, 25);
		this.add(btn1);
		
		JButton btn2=new JButton("ȥע��");
		btn2.setBounds(20, 20, 80, 25);
		this.add(btn2);

		JTextField User2 = new JTextField();
		User2.setBounds(380, 222, 120, 25);
		this.add(User2);

		JPasswordField Password2 = new JPasswordField();
		Password2.setBounds(380, 254, 120, 25);
		this.add(Password2);

		String[] listData = new String[] { "��ְ��", "��ҵ������" };
		JComboBox<String> type1 = new JComboBox<String>(listData);
		type1.setBounds(380, 284, 120, 25);
		this.add(type1);

		JPanel panel = new JPanel(null);
		panel.setBounds(290, 170, 245, 200);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(panel);

		// ��½�¼�
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String LoginID = User2.getText();
				String password = Password2.getText();
				String type = listData[type1.getSelectedIndex()];
				if (LoginID.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "��д��Ϣ������", "����", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						if (type.equals("��ְ��")) {
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
								JOptionPane.showMessageDialog(null, "���������������������", "����",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == false && flag2 == false) {
								User2.setText(null);
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "���˺Ų����ڣ������ע��", "����",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == true && flag2 == true) {
								dispose();
								LT.LoginID=LoginID;
								LT.Password=password;
								 new Jobseeker();
							}
						} else if (type.equals("��ҵ������")) {
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
								JOptionPane.showMessageDialog(null, "���������������������", "����",
										JOptionPane.INFORMATION_MESSAGE);
							} else if (flag1 == false && flag2 == false) {
								User2.setText(null);
								Password2.setText(null);
								JOptionPane.showMessageDialog(null, "���˺Ų����ڣ������ע��", "����",
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
		// ����
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User2.setText(null);
				Password2.setText(null);
			}
		});
		//ȥע��
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
//û����д��û�ж�