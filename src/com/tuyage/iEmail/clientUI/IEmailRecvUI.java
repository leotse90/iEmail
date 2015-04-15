package com.tuyage.iEmail.clientUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * iEmail下载邮件的界面。
 * @author LeoTse
 */
public class IEmailRecvUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// 声明
	private int width = 600;
	private int height = 450;
	private String title = "iEmail v1.0";
	
	// 声明一个文本显示区
	public static JTextArea mailArea;
	public static String str = "";
	
	/**
	 * 显示窗体的方法。
	 */
	public void showUI(){
		// 设置窗体的基本属性
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// 设置窗体的布局为空
		this.setLayout(null);
		
		// 添加一个文本显示区域
		mailArea = new JTextArea();
		mailArea.setBounds(25, 25, 530, 330);
		JScrollPane jsp = new JScrollPane(mailArea);
		mailArea.setEnabled(false);
		jsp.setAutoscrolls(true);
		mailArea.setBackground(Color.GRAY);
		jsp.setBounds(25, 25, 530, 330);
		mailArea.append(str);
		this.add(jsp);
		
		// 设置窗体为可见
		this.setVisible(true);
	} // end showUI

} // end class IEmailRecvUI
