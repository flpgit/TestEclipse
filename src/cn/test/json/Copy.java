package cn.test.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	//图片复制
	public static void main(String[] args) throws Exception{
		File inFile = new File("");
		File outFile = new File("");
		if(!outFile.getParentFile().exists()){
			outFile.getParentFile().mkdirs();
		}
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			Long start = System.currentTimeMillis();
			inputStream = new FileInputStream(inFile);
			outputStream = new FileOutputStream(outFile);
			byte[] data = new byte[1024];
			int temp = 0;
			if((temp=inputStream.read(data))!=-1){
				outputStream.write(data, 0,temp);
			}
			String[] arr = new String[1024];
			String[] a = {"",""};
			String[] ab = new String[]{"",""};
			Long end = System.currentTimeMillis();
			System.out.println("*****花费时间******"+(end-start));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(inputStream!=null){
				inputStream.close();
			} 
			if(outputStream!=null){
				outputStream.close();
			}
		}
	}
}
