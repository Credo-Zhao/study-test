package org.credo.base64;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Encode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String sample = "哒哒哒";
		Base64 base64 = new Base64();
		byte[] bytes = base64.encode(sample.getBytes("UTF-8"));
		String encode1 = new String(bytes, "UTF-8");
		System.out.println(encode1);
	}

}
