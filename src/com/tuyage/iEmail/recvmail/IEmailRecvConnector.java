package com.tuyage.iEmail.recvmail;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * iEmail���ʼ����ضˡ�
 * @author LeoTse
 */
public class IEmailRecvConnector {
	
	// �����˿ں�����
	public static String host = "pop.qq.com";
	public static int port = 110;
	
	// �����������������
	public static DataInputStream dins;
	public static DataOutputStream dous;
	// ����һ��Socket����
	static Socket pop;
	
	/**
	 * �����ʼ��������ӱ�׼�������ķ�����
	 */
	public static void recvConnector(){
		try {
			// �½�һ��Socket����
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
	 * �Ͽ����׼�����������ӡ�
	 */
	public static void recvCut(){
		try {
			// �Ͽ�����
			pop.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.recvmail.IEmailRecvConnector",
					e, "Failed to cut connection with server.");
		} // end try-catch
	} // end recvCut

} // end class IEmailRecvConnector
