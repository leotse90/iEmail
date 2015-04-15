package com.tuyage.iEmail.recvmail;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.tuyage.iEmail.clientUI.IEmailRecvLoginUI;
import com.tuyage.iEmail.clientUI.IEmailRecvUI;
import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * �ӱ�׼�����������ʼ���
 * @author LeoTse
 */
public class IEmailMailLoader {
	
	// �������������
	private static DataInputStream dins = IEmailRecvConnector.dins;
	private static DataOutputStream dous = IEmailRecvConnector.dous;
	
	// ����һ�����з�
	static String LINEFEET = "\n\r";
	
	/**
	 * �����ʼ����ͻ��ˡ�
	 */
	@SuppressWarnings("deprecation")
	public void recvMail(){
		// �õ�������û���������
		String uName = IEmailRecvLoginUI.nameField.getText();
		String uPwd = IEmailRecvLoginUI.pwdField.getText();
		IEmailDiary.INFORMATION(this.getClass(), " uName: " + uName + "&uPwd: " + uPwd);
		// ���û��������뷢�͵���׼��������֤
		String res1 = sendMsg("USER " + uName + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "USER: " + res1);
		String res2 = sendMsg("PASS " + uPwd + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "PASS: " + res2);
		String res3 = sendMsg("STAT" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "STAT: " + res3);
		String res4 = sendMsg("LIST" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "LIST: " + res4);
		String res5 = sendMsg("RETR " + 1 + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "RETR: " + res5);
		String res6 = sendMsg("TOP " + 1 + " " + 20 + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "TOP: " + res6);
		for(int i = 0; i < 60; i ++){
			String res = response();
			try {
				res = new String(res.getBytes("ISO-8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println(res);
			IEmailRecvUI.str += res + "\n";
		} // end for
		String res7 = sendMsg("QUIT" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "QUIT: " + res7);
	} // end recvMail
	
	/**
	 * ����һ����Ϣ��
	 * @param str Ҫ���͵���Ϣ
	 * @return ���ض�ȡ�����ַ���
	 */
	private String sendMsg(String str){
		// ����
		String res = null;
		try {
			// д�������
			dous.writeBytes(str);
			dous.flush();
			res = response();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to write dous.");
		} // end try-catch
		return res;
	} // end sendMsg
	
	/**
	 * ���������ж�ȡ��Ϣ��
	 * @return ��ȡ�����ַ���
	 */
	@SuppressWarnings("deprecation")
	private String response(){
		// ����һ���ַ���
		String res = null;
		try {
			res = dins.readLine();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Read from dins failed.");
		} // end try-catch
		return res;
	} // end response
	
	/**
	 * �ر������������
	 */
//	private void close(){
//		try {
//			// �ر����������
//			dins.close();
//			dous.close();
//		} catch (IOException e) {
//			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to close streams.");
//		} // end try-catch
//	} // end close

} // end class IEmailMailLoader
