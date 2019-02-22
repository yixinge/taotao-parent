package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import com.taotao.common.util.FtpUtil;

public class FTPTest {
	
	@Test
	public void testFtpClient() throws Exception {
		//创建ftpclient对象
		//创建ftp链接
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.128.131",21);
		//登入ftp服务器
		ftpClient.login("ftpuser", "ftpuser");
		//上传文件
		String str="D:\\2133.jpg";
		String location=str.replace("\\\\", "/");
		FileInputStream inputStream = new FileInputStream(new File(location));
		//指定上传目录
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//指定上传的文件类型（是否二进制）
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("2133.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
	}
	
	@Test
	public void testFtpUtil() throws Exception {
		String str="D:\\2133.jpg";
		String location=str.replace("\\\\", "/");
		FileInputStream inputStream = new FileInputStream(new File(location));
		FtpUtil.uploadFile("192.168.128.131", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "2019", "2222.jpg", inputStream);
	}
	public static void main(String[] args) throws Exception {
		//创建ftpclient对象
		//创建ftp链接
		
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.128.131",21);
		//登入ftp服务器
		ftpClient.login("ftpuser", "ftpuser");
		//上传文件
		String str="D:\\2133.jpg";
		String location=str.replace("\\\\", "/");
		FileInputStream inputStream = new FileInputStream(new File(location));
		//指定上传目录
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//指定上传的文件类型（是否二进制）
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("2133.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
	}
}
