package org.credo.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestReportRestUsedFormParam {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		// 准备数据
		String outFormat = "";
		String outFileName = "zhaoqian.odt";

		String sourceFileFormat = "ODFDOM";
		File sourceFile = new File("E:\\temp\\ODTProjectWithVelocityList.odt");

		StringBuilder jsonDataBuilder = new StringBuilder();
		jsonDataBuilder.append("{\"project\": {\"Name\": \"XDocReport\",\"URL\": \"http://code.google.com/p/xdocreport/\"},");
		jsonDataBuilder.append("\"developers\": [");
		jsonDataBuilder.append("{\"Name\": \"我\",");
		jsonDataBuilder.append("\"Mail\": \"angelo.zerr@gmail.com\",");
		jsonDataBuilder.append("\"LastName\": \"Angelo\"},");
		jsonDataBuilder.append("{\"Name\": \"DDD\",");
		jsonDataBuilder.append("\"Mail\": \"pascal.leclercq@gmail.com\",");
		jsonDataBuilder.append("\"LastName\": \"Pascal\"}]}");
		String jsonData = jsonDataBuilder.toString();

		StringBuilder xmlData = new StringBuilder();
		xmlData.append("<fields>");
		xmlData.append("<field name=\"project.Name\" list=\"false\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.Name\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.LastName\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.Mail\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("</fields>");
		String xmlFieldsMetadata = xmlData.toString();

		// 使用HttpClient发送POST请求
		HttpClient httpClient = new DefaultHttpClient();

		// 转义json中的字符
		String urlJsonTemp = jsonData.replace("\"", "%22");
		String urlJsonTemp2 = urlJsonTemp.replace("{", "%7B");
		String urlJsonTemp3 = urlJsonTemp2.replace("}", "%7D");
		String urlJsonTemp4 = urlJsonTemp3.replace("[", "%5B");
		String urlJsonTemp5 = urlJsonTemp4.replace("]", "%5D");
		String urlJson = urlJsonTemp5.replace(" ", "%20");

		HttpPost httpPost = new HttpPost("http://localhost:8080/kunlun-rest-reporting/rest/report/post?json=" + urlJson);
		httpPost.setHeader("Encoding", "UTF-8");
		httpPost.setHeader("Accept-Charset", "UTF-8");

		// 参数设置，使用easyRest的MultipartEntity
		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		// entity.addPart("outFormat", new StringBody(outFormat,
		// CharsetUtil.getCharset("UTF-8")));
		// entity.addPart("outFileName", new StringBody(outFileName,
		// CharsetUtil.getCharset("UTF-8")));
		//
		// entity.addPart("data", new StringBody(jsonData,
		// CharsetUtil.getCharset("UTF-8")));
		// entity.addPart("metadata", new StringBody(xmlFieldsMetadata,
		// CharsetUtil.getCharset("UTF-8")));
		//
		// entity.addPart("outFormatVia", new StringBody(sourceFileFormat,
		// CharsetUtil.getCharset("UTF-8")));
		FileBody fileBody = new FileBody(sourceFile, "application/octect-stream");
		entity.addPart("templateDocument", fileBody);

		httpPost.setEntity(entity);

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
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}

	public static final String ATTACHMENT_FILENAME_START = "attachment; filename=\"";
	public static final String ATTACHMENT_FILENAME_END = "\"";

}
