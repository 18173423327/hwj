package com.hwj.job;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CompanyInformation {
    public CompanyInformation() {
    	init();
    }
       
	public void init() {		
		JFrame frame=new JFrame("������Ϣ");
		JButton butA=new JButton("�޸���Ϣ");
		JButton butB=new JButton("�鿴��Ϣ");
		JButton return1=new JButton("����");
		FlowLayout flo=new FlowLayout(FlowLayout.LEFT,50,50);
		
		//���õ�¼����
		ImageIcon im=new ImageIcon("d:\\filedemo\\core11.jpg");
		JLabel pa=new JLabel(im);
		
		frame.setSize(900,750);
		frame.setLocation(500,200);
		frame.setLayout(flo);
		
		frame.add(pa);
		frame.add(butA);
		frame.add(butB);
		frame.add(return1);

		butA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 frame.dispose();
				  new UpdateCompany();
			}
		});
		butB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new CheckCompany();
			}
		});
		return1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			    new Company();
			}
		});
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}