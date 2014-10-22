package org.credo.apache.pdfbox;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.encoding.EncodingManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.PDFMergerUtility;

import com.lowagie.text.pdf.codec.Base64.OutputStream;

import fr.opensagres.xdocreport.core.io.internal.ByteArrayOutputStream;

public class t2
{

	public static void main(String[] args) throws Exception
	{
		// Create a new empty document
		PDDocument document = new PDDocument();

		// Create a new blank page and add it to the document
		PDPage page = new PDPage();
		document.addPage(page);

		// create file
		File workingDir = new File(FileUtils.getTempDirectory(), RandomStringUtils.randomAlphanumeric(16));
		System.out.println(workingDir);
		if (!workingDir.exists())
		{
			workingDir.mkdirs();
		}
		String fileName = "test.pdf";
		File sourceFile = new File(workingDir, fileName);

		InputStream is = new ByteArrayInputStream("打印出PDF的dispatchId".getBytes());
		document = PDDocument.load(is);
		// Save the newly created document
		document.save(sourceFile);
		
		PDFMergerUtility pdfMergeUtility = new PDFMergerUtility();
		
		// finally make sure that the document is properly
		// closed.
		document.close();

	}

}
