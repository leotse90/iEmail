package com.tuyage.iEmail.test;

import com.tuyage.iEmail.clientUI.IEmailRecvLoginUI;

/**
 * 测试登陆界面。
 * @author LeoTse
 */
public class LoginUITester {
	
	/**
	 * 主函数。
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个IEmailRecvLoginUI
		IEmailRecvLoginUI irlu = new IEmailRecvLoginUI();
		irlu.showUI();
	} // end main

} // end class LoginUITester
