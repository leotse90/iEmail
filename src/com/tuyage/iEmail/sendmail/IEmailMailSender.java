package com.tuyage.iEmail.sendmail;

import it.sauronsoftware.base64.Base64;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

import com.tuyage.iEmail.clientUI.IEmailSendUI;
import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * �����ʼ���ʵ���ࡣ
 * @author LeoTse
 */
public class IEmailMailSender {
	
	// �������������
	public static BufferedReader ins = IEmailSendConnector.ins;
	public static DataOutputStream ous = IEmailSendConnector.ous;
	
	// ����һ������
	static String LINEFEET = "\r\n";
	
	// ����ʹ���ߵ�����(���԰汾�Ժ�汾�����Լ�����)
	String pwd = "bluefairy1246355442";
	
	/**
	 * �����ʼ��ķ�����
	 * @return ���ͳɹ�������true�����򷵻�false
	 */
	public boolean sendMail(){
		// ����������г���ͨ�ţ�ȷ������
		String res1 = sendMsg("HELO " + IEmailSendConnector.host + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "HELO >> " + res1);
		// �ж��Ƿ����ӳɹ�
		if(res1.startsWith("220")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "1 Failed to connect the server!");
			return false;
		} // end if-else
		// ��֤��������Ϣ
		String res2 = sendMsg("AUTH LOGIN " + LINEFEET); 
		IEmailDiary.INFORMATION(this.getClass(), "AUTH >> " + res2);
		if(res2.startsWith("250")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "2 Failed to connect the server!");
			return false;
		} // end if-elseS
		// �����û���
		String res3 = sendMsg(new String(
				Base64.encode("1246355442".getBytes())) + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "USERNAME >> " + res3);
		if(res3.startsWith("334")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "3 Failed to connect the server!");
			return false;
		} // end if-else
		// ��������
		String res4 = sendMsg(new String(Base64.encode(pwd.getBytes())) + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "PASSWORD >> " + res4);
		if(res4.startsWith("334")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "4 Failed to connect the server!");
			return false;
		} // end if-else
		
		// �����ʼ�����
		// ������
		String from = IEmailSendUI.fromFiled.getText();
		String res5 = sendMsg("MAIL FROM: " + from + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "MAILFROM >> " + res5);
		if(res5.startsWith("235")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "5 Failed to connect the server!");
			return false;
		} // end if-else
		// ������
		String to = IEmailSendUI.toField.getText();
		String res6 = sendMsg("RCPT TO: " + to + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "RCPTTO >> " + res6);
		if(res6.startsWith("250")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "6 Failed to connect the server!");
			return false;
		} // end if-else
		// DATA
		String res7 = sendMsg("DATA" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "DATA >> " + res7);
		if(res7.startsWith("250")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "7 Failed to connect the server!");
			return false;
		} // end if-else
		
		// ����һ��StringBuilder
		StringBuilder sbl = new StringBuilder();
		sbl.append("From: " + from + LINEFEET);
		sbl.append("To: " + to + LINEFEET);
		sbl.append("Subject: " + IEmailSendUI.ccFiled.getText() + LINEFEET);
		sbl.append("Content-Type:text/plain;charset=\"GB2312\""+LINEFEET);
		sbl.append(LINEFEET);
		sbl.append(IEmailSendUI.contentPane.getText());
		sbl.append(LINEFEET + "." + LINEFEET);
		
		// �����ʼ�
		String res = sendMsg(sbl.toString());
		IEmailDiary.INFORMATION(this.getClass(), "StringBuffer >> " + res);
		if(res.startsWith("354")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "Failed to send mail!");
			return false;
		} // end if-else
		
		// �Ͽ�����
		String res8 = sendMsg("QUIT" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "QUIT >> " + res8);
		if(res8.startsWith("250")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "Failed to quit!");
			return false;
		} // end if-else
		close();
		IEmailSendConnector.sendCut();
		return true;
	} // end sendMail
	
	/**
	 * �������д��һ����Ϣ��
	 * @param str Ҫд�����Ϣ
	 */
	private String sendMsg(String str){
		String res = null;
		try {
			// ���ַ���д����
			ous.writeBytes(str);
			ous.flush();
			res = response();
		} catch (IOException e) {
			// ��ӡ�쳣��Ϣ
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to write string into ous!");
		} // end try-catch
		return res;
	} // end sendMsg
	
	/**
	 * �ر����������
	 */
	private void close(){
		try {
			// �ر����������
			ins.close();
			ous.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to close ins or ous!");
		} // end try-catch
		 
	} // end close
	
	/**
	 * ��ȡ����������������Ϣ��
	 * @return ���ض�ȡ������Ϣ
	 */
	private String response(){
		String res = null;
		try {
			// ��ȡ�������еĻظ���Ϣ
			res = ins.readLine();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to get response!");
		} // end try-catch
		return res;
	} // end response

} // end class IEmailMailSender
