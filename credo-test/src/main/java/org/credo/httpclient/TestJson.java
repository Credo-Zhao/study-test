package org.credo.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.util.IOUtils;

import net.sf.json.JSONObject;

public class TestJson {
	public static void main(String[] args) throws Exception {
		StringBuilder jsonDataBuilder = new StringBuilder();
//		jsonDataBuilder.append("{\"project\": {\"Name\": \"XDocReport\",\"URL\": \"http://code.google.com/p/xdocreport/\"},");
//		jsonDataBuilder.append("\"developers\": [");
//		jsonDataBuilder.append("{\"Name\": \"我\",");
//		jsonDataBuilder.append("\"Mail\": \"angelo.zerr@gmail.com\",");
//		jsonDataBuilder.append("\"LastName\": \"Angelo\"},");
//		jsonDataBuilder.append("{\"Name\": \"DDD\",");
//		jsonDataBuilder.append("\"Mail\": \"pascal.leclercq@gmail.com\",");
//		jsonDataBuilder.append("\"LastName\": \"Pascal\"}]}");
		
//		jsonDataBuilder.append("{\"sendInfoHotel\": {\"HotelName\": \"我\"}}");
		
//		jsonDataBuilder.append("{\"Guest\":{\"Name\": \"我\",\"First\": \"angelo.zerr@gmail.com\",\"LastName\": \"Angelo\"}}");
		
		jsonDataBuilder.append("{");
		jsonDataBuilder.append("\"hotel\": {\"Name\": \"昆仑石基大酒店\", \"URL\": \"http://www.shijinet.cn/\"},");
		jsonDataBuilder.append("\"guests\": [");
		jsonDataBuilder.append("{");
		jsonDataBuilder.append("\"Name\": \"李卓\",");
		jsonDataBuilder.append("\"Mail\": \"crs_lizhuo@gmail.com\",");
		jsonDataBuilder.append("\"summaryPrice\": \"$999999\"");
		jsonDataBuilder.append("},");
		jsonDataBuilder.append("{");
		jsonDataBuilder.append("\"Name\": \"赵谦\",");
		jsonDataBuilder.append("\"Mail\": \"crs_zhaoqian@gmail.com\",");
		jsonDataBuilder.append("\"summaryPrice\": \"$999999\"");
		jsonDataBuilder.append("}");
		jsonDataBuilder.append("]}");
		String jsonData = jsonDataBuilder.toString();

		JSONObject jsonObject = JSONObject.fromObject(jsonData);
		System.out.println(jsonObject);

		HttpPost httpPost = new HttpPost("http://localhost:8080/kunlun-rest-reporting/rest/report/CRS");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(jsonData,"UTF-8"));
		
		// 使用HttpClient发送POST请求
		HttpClient httpClient = new DefaultHttpClient();
		// 执行发送
		HttpResponse response = httpClient.execute(httpPost);

		// 得到结果码
		int httpStatusCode = response.getStatusLine().getStatusCode();
		System.out.println("httpStatusCode:" + httpStatusCode);
		
		// get file name
		Header header = response.getFirstHeader("Content-Disposition");
		System.out.println("header.getValue():" + header.getValue());
		String fileNameTemp = header.getValue().replace(ATTACHMENT_FILENAME_START, "");
		String fileName = fileNameTemp.replace(ATTACHMENT_FILENAME_END, "");
		//inputstreamtofile(in, new File("E://zhaozhaozhao" + fileName));
		
		// get file
		InputStream in = response.getEntity().getContent();
		byte[] bytes = IOUtils.toByteArray(in);
		FileOutputStream fos = new FileOutputStream("E://zhaozhaozhao" + fileName);
		fos.write(bytes);
		fos.close();
		
		httpClient.getConnectionManager().shutdown();
	}

	public static void inputstreamtofile(InputStream ins, File file) throws Exception {

		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}

	public static final String ATTACHMENT_FILENAME_START = "attachment; filename=\"";

	public static final String ATTACHMENT_FILENAME_END = "\"";
}
