package com.tuyage.iEmail.diary;

/**
 * iEmail����־�����ࡣ
 * @author LeoTse
 */
public class IEmailDiary {
	
	// ����һ��
	private static boolean FLAG = true;
	
	/**
	 * ��ӡ��ͨ��������ͨ��Ϣ��
	 * @param c ��Ҫ��ӡ��Ϣ����
	 * @param info Ҫ��ӡ����Ϣ
	 */
	public static void INFORMATION(Class<?> c, String info){
		if(FLAG){
			System.out.println(">> " + c.getName() + " : " + info);
		} // end if
	} // end INFORMATION
	
	/**
	 * ��ӡ��ͨ�������쳣��Ϣ��
	 * @param c ��Ҫ��ӡ�쳣����
	 * @param ef �׳����쳣
	 * @param info Ҫ��ӡ����Ϣ
	 */
	public static void EXCEPTION(Class<?> c, Exception e, String info){
		if(FLAG){
			System.out.println("<< " + c.getName() + " : " + info);
			e.printStackTrace();
		} // end if
	} // end EXCEPTION
	
	/**
	 * ��ӡ��̬��������ͨ��Ϣ��
	 * @param className ��Ҫ��ӡ����
	 * @param info Ҫ��ӡ����Ϣ
	 */
	public static void INFORMATIONS(String className, String info){
		if(FLAG){
			System.out.println(">> " + className + " : " + info);
		} // end if 
	} // end INFORMATIONS
	
	/**
	 * ��ӡ��̬�������쳣��Ϣ��
	 * @param className Ҫ��ӡ��Ϣ����
	 * @param e �׳����쳣
	 * @param info Ҫ��ӡ����Ϣ
	 */
	public static void EXCEPTIONS(String className, Exception e, String info){
		if(FLAG){
			System.out.println("<< " + className + " : " + info);
			e.printStackTrace();
		} // end if
	} // end EXCEPTIONS

} // end class IEmailDiary
