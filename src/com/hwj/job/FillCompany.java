package com.hwj.job;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.hwj.dao.PersonalInformation;
public class FillCompany extends JFrame{
	
	public FillCompany() {
		initialize();
		this.setTitle("发布招聘信息");
		this.setBounds(500, 300, 800, 560);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void initialize() {
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core2.jpg"));
		this.setContentPane(bg);

		JLabel label = new JLabel("招聘信息");
		label.setBounds(380, 60, 100, 25);
		label.setFont(new Font(null, Font.BOLD, 18));
		label.setForeground(Color.red);
		this.add(label);

		JLabel name = new JLabel("公司名");
		name.setBounds(310, 110, 60, 25);
		name.setFont(new Font(null, Font.PLAIN, 14));
		name.setForeground(Color.green);
		this.add(name);

		JLabel sex = new JLabel("专业");
		sex.setBounds(322, 160, 30, 25);
		sex.setFont(new Font(null, Font.PLAIN, 14));
		sex.setForeground(Color.green);
		this.add(sex);

		JLabel age = new JLabel("薪水");
		age.setBounds(322, 210, 30, 25);
		age.setFont(new Font(null, Font.PLAIN, 14));
		age.setForeground(Color.green);
		this.add(age);

		JLabel phone = new JLabel("数量");
		phone.setBounds(322, 260, 30, 25);
		phone.setFont(new Font(null, Font.PLAIN, 14));
		phone.setForeground(Color.green);
		this.add(phone);
		
		JLabel major = new JLabel("地址");
		major.setBounds(322, 310, 60, 25);
		major.setFont(new Font(null, Font.PLAIN, 14));
		major.setForeground(Color.green);
		this.add(major);
		
		JTextField name2 = new JTextField();
		name2.setBounds(380, 110, 120, 25);
		this.add(name2);

		JTextField sex2 = new JTextField();
		sex2.setBounds(380, 160, 120, 25);
		this.add(sex2);

		JTextField age2 = new JTextField();
		age2.setBounds(380, 210, 120, 25);
		this.add(age2);

		JTextField phone2 = new JTextField();
		phone2.setBounds(380, 260, 120, 25);
		this.add(phone2);

		JTextField major2 = new JTextField();
		major2.setBounds(380, 310, 120, 25);
		this.add(major2);

		JButton IA = new JButton("发布");
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
				new Company();
			}
		});
		// 保存
		IA.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ps1 = name2.getText();
				String ps2 = sex2.getText();
				String ps3=age2.getText();
				String ps4=phone2.getText();
				String ps5=major2.getText();
				if(ps1.equals("")||ps2.equals("")||ps3.equals("")||ps4.equals("")||ps5.equals("")) {
					JOptionPane.showMessageDialog(null,"请把信息填写完整");
				}
				else {
					try {
					new PersonalInformation().insertCResume(ps1,ps2,ps3,ps4,ps5);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"发布成功");
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
				age2.setText(null);
				phone2.setText(null);
				major2.setText(null);
			}
		});
	}
}