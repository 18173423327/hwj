package com.hwj.job;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Company extends JFrame {
	public Company(){
		left();
		this.setTitle("��Ƹ��������");
		this.setSize(800, 560);
		this.setLocation(600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void left() {
		// ��������
		JLabel bg = new JLabel(new ImageIcon("d:\\filedemo\\core7.jpg"));
		this.setContentPane(bg);
			
		JLabel IA=new JLabel("������Ϣ����");
		IA.setBounds(220,280,200,50);
		IA.setFont(new Font(null,Font.BOLD,14));
		IA.setForeground(Color.red);
		this.add(IA);
		
		JLabel IB=new JLabel("������Ƹ��Ϣ");
		IB.setBounds(220,360,200,50);
		IB.setFont(new Font(null,Font.BOLD,14));
		IB.setForeground(Color.red);
		this.add(IB);
		
		JLabel IC=new JLabel("��Ƹ��������");
		IC.setBounds(220,440,200,50);
		IC.setFont(new Font(null,Font.BOLD,14));
		IC.setForeground(Color.red);
		this.add(IC);
		
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
		
		IA.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
		       new CompanyInformation();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		IB.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new FillCompany();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});	
		
		IC.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new Companyhunt();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});	

		}
}




