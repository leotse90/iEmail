package com.tuyage.iEmail.sendmail;

import it.sauronsoftware.base64.Base64;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

import com.tuyage.iEmail.clientUI.IEmailSendUI;
import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * 发送邮件的实现类。
 * @author LeoTse
 */
public class IEmailMailSender {
	
	// 声明输入输出流
	public static BufferedReader ins = IEmailSendConnector.ins;
	public static DataOutputStream ous = IEmailSendConnector.ous;
	
	// 声明一个换行
	static String LINEFEET = "\r\n";
	
	// 声明使用者的密码(测试版本以后版本可以自己输入)
	String pwd = "bluefairy1246355442";
	
	/**
	 * 发送邮件的方法。
	 * @return 发送成功，返回true，否则返回false
	 */
	public boolean sendMail(){
		// 与服务器进行初次通信，确立连接
		String res1 = sendMsg("HELO " + IEmailSendConnector.host + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "HELO >> " + res1);
		// 判断是否连接成功
		if(res1.startsWith("220")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "1 Failed to connect the server!");
			return false;
		} // end if-else
		// 验证发送人信息
		String res2 = sendMsg("AUTH LOGIN " + LINEFEET); 
		IEmailDiary.INFORMATION(this.getClass(), "AUTH >> " + res2);
		if(res2.startsWith("250")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "2 Failed to connect the server!");
			return false;
		} // end if-elseS
		// 发送用户名
		String res3 = sendMsg(new String(
				Base64.encode("1246355442".getBytes())) + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "USERNAME >> " + res3);
		if(res3.startsWith("334")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "3 Failed to connect the server!");
			return false;
		} // end if-else
		// 发送密码
		String res4 = sendMsg(new String(Base64.encode(pwd.getBytes())) + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "PASSWORD >> " + res4);
		if(res4.startsWith("334")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "4 Failed to connect the server!");
			return false;
		} // end if-else
		
		// 发送邮件内容
		// 发送者
		String from = IEmailSendUI.fromFiled.getText();
		String res5 = sendMsg("MAIL FROM: " + from + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "MAILFROM >> " + res5);
		if(res5.startsWith("235")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "5 Failed to connect the server!");
			return false;
		} // end if-else
		// 接受者
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
		
		// 创建一个StringBuilder
		StringBuilder sbl = new StringBuilder();
		sbl.append("From: " + from + LINEFEET);
		sbl.append("To: " + to + LINEFEET);
		sbl.append("Subject: " + IEmailSendUI.ccFiled.getText() + LINEFEET);
		sbl.append("Content-Type:text/plain;charset=\"GB2312\""+LINEFEET);
		sbl.append(LINEFEET);
		sbl.append(IEmailSendUI.contentPane.getText());
		sbl.append(LINEFEET + "." + LINEFEET);
		
		// 发送邮件
		String res = sendMsg(sbl.toString());
		IEmailDiary.INFORMATION(this.getClass(), "StringBuffer >> " + res);
		if(res.startsWith("354")){
		}else{
			IEmailDiary.INFORMATION(this.getClass(), "Failed to send mail!");
			return false;
		} // end if-else
		
		// 断开连接
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
	 * 向输出流写入一条信息。
	 * @param str 要写入的信息
	 */
	private String sendMsg(String str){
		String res = null;
		try {
			// 将字符串写入流
			ous.writeBytes(str);
			ous.flush();
			res = response();
		} catch (IOException e) {
			// 打印异常信息
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to write string into ous!");
		} // end try-catch
		return res;
	} // end sendMsg
	
	/**
	 * 关闭输入输出流
	 */
	private void close(){
		try {
			// 关闭输入输出流
			ins.close();
			ous.close();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to close ins or ous!");
		} // end try-catch
		 
	} // end close
	
	/**
	 * 读取并返回输入流的信息。
	 * @return 返回读取到的信息
	 */
	private String response(){
		String res = null;
		try {
			// 读取输入流中的回复信息
			res = ins.readLine();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to get response!");
		} // end try-catch
		return res;
	} // end response

} // end class IEmailMailSender
