package com.taotaoke.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FtpTest {

	public static void main(String[] args) throws Exception {

		// 初始化FTP客户端
		FTPClient client = new FTPClient();
		// 连接 ftp
		client.connect("39.108.209.252");
		// 登录
		client.login("ftpuser", "xxh@2018");

		// 文件类型
		client.setFileType(FTP.BINARY_FILE_TYPE);

		// 上传的文件 第一个参数 文件名字 第二个路径
		FileInputStream local = new FileInputStream(
				new File("C:\\Users\\Administrator\\Desktop\\QQ截图20190130105048.png"));
		client.storeFile("123.png", local);
		local.close();
		// 关闭
		client.logout();
	}

}
