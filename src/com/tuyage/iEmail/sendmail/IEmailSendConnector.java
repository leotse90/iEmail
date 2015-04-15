package com.tuyage.iEmail.sendmail;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * 发送邮件时连接邮箱服务器的实现类。
 * @author LeoTse
 */
public class IEmailSendConnector {
	
	// 声明邮箱服务器的名字(暂设为常用的QQ邮箱)
	public static String host = "smtp.qq.com";
	// 声明打开的端口号
	private static int port = 25;
	
	// 定义一个输入流
	public static BufferedReader ins;
	// 定义一个输出流
	public static DataOutputStream ous;
	
	// 定义一个Socket对象
	private static Socket smtp;
	
	/**
	 * 连接标准服务器。
	 */
	public static void sendConnector(){
		try {
			// 创建一个Socket对象
			smtp = new Socket(host, port);
			ins = new BufferedReader(new InputStreamReader(smtp.getInputStream())); 
			ous = new DataOutputStream(smtp.getOutputStream()); 
			IEmailDiary.INFORMATIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector"
					, "Succeed to connect the server.");
		} catch (UnknownHostException e) {
			// 打印消息，抛出异常，弹出消息提示框
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector",
					e, "UnknownHost! Connect failed!");
			JOptionPane.showMessageDialog(null, "Unknown host!",
					"Warning", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			// 打印消息，抛出异常，弹出消息提示框
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector",
					e, "Connction failed!");
			JOptionPane.showMessageDialog(null, "Connction failed!",
					"Warning", JOptionPane.WARNING_MESSAGE);
		} // end try-catch
	} // end sendConnector
	
	/**
	 * 断开socket连接。
	 */
	public static void sendCut(){
		try {
			// 断开连接
			smtp.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector"
					, e, "Failed to cut the connection.");
		} // end try-catch
	} // end sendCut
	
} // end class IEmailSendConnector
