package cn.chestnut.mvvm.teamworker.utils;

import java.security.MessageDigest;

/**
 * Copyright (c) 2017, Chestnut All rights reserved
 * Author: Chestnut
 * CreateTime：at 2017/12/10 20:49:37
 * Description：MD5加密
 * Email: xiaoting233zhang@126.com
 */

public class MD5 {

	public static String MD5(String pwd) {
		//用于加密的字符
		char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F'};
		try {
			//使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
			byte[] btInput = pwd.getBytes();

			//信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			//MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
			mdInst.update(btInput);

			// 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
			byte[] md = mdInst.digest();

			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = md5String[byte0 >>> 4 & 0xf];
				str[k++] = md5String[byte0 & 0xf];
			}

			//返回经过加密后的字符串
			return new String(str);

		} catch (Exception e) {
			return null;
		}
	}
}
