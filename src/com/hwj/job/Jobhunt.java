package com.hwj.job;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.hwj.pojo.*;
import com.hwj.dao.PersonalInformation;
import com.hwj.dao.SeekInformation;
public class Jobhunt{
	public Jobhunt() {
		try {
			init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 void init() throws SQLException{
		JFrame frame=new JFrame("��Ƹ��������"); 
		JLabel major=new JLabel("רҵ");
		JLabel salary=new JLabel("нˮ");
		JButton IA=new JButton("��ѯ");
		JButton return1=new JButton("����");
		JButton IB=new JButton("�ղ�");
		JTextField major2=new JTextField(10);
		JTextField salary2=new JTextField(10);
		
		Vector column=new Vector();
		Vector row=new Vector();
		
		
		column.add("��˾��");
		column.add("רҵ");
		column.add("нˮ");		
		column.add("����");
		column.add("��ַ");
			         
			ResultSet rs=null;
			try {
				rs = new SeekInformation().queryJob();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			while(rs.next()) {
				Vector rowdata=new Vector();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				rowdata.add(rs.getString(3));
				rowdata.add(rs.getString(4));
				rowdata.add(rs.getString(5));
				row.add(rowdata);
			}
			rs.close();
				
		JTable table=new JTable(row,column);
		JScrollPane scrollPane = new JScrollPane(table);

		frame.setSize(600,600);
		frame.setLocation(500,300);
		frame.setLayout(new BorderLayout());
		
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		jp.add(major);
		jp.add(major2);
		jp.add(salary);
		jp.add(salary2);
		jp.add(IA);
		jp.add(IB);
		
		frame.add(jp,BorderLayout.NORTH);
		frame.add(jp2,BorderLayout.CENTER);
		frame.add(jp3,BorderLayout.SOUTH);
		frame.add(scrollPane,BorderLayout.CENTER);
		frame.add(return1,BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	IA.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ps1=major2.getText();
			String ps2=salary2.getText();
			if(ps1.equals("")||ps2.equals("")) {
				JOptionPane.showMessageDialog(null,"�����Ϣ��д����");
			}
			else {
				try {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					  tableModel.setRowCount(0);
				ResultSet rs=new SeekInformation().queryseeker(ps1,ps2);
				while(rs.next()) {
					Vector rowdata=new Vector();
					rowdata.add(rs.getString(1));
					rowdata.add(rs.getString(2));
					rowdata.add(rs.getString(3));
					rowdata.add(rs.getString(4));
					rowdata.add(rs.getString(5));
					row.add(rowdata);
				}
				rs.close();
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	});
	IB.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ps1=major2.getText();
			String ps2=salary2.getText();
			try {
				ResultSet rs=new SeekInformation().queryseeker(ps1,ps2);
				ArrayList<CompanyInform> list=new ArrayList<>();
				while(rs.next()) {
				CompanyInform ci=new CompanyInform();
				ci.setName(rs.getString(1));
				ci.setMajor(rs.getString(2));
				ci.setSalary(rs.getString(3));
				ci.setNum(rs.getString(4));
				ci.setAddress(rs.getString(5));
				list.add(ci);
				FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\filedemo\\CompanyInform.txt"));
				byte bt[]=new byte[1024];
				bt=list.toString().getBytes();
				fileOutputStream.write(bt);
				fileOutputStream.close();
			}
				JOptionPane.showMessageDialog(null,"�ղسɹ�");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	return1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			new Jobseeker();
		}
	});
   }
}
