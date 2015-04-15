package com.tuyage.iEmail.clientUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tuyage.iEmail.listener.IEmailRecvLoginListener;

/**
 * 下载邮件功能启用前的登录界面。
 * @author LeoTse
 */
public class IEmailRecvLoginUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	// 声明登录窗体的基本属性
	private String title = "iEmail Check email Login";
	private int WIDTH = 300;
	private int HEIGHT = 240;
	
	// 声明文本输入框
	public static JTextField nameField;
	// 声明一个密码输入框
	public static JPasswordField pwdField;
	
	/**
	 * 显示窗体的方法。
	 */
	public void showUI(){
		// 设置窗体的基本属性
		this.setTitle(title);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		// 添加文本输入框
		JLabel userName = new JLabel("Username");
		userName.setBounds(25, 25, 60, 25);
//		nameField = new JTextField("bluefairy90@163.com");
		nameField = new JTextField("1246355442@qq.com");
		nameField.setBounds(110, 25, 120, 25);
		this.add(userName);
		this.add(nameField);
		// 添加密码输入框
		JLabel password = new JLabel("Password");
		password.setBounds(25, 65, 60, 25);
//		pwdField = new JPasswordField("05052201010");
		pwdField = new JPasswordField("bluefairy1246355442");
		pwdField.setBounds(110, 65, 120, 25);
		this.add(password);
		this.add(pwdField);
		
		// 添加按钮
		JButton confirm = new JButton("Confirm");
		confirm.setBounds(80, 120, 120, 30);
		this.add(confirm);
		
		// 设置窗体为可见
		this.setVisible(true);
		
		// 给按钮添加监听器
		IEmailRecvLoginListener irLis = new IEmailRecvLoginListener();
		confirm.addActionListener(irLis);
		
	} // end showUI

} // end class IEmailRecvLoginUI
