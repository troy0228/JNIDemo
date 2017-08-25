package bingcao;

/**
 * @author troy
 *         2017-08-22  ����19:28
 *
 */
import java.io.*;

public class TestJNI {
	// �������ط���
	public native double nativeMethod();

	public static void main(String[] args) throws IOException {
		
		int countRun = 0;
		FileOutputStream fs = new FileOutputStream(new File("D:\\myFileJNI.txt"));
		PrintStream printToFile = new PrintStream(fs);

		while(countRun < 10)
		{
			System.out.println("start " + countRun + " test..." );
			long startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
			// // ���ض�̬���ӿ�
			System.load("D:/documents/visual studio 2013/Projects/nativeDLL/x64/Debug/nativeDLL.dll");
	
			TestJNI nativeCode = new TestJNI();
			double result = nativeCode.nativeMethod();
			System.out.println(result);
			System.out.println("JNI�ɹ�����dll������");
	
			long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��
	
			System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
			
			printToFile.println(endTime - startTime);
			countRun++;
		}
		printToFile.close();
	}
}
