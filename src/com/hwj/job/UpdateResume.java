package com.hwj.job;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.hwj.dao.LoginSQL;
import com.hwj.dao.PersonalInformation;
public class UpdateResume extends JFrame{
	public UpdateResume()  {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("������������");
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
			rs=new PersonalInformation().queryResume();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel label = new JLabel("�޸ļ���");
		label.setBounds(380, 60, 100, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel name = new JLabel("����");
		name.setBounds(322, 110, 30, 25);
		name.setFont(new Font(null, Font.PLAIN, 14));
		name.setForeground(Color.green);
		this.add(name);

		JLabel sex = new JLabel("�Ա�");
		sex.setBounds(322, 160, 30, 25);
		sex.setFont(new Font(null, Font.PLAIN, 14));
		sex.setForeground(Color.green);
		this.add(sex);

		JLabel age = new JLabel("����");
		age.setBounds(322, 210, 30, 25);
		age.setFont(new Font(null, Font.PLAIN, 14));
		age.setForeground(Color.green);
		this.add(age);

		JLabel phone = new JLabel("�绰");
		phone.setBounds(322, 260, 30, 25);
		phone.setFont(new Font(null, Font.PLAIN, 14));
		phone.setForeground(Color.green);
		this.add(phone);
		
		JLabel major = new JLabel("רҵ");
		major.setBounds(322, 310, 60, 25);
		major.setFont(new Font(null, Font.PLAIN, 14));
		major.setForeground(Color.green);
		this.add(major);

		JLabel salary = new JLabel("н������");
		salary.setBounds(300, 360, 60, 25);
		salary.setFont(new Font(null, Font.PLAIN, 14));
		salary.setForeground(Color.green);
		this.add(salary);
		
//		JLabel email = new JLabel("����");
//		email.setBounds(322, 320, 30, 25);
//		email.setFont(new Font(null, Font.PLAIN, 14));
//		email.setForeground(Color.green);
//		this.add(email);

//		JLabel password = new JLabel("�˺�����");//����һ���޸ģ������ٸ�
//		password.setBounds(300, 370, 60, 25);
//		password.setFont(new Font(null, Font.PLAIN, 14));
//		password.setForeground(Color.green);
//		this.add(password);
//
//		JLabel comment = new JLabel("רҵ");
//		comment.setBounds(322, 360, 60, 25);
//		comment.setFont(new Font(null, Font.PLAIN, 14));
//		comment.setForeground(Color.green);
//		this.add(comment);

		JTextField name2 = new JTextField(rs.getString(1));
		name2.setBounds(380, 110, 120, 25);
		this.add(name2);

		JTextField sex2 = new JTextField(rs.getString(2));
		sex2.setBounds(380, 160, 120, 25);
		this.add(sex2);

		JTextField age2 = new JTextField(rs.getString(3));
		age2.setBounds(380, 210, 120, 25);
		this.add(age2);

		JTextField phone2 = new JTextField(rs.getString(4));
		phone2.setBounds(380, 260, 120, 25);
		this.add(phone2);
		
		JTextField major2 = new JTextField(rs.getString(5));
		major2.setBounds(380, 310, 120, 25);
		this.add(major2);

		JTextField salary2 = new JTextField(rs.getString(6));
		salary2.setBounds(380, 360, 120, 25);
		this.add(salary2);


//		JTextField age2 = new JTextField(rs.getString(3));
//		age2.setBounds(380, 220, 120, 25);
//		this.add(age2);
//
//		JTextField phone2 = new JTextField(rs.getString(4));
//		phone2.setBounds(380, 270, 120, 25);
//		this.add(phone2);
//
//		JTextField email2 = new JTextField(rs.getString(5));
//		email2.setBounds(380, 320, 120, 25);
//		this.add(email2);
//		
//		JTextField password2=new JTextField(rs.getString(6));
//		password2.setBounds(380,370,120,25);
//		this.add(password2);
		
		JButton IA = new JButton("����");
		IA.setBounds(322, 420, 60, 25);
		this.add(IA);

		JButton IB = new JButton("����");//�����ָ����Բ�
		IB.setBounds(450, 420, 60, 25);
		this.add(IB);

//		JTextField salary2 = new JTextField();
//		salary2.setBounds(380, 320, 120, 25);
//		this.add(salary2);
//
//		JTextField comment2 = new JTextField();
//		comment2.setBounds(380, 360, 120, 25);
//		this.add(comment2);

		JButton return1 = new JButton("����");
		return1.setBounds(10, 10, 60, 25);
		this.add(return1);

		// ����
		return1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ResumeInformation();
			}
		});
		// ����
		//System.out.println(ps1+"----");
		IA.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ps1 = name2.getText();
				String ps2 = sex2.getText();
				String ps3=age2.getText();
				String ps4=phone2.getText();
//				String ps5=email2.getText();
//				String ps6=school2.getText();
				String ps5=major2.getText();
				String ps6=salary2.getText();
				//String ps9=comment2.getText();
				if(ps1.equals("")||ps2.equals("")||ps3.equals("")||ps4.equals("")||ps5.equals("")||ps6.equals("")) {
					JOptionPane.showMessageDialog(null,"�����Ϣ��д����");
				}
				else {
					try {
					new PersonalInformation().updateResume(ps1,ps2,ps3,ps4,ps5,ps6);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"����ɹ�");
			}
		}		
	});
		// ����
		IB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String ps1 = name2.getText();
				String ps2 = sex2.getText();
				String ps3=age2.getText();
				String ps4=phone2.getText();
//				String ps5=email2.getText();
//				String ps6=school2.getText();
				String ps5=major2.getText();
				String ps6=salary2.getText();
				//String ps9=comment2.getText();
				if(ps1.equals("")||ps2.equals("")||ps3.equals("")||ps4.equals("")||ps5.equals("")||ps6.equals("")) {
					JOptionPane.showMessageDialog(null,"�����Ϣ��д����");
				}
				else {
					try {
					new PersonalInformation().insertResume(ps1,ps2,ps3,ps4,ps5,ps6);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"�����ɹ�");
			}
			}
		});
	}
}