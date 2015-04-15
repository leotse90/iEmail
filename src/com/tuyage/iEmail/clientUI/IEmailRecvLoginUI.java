package com.tuyage.iEmail.clientUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tuyage.iEmail.listener.IEmailRecvLoginListener;

/**
 * �����ʼ���������ǰ�ĵ�¼���档
 * @author LeoTse
 */
public class IEmailRecvLoginUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	// ������¼����Ļ�������
	private String title = "iEmail Check email Login";
	private int WIDTH = 300;
	private int HEIGHT = 240;
	
	// �����ı������
	public static JTextField nameField;
	// ����һ�����������
	public static JPasswordField pwdField;
	
	/**
	 * ��ʾ����ķ�����
	 */
	public void showUI(){
		// ���ô���Ļ�������
		this.setTitle(title);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		// ����ı������
		JLabel userName = new JLabel("Username");
		userName.setBounds(25, 25, 60, 25);
//		nameField = new JTextField("bluefairy90@163.com");
		nameField = new JTextField("1246355442@qq.com");
		nameField.setBounds(110, 25, 120, 25);
		this.add(userName);
		this.add(nameField);
		// ������������
		JLabel password = new JLabel("Password");
		password.setBounds(25, 65, 60, 25);
//		pwdField = new JPasswordField("05052201010");
		pwdField = new JPasswordField("bluefairy1246355442");
		pwdField.setBounds(110, 65, 120, 25);
		this.add(password);
		this.add(pwdField);
		
		// ��Ӱ�ť
		JButton confirm = new JButton("Confirm");
		confirm.setBounds(80, 120, 120, 30);
		this.add(confirm);
		
		// ���ô���Ϊ�ɼ�
		this.setVisible(true);
		
		// ����ť��Ӽ�����
		IEmailRecvLoginListener irLis = new IEmailRecvLoginListener();
		confirm.addActionListener(irLis);
		
	} // end showUI

} // end class IEmailRecvLoginUI
