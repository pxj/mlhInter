package com.mlhInter.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 常用加密算法工具类
 * @author cq
 */
public class EncryptUtils {
	
	/**
	 * 用MD5算法进行加密
	 * @param str 需要加密的字符串
	 * @return MD5加密后的结果
	 */
	public String encodeMD5String(String str) {
		return encode(str, "MD5");
	}

	private String encode(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			dstr = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}
	
}
