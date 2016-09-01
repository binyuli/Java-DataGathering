package com.sds.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TpartsDataGethering {
	public static void appendMethodA(String targetFilePath,String resultFile){

		try {
			RandomAccessFile raf = new RandomAccessFile(resultFile, "rw"); // 该类可以定位文件,
			File targetFile = new File(targetFilePath);
			BufferedReader br = new BufferedReader(new FileReader(targetFile));

			long len = targetFile.length(); // 获得文件的长度,以便定位末尾
			if (len == 0) { // 判断文件是否为空
				System.out.println("the flie is NULL!");
				br.close();
				raf.close(); // 关闭
				return;
			}else{
				raf.seek(raf.length());
			}

			String line = "";
			while ((line = br.readLine()) != null) {
				raf.writeChars(line);
			}

			br.close();
			raf.close(); // 关闭
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// read the files under the path targetFilePath,and output the result in resultFile
	public static void appendMethodB(String targetFilePath,String resultFile){

       try {
    	   	File target = new File(targetFilePath);
    	   	File[] files = target.listFiles();
    	   	for (int i = 0; i < files.length; i++) {
    	   		System.out.println("file " + (i + 1) + " begins to write");
    	   		File targetFile = files[i];
    	   		
    	   		FileWriter bw = new FileWriter(resultFile,true); // 该类可以定位文件,
    	   		BufferedReader br = new BufferedReader(new FileReader(targetFile));
    	   		
    	   		long len = targetFile.length(); // 获得文件的长度,以便定位末尾
    	   		if (len == 0) { // 判断文件是否为空
    	   			System.out.println("the flie is NULL!");
    	   			br.close();
    	   			bw.close(); // 关闭
    	   			return;
    	   		}
    	   		
    	   		String line = "";
    	   		while ((line = br.readLine()) != null) {
    	   			bw.write(line + "\r");
    	   		}
    	   		
    	   		br.close();
    	   		bw.close(); // 关闭
    	   	}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public static void main(String[] args) {
//		String targetFilePath = "D:/kplus_brand.sql";
//		String targetFilePath = "D:/kplus_product_category.sql";
//		String targetFilePath = "D:/vehicletype.sql";
//		String targetFilePath = "D:/kplus_product.sql";
//		String targetFilePath = "D:/partscategory.sql";
//		String targetFilePath = "D:/partsoem.sql";
//		String targetFilePath = "D:/vehicletype_partscategory.sql";

		String targetFilePath = "D:/input";
		String resultFile = "D:/output/tpartsImport.sql";

//		appendMethodA(targetFilePath,resultFile);
		appendMethodB(targetFilePath,resultFile);
		System.out.println("write finished !");
	}
	
}
