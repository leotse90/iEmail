package com.tuyage.iEmail.clientUI;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.tuyage.iEmail.listener.IEmailMainUIListener;

/**
 * �����ƽ���ʵ���ࡣ
 * @author LeoTse
 */
public class IEmailMainUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// ����
	private String title = "iEmail v1.0";
	private int width = 200;
	private int height = 200;
	
	/**
	 * ��ʾ����ķ�����
	 */
	public void showUI(){
		// ���ô���Ļ�������
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		// ���ô���Ĳ���Ϊ��
		this.setLayout(null);
		
		// �ڴ��������һ�������ʼ��İ�ť
		JButton sendBtn = new JButton("Send e-mail");
		sendBtn.setBounds(45, 15, 100, 30);
		this.add(sendBtn);
		
		// �ڴ��������һ�������ʼ��İ�ť
		JButton loadBtn = new JButton("Load e-mail");
		loadBtn.setBounds(45, 75, 100, 30);
		this.add(loadBtn);
		
		// ���ô���Ϊ�ɼ�
		this.setVisible(true);
		
		// ����ť��Ӽ�����
		IEmailMainUIListener imuLis = new IEmailMainUIListener();
		sendBtn.addActionListener(imuLis);
		loadBtn.addActionListener(imuLis);
	} // end showUI

} // end class IEmailMainUI
