package org.credo.apache.httpclient;


import java.io.File;

/**
 * 测试结果,ODT,ODS,ODP,DOC,PPT,XLS,RTF转换PDF无问题.不支持DOCX.
 * 
 * @author Credo
 */
public class TestJodConvert {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Test for odt to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_ODT.odt");
		// File outputFile = new File("E:\\jodconvert\\Test_ODT_Out.pdf");

		// Test for ods to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_ODS.ods");
		// File outputFile = new File("E:\\jodconvert\\Test_ODS_Out.pdf");

		// Test for odp to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_ODP.odp");
		// File outputFile = new File("E:\\jodconvert\\Test_ODP_Out.pdf");

		// Test for rtf to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_RTF.rtf");
		// File outputFile = new File("E:\\jodconvert\\Test_RTF_Out.pdf");

		// Test for doc to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_DOC.doc");
		// File outputFile = new File("E:\\jodconvert\\Test_DOC_Out.pdf");

		/**
		 * Test for docx to pdf,happend error
		 * java.lang.IllegalArgumentException: unknown document format for file:
		 */
		// File inputFile = new File("E:\\jodconvert\\Test_DOCX.docx");
		// File outputFile = new File("E:\\jodconvert\\Test_DOCX_Out.pdf");

		// Test for odt to pdf
		File inputFile = new File("E:\\jodconvert\\Test_PPT.ppt");
		File outputFile = new File("E:\\jodconvert\\Test_PPT_Out.pdf");

		// Test for odt to pdf
		// File inputFile = new File("E:\\jodconvert\\Test_XLS.xls");
		// File outputFile = new File("E:\\jodconvert\\Test_XLS_Out.pdf");

		// OpenOfficeConnection connection = new
		// SocketOpenOfficeConnection(8100);
		try {
			// connection.connect();
			// DocumentConverter converter = new
			// OpenOfficeDocumentConverter(connection);
			// converter.convert(inputFile, outputFile);
			// return outputFile;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// if (connection != null) {
				// connection.disconnect();
				// connection = null;
				// }
			} catch (Exception e) {
			}
		}
		// return null;

	}
}
