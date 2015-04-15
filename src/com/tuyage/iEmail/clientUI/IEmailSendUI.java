package com.tuyage.iEmail.clientUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.tuyage.iEmail.listener.IEmailSendListener;

/**
 * iEmail系统界面类。
 * @author LeoTse
 */
public class IEmailSendUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// 声明
	private String title = "iEmail v1.0";
	private int width = 640;
	private int height = 440;
	
	// 声明文本输入框
	public static JTextField fromFiled;
	public static JTextField toField;
	public static JTextField ccFiled;
	public static JTextField topicField;
	public static JTextPane contentPane;
	
	/**
	 * 设置窗体的基本属性。
	 */
	public void showUI(){
		
		// 设置窗体的标题和大小
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(2);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		// 设置窗体的布局为空
		this.setLayout(null);
		
		// 设置文本输入框
		// 发送人邮箱
		JLabel from = new JLabel("From...");
		from.setBounds(25, 15, 40, 10);
		fromFiled = new JTextField("1246355442@qq.com");
		fromFiled.setBounds(70, 10, 520, 22);
		this.add(from);
		this.add(fromFiled);
		// 接收人邮箱
		JLabel to = new JLabel("To...");
		to.setBounds(25, 40, 40, 10);
		toField = new JTextField("bluefairy90@163.com");
		toField.setBounds(70, 35, 520, 22);
		this.add(to);
		this.add(toField);
		// 抄送
		JLabel cc = new JLabel("Cc...");
		cc.setBounds(25, 65, 40, 10);
		ccFiled = new JTextField("hello");
		ccFiled.setBounds(70, 60, 520, 22);
		this.add(cc);
		this.add(ccFiled);
		// 邮件主题
		JLabel topic = new JLabel("Topic");
		topic.setBounds(25, 90, 40, 10);
		topicField = new JTextField("my first email");
		topicField.setBounds(70, 85, 520, 22);
		this.add(topic);
		this.add(topicField);
		// 邮件正文
		JLabel content = new JLabel("Content...");
		content.setBounds(25, 115, 60, 10);
		contentPane = new JTextPane();
		contentPane.setBounds(25, 135, 560, 200);
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setBounds(25, 135, 560, 200);
		this.add(content);
		this.add(contentPane);
		this.add(scroll);
		// 添加附件按钮
		JButton addBtn = new JButton("Add attachments..");
		addBtn.setBounds(25, 350, 150, 25);
		this.add(addBtn);
		// 发送按钮
		JButton sendBtn = new JButton("Send..");
		sendBtn.setBounds(190, 350, 100, 25);
		this.add(sendBtn);
		
		// 设置窗体为可见
		this.setVisible(true);
		
		// 给按钮添加监听器
		IEmailSendListener isLis = new IEmailSendListener();
		addBtn.addActionListener(isLis);
		sendBtn.addActionListener(isLis);
		
	} // end showUI

} // end class IEmailUI
