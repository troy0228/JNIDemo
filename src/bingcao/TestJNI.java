package bingcao;

/**
 * @author troy
 *         2017-08-22  下午19:28
 *
 */
import java.io.*;

public class TestJNI {
	// 声明本地方法
	public native double nativeMethod();

	public static void main(String[] args) throws IOException {
		
		int countRun = 0;
		FileOutputStream fs = new FileOutputStream(new File("D:\\myFileJNI.txt"));
		PrintStream printToFile = new PrintStream(fs);

		while(countRun < 10)
		{
			System.out.println("start " + countRun + " test..." );
			long startTime = System.currentTimeMillis(); // 获取开始时间
			// // 加载动态链接库
			System.load("D:/documents/visual studio 2013/Projects/nativeDLL/x64/Debug/nativeDLL.dll");
	
			TestJNI nativeCode = new TestJNI();
			double result = nativeCode.nativeMethod();
			System.out.println(result);
			System.out.println("JNI成功调用dll！！！");
	
			long endTime = System.currentTimeMillis(); // 获取结束时间
	
			System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
			
			printToFile.println(endTime - startTime);
			countRun++;
		}
		printToFile.close();
	}
}
