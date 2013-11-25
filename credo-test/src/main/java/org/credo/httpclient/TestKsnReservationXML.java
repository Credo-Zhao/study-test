package org.credo.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.util.IOUtils;

public class TestKsnReservationXML {
	public static void main(String[] args) {
		try {// 使用HttpClient发送POST请求
			HttpClient httpClient = new DefaultHttpClient();
			HttpPut httpPut = new HttpPut("http://localhost:8080/kunlun-smart-notifier/rest/reservation");
			httpPut.setHeader("Encoding", "UTF-8");

			String temp=fr.opensagres.xdocreport.core.io.IOUtils.toString(new FileInputStream("E:\\xml\\PackageAndCharge.xml"));
			System.out.println(temp);
			StringEntity input=new StringEntity(temp);
//			InputStreamEntity input = new InputStreamEntity(new FileInputStream("E:\\xml\\PackageAndCharge.xml"), -1);
//			input.setContentType("application/xml");
			httpPut.setEntity(input);
			// MultipartEntity entity = new
			// MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			//
			// File sourceFile = new File("E:\\xml\\PackageAndCharge.xml");
			// FileBody fileBody = new FileBody(sourceFile, "application/xml");
			// entity.addPart("templateDocument", fileBody);
			//
			// httpPut.setEntity(entity);

			// 执行发送
			HttpResponse response = null;

			response = httpClient.execute(httpPut);

			// 得到结果码
			int httpStatusCode = response.getStatusLine().getStatusCode();
			System.out.println("httpStatusCode:" + httpStatusCode);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
