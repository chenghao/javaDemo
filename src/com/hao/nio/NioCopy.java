package com.hao.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioCopy {

	public void copy(String fromFilePath, String toFilePath) {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(fromFilePath, "r");
			FileOutputStream fileOutputStream = new FileOutputStream(toFilePath);

			FileChannel fromFileChannel = randomAccessFile.getChannel();
			FileChannel toFileChannel = fileOutputStream.getChannel();

			//创建一个10kb的Buffer
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 10);
			
			//将管道的数据写到Buffer里面
			while (fromFileChannel.read(byteBuffer) != -1) {
				//flip方法将Buffer从写模式切换到读模式
				byteBuffer.flip();
				
				//将Buffer里的数据写到管道里面
				toFileChannel.write(byteBuffer);

				//clear方法将Buffer从读模式切换到写模式
				//Buffer被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。
				byteBuffer.clear();
				//compact方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面
				//如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先先写些数据，那么使用compact()方法
				//byteBuffer.compact();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("copy完成。");
	}

	public static void main(String[] args) {
		NioCopy nioCopy = new NioCopy();
		
		nioCopy.copy("d:/Adobe_Photoshop_CS5_Extend_XiaZaiBa.zip", "d:/copy_1.zip");
	}
}
