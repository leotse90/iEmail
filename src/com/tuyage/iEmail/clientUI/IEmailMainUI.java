package com.tuyage.iEmail.clientUI;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.tuyage.iEmail.listener.IEmailMainUIListener;

/**
 * 主控制界面实现类。
 * @author LeoTse
 */
public class IEmailMainUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// 声明
	private String title = "iEmail v1.0";
	private int width = 200;
	private int height = 200;
	
	/**
	 * 显示窗体的方法。
	 */
	public void showUI(){
		// 设置窗体的基本属性
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		// 设置窗体的布局为空
		this.setLayout(null);
		
		// 在窗体上添加一个发送邮件的按钮
		JButton sendBtn = new JButton("Send e-mail");
		sendBtn.setBounds(45, 15, 100, 30);
		this.add(sendBtn);
		
		// 在窗体上添加一个下载邮件的按钮
		JButton loadBtn = new JButton("Load e-mail");
		loadBtn.setBounds(45, 75, 100, 30);
		this.add(loadBtn);
		
		// 设置窗体为可见
		this.setVisible(true);
		
		// 给按钮添加监听器
		IEmailMainUIListener imuLis = new IEmailMainUIListener();
		sendBtn.addActionListener(imuLis);
		loadBtn.addActionListener(imuLis);
	} // end showUI

} // end class IEmailMainUI
