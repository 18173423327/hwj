package com.hwj.job;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hwj.dao.PersonalInformation;
public class ResumeInformation {
    public ResumeInformation() {
    	init();
    }
	public void init() {		
		JFrame frame=new JFrame("简历管理中心");
		JButton butA=new JButton("完善简历");
		JButton butB=new JButton("修改简历");
		JButton butC=new JButton("查看简历");
		JButton return1=new JButton("返回");
		FlowLayout flo=new FlowLayout(FlowLayout.LEFT,50,50);
		
		//设置登录背景
		ImageIcon im=new ImageIcon("d:\\filedemo\\core11.jpg");
		JLabel pa=new JLabel(im);
		
		frame.setSize(900,750);
		frame.setLocation(500,200);
		frame.setLayout(flo);
		
		frame.add(pa);
		frame.add(butA);
		frame.add(butB);
		frame.add(butC);
		frame.add(return1);
		
		butA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ResultSet rs = null;
				try {
					rs=new PersonalInformation().queryResume();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "简历已存在，不必重复填写", "警告",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						new FillResume();
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		butB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ResultSet rs = null;
				try {
					rs=new PersonalInformation().queryResume();
					if(rs.next()) {
						new UpdateResume();
					}else {
						JOptionPane.showMessageDialog(null, "简历还未填写，请先去填写", "警告",
								JOptionPane.INFORMATION_MESSAGE);
						new FillResume();
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		butC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ResultSet rs = null;
				try {
					rs=new PersonalInformation().queryResume();
					if(rs.next()) {
						new CheckResume();
					}else {
						JOptionPane.showMessageDialog(null, "简历还未填写，请先去填写", "警告",
								JOptionPane.INFORMATION_MESSAGE);
						new FillResume();
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			}
		});
		return1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			  new Jobseeker();
			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}