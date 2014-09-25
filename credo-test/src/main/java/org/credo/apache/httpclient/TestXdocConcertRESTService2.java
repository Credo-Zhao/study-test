
package org.credo.apache.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 * @author: Credo
 * @date: 2013-10-16
 */
public class TestXdocConcertRESTService2 {

	public static void main(String[] args) throws Exception {

		// 准备数据
		File sourceFile = new File("E:\\KSN传真模板设置.doc");

		HttpPost httpPost = new HttpPost("http://localhost:8080/kunlun-rest-reporting/rest/convert/pdf?fileName=aa.odt");
		httpPost.setHeader("Encoding", "UTF-8");
		httpPost.setHeader("Accept-Charset", "UTF-8");

		MultipartEntity entity = new MultipartEntity();
		entity.addPart("file", new FileBody(sourceFile));
		httpPost.setEntity(entity);

		// 使用HttpClient发送POST请求
		HttpClient httpClient = new DefaultHttpClient();
		// 执行发送
		HttpResponse response = httpClient.execute(httpPost);
		// 得到结果码
		int httpStatusCode = response.getStatusLine().getStatusCode();
		System.out.println("httpStatusCode:" + httpStatusCode);
		// get file
		InputStream in = response.getEntity().getContent();
		// get file name
		Header header = response.getFirstHeader("Content-Disposition");
		System.out.println("header.getValue():" + header.getValue());
		String fileNameTemp = header.getValue().replace(ATTACHMENT_FILENAME_START, "");
		String fileName = fileNameTemp.replace(ATTACHMENT_FILENAME_END, "");
		inputstreamtofile(in, new File("E://" + fileName));
		httpClient.getConnectionManager().shutdown();
	}

	public static void inputstreamtofile(InputStream ins, File file) throws Exception {

		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ( ( bytesRead = ins.read(buffer, 0, 8192) ) != -1 )
		{
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}

	public static final String ATTACHMENT_FILENAME_START = "attachment; filename=\"";

	public static final String ATTACHMENT_FILENAME_END = "\"";
}
