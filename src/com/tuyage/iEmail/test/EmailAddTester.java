package com.tuyage.iEmail.test;

import com.tuayge.iEmail.resolve.IEmailMsgPartition;

/**
 * ����Add��@ǰ���֡�
 * @author LeoTse
 */
public class EmailAddTester {
	
	/**
	 * ��������
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "<>xiefeng</><>jiuji</>";
		String res = "";
		res = IEmailMsgPartition.partitionEmail(str);
		System.out.println(res);
	} // end main

} // end class EmailAddTester
