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
 * �����ʼ�ʱ���������������ʵ���ࡣ
 * @author LeoTse
 */
public class IEmailSendConnector {
	
	// �������������������(����Ϊ���õ�QQ����)
	public static String host = "smtp.qq.com";
	// �����򿪵Ķ˿ں�
	private static int port = 25;
	
	// ����һ��������
	public static BufferedReader ins;
	// ����һ�������
	public static DataOutputStream ous;
	
	// ����һ��Socket����
	private static Socket smtp;
	
	/**
	 * ���ӱ�׼��������
	 */
	public static void sendConnector(){
		try {
			// ����һ��Socket����
			smtp = new Socket(host, port);
			ins = new BufferedReader(new InputStreamReader(smtp.getInputStream())); 
			ous = new DataOutputStream(smtp.getOutputStream()); 
			IEmailDiary.INFORMATIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector"
					, "Succeed to connect the server.");
		} catch (UnknownHostException e) {
			// ��ӡ��Ϣ���׳��쳣��������Ϣ��ʾ��
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector",
					e, "UnknownHost! Connect failed!");
			JOptionPane.showMessageDialog(null, "Unknown host!",
					"Warning", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			// ��ӡ��Ϣ���׳��쳣��������Ϣ��ʾ��
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector",
					e, "Connction failed!");
			JOptionPane.showMessageDialog(null, "Connction failed!",
					"Warning", JOptionPane.WARNING_MESSAGE);
		} // end try-catch
	} // end sendConnector
	
	/**
	 * �Ͽ�socket���ӡ�
	 */
	public static void sendCut(){
		try {
			// �Ͽ�����
			smtp.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTIONS("com.tuyage.iEmail.sendmail.IEmailSendConnector"
					, e, "Failed to cut the connection.");
		} // end try-catch
	} // end sendCut
	
} // end class IEmailSendConnector
