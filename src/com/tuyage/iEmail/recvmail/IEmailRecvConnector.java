package com.tuyage.iEmail.recvmail;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * iEmail的邮件下载端。
 * @author LeoTse
 */
public class IEmailRecvConnector {
	
	// 声明端口和主机
	public static String host = "pop.qq.com";
	public static int port = 110;
	
	// 声明输入流和输出流
	public static DataInputStream dins;
	public static DataOutputStream dous;
	// 声明一个Socket对象
	static Socket pop;
	
	/**
	 * 接收邮件界面连接标准服务器的方法。
	 */
	public static void recvConnector(){
		try {
			// 新建一个Socket连接
			pop = new Socket(host, port);
			dins = new DataInputStream(pop.getInputStream());
			dous = new DataOutputStream(pop.getOutputStream());
		} catch (UnknownHostException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.recvmail.IEmailRecvConnector"
					, e, "Unknown host!");
		} catch (IOException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.recvmail.IEmailRecvConnector"
					, e, "Failed to read or write.");
		} // end try-catch
	} // end recvConnector
	
	/**
	 * 断开与标准服务器的连接。
	 */
	public static void recvCut(){
		try {
			// 断开连接
			pop.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.recvmail.IEmailRecvConnector",
					e, "Failed to cut connection with server.");
		} // end try-catch
	} // end recvCut

} // end class IEmailRecvConnector
