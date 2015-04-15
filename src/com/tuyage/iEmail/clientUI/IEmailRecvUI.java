package com.tuyage.iEmail.clientUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * iEmail�����ʼ��Ľ��档
 * @author LeoTse
 */
public class IEmailRecvUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// ����
	private int width = 600;
	private int height = 450;
	private String title = "iEmail v1.0";
	
	// ����һ���ı���ʾ��
	public static JTextArea mailArea;
	public static String str = "";
	
	/**
	 * ��ʾ����ķ�����
	 */
	public void showUI(){
		// ���ô���Ļ�������
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(2);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// ���ô���Ĳ���Ϊ��
		this.setLayout(null);
		
		// ���һ���ı���ʾ����
		mailArea = new JTextArea();
		mailArea.setBounds(25, 25, 530, 330);
		JScrollPane jsp = new JScrollPane(mailArea);
		mailArea.setEnabled(false);
		jsp.setAutoscrolls(true);
		mailArea.setBackground(Color.GRAY);
		jsp.setBounds(25, 25, 530, 330);
		mailArea.append(str);
		this.add(jsp);
		
		// ���ô���Ϊ�ɼ�
		this.setVisible(true);
	} // end showUI

} // end class IEmailRecvUI
