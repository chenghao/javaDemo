package com.hao.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 将文件先读入到byte数组，然后从byte数组写入到文件的例子
 * @author Administrator
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		FileDemo fileDemo = new FileDemo();
		
		byte[] b = fileDemo.fileToByte("F:\\googleDownloads\\jdk-7u21-windows-i586.exe");
		
		fileDemo.byteToFile("f:\\jdk-7u21-windows-i586_demo.exe", b);
	}

	/**
	 * 将file转换为byte数组
	 * @param fileName
	 * @return
	 */
	public byte[] fileToByte(String fileName) {
		byte[] b = null;
		try {
			File file = new File(fileName);

			b = new byte[(int) file.length()];
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

			bis.read(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

	/**
	 * 将byte数组里的数据保存到文件里面
	 * @param fileName
	 * @param fileContent
	 */
	public void byteToFile(String fileName, byte[] fileContent) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
