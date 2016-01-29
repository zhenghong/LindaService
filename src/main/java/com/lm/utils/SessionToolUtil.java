package com.lm.utils;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SessionToolUtil {

	private static final char DICTIONARY[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private String computerAddr;
	private int instanceIdx;
	private static Object syncObj = new Object();
	private static long counter = 0;

	public String generateSessionId() {

		String sessionKey = getSessionKey();

		byte abyte0[] = sessionKey.getBytes();

		String encryptionAlgorithm = "SHA";
		MessageDigest messageDigest;

		try {
			messageDigest = MessageDigest.getInstance(encryptionAlgorithm);
			abyte0 = messageDigest.digest(abyte0);
		} catch (NoSuchAlgorithmException e) {
			return "";
		}

		StringBuffer stringbuffer = new StringBuffer(40);

		for (int l = 0; l < abyte0.length; l++) {
			int k = abyte0[l] + 128;
			int i = k / DICTIONARY.length;
			int j = k % DICTIONARY.length;
			stringbuffer.append(DICTIONARY[i]);
			stringbuffer.append(DICTIONARY[j]);
		}

		return stringbuffer.toString();
	}

	/**
	 * ������������SessionId��key��
	 * 
	 * @return key
	 */
	private String getSessionKey() {
		char SEPARATOR = '#';
		StringBuffer buf = new StringBuffer();

		buf.append(getLocalHost()); // ������ַ

		buf.append(SEPARATOR);

		buf.append(String.valueOf(instanceIdx)); // ʵ������
		buf.append(SEPARATOR);

		long l;
		synchronized (syncObj) {
			l = ++counter;
		}

		buf.append(Long.toHexString(l)); // ������
		buf.append(SEPARATOR);

		buf.append(Long.toHexString(System.currentTimeMillis())); // ��ǰʱ��
		buf.append(SEPARATOR);

		return buf.toString();

	}

	/**
	 * ��ñ���IP��ַ��
	 * 
	 * @return ����IP��ַ
	 */
	private String getLocalHost() {
		if (computerAddr == null) {
			try {
				computerAddr = InetAddress.getLocalHost().getHostAddress();
			} catch (Exception _ex) {
				computerAddr = "UNKNOW_IP";
			}
		}
		return computerAddr;
	}

}
