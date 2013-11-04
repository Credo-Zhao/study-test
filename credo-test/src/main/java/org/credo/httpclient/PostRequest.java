package org.credo.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class PostRequest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		PostRequest postRequest = new PostRequest();

		Map<String, String> params = new HashMap<String, String>();
		params.put("outFileName", "postReportRestFile");
		params.put("outFormatVia", "ODFDOM");
		params.put("outFormat", "odt");
		StringBuilder jasonData = new StringBuilder();
		jasonData.append("{\"project\": {\"Name\": \"XDocReport\", \"URL\": \"http://code.google.com/p/xdocreport/\"},");
		jasonData.append("\"developers\": [");
		jasonData.append("{\"Name\": \"ZERR\",");
		jasonData.append("\"Mail\": \"angelo.zerr@gmail.com\",");
		jasonData.append("\"LastName\": \"Angelo\"},");
		jasonData.append("{\"Name\": \"Leclercq\",");
		jasonData.append("\"Mail\": \"pascal.leclercq@gmail.com\",");
		jasonData.append("\"LastName\": \"Pascal\"}]}");
		params.put("jasonData", jasonData.toString());
		StringBuilder xmlData = new StringBuilder();
		xmlData.append("<fields>");
		xmlData.append("<field name=\"project.Name\" list=\"false\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.Name\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.LastName\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("<field name=\"developers.Mail\" list=\"true\" imageName=\"\" syntaxKind=\"\" />");
		xmlData.append("</fields>");
		params.put("xmlFieldsMetadata", xmlData.toString());

		File file = new File("E:\\temp\\ODTProjectWithVelocityList.odt");

		InputStreamEntity reqEntity = new InputStreamEntity(
				new FileInputStream(file), -1);
		reqEntity.setContentType("binary/octet-stream");
		reqEntity.setChunked(true);

		//http://localhost:8080/kunlun-crs-template/rest/report/post
		//http://localhost:8080/RestTest/rest/report/post
		postRequest.sendHttpPostRequest(
				"http://localhost:8080/kunlun-crs-template/rest/report/post", reqEntity,
				params);
	}

	/**
	 * @url rest服务的URL链接
	 * @bayteArray 转换好的要POST传输的数据
	 * @params 预留的参数MAP集
	 * @return 正确发送并响应正确信息返回true,否则false
	 */
	public static boolean sendHttpPostRequest(String url, InputStreamEntity reqEntity,
			Map<String, String> params) throws Exception {

		HttpClient httpClient = new DefaultHttpClient();
		int httpStatusCode = 400;
		try {
			HttpPost httpPost = new HttpPost(url);
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			File file = new File("E:\\temp\\ODTProjectWithVelocityList.odt");
			FileBody fileBody = new FileBody(file, "application/octect-stream") ;
			entity.addPart("odtMessage", fileBody);
			if (null != params) {
				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					entity.addPart(key, new StringBody(params.get(key)));
				}
			}
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			System.out.println("response:"+response);
			httpStatusCode = response.getStatusLine().getStatusCode();
			System.out.println("httpStatusCode:"+httpStatusCode);
			InputStream in=response.getEntity().getContent();
			inputstreamtofile(in,new File("D://result.pdf"));
			if (httpStatusCode != 200)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return true;
	}
	
	public static void inputstreamtofile(InputStream ins, File file) throws Exception {
		OutputStream os = new FileOutputStream("D://result.pdf");
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}
}
