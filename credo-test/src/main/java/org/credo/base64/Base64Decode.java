package org.credo.base64;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Decode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "emhhb3FpYW7nn7Ppm6o="; // YWJj为要解密的字符串
		byte[] b = Base64.decodeBase64(str.getBytes());
		System.out.println(new String(b,"UTF-8"));
	}

}
