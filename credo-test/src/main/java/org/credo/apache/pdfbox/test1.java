package org.credo.apache.pdfbox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.encoding.EncodingManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.PDFTextStripper;

import com.lowagie.text.pdf.Barcode;

public class test1
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

		// input some filed simfang.ttf
		PDFont font = PDType1Font.TIMES_ITALIC;
		//PDFont font = PDTrueTypeFont.loadTTF(document, "C:\\Windows\\Fonts\\simfang.ttf");
		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(100, 700);
		contentStream.drawString("派单ID: G1234567890.GOGOGO");
		contentStream.endText();
		// Make sure that the content stream is closed:
		contentStream.close();

//		PDPageContentStream contentStream2 = new PDPageContentStream(document, page);
//		contentStream2.beginText();
//		contentStream2.setFont(font, 12);
//		contentStream2.moveTextPositionByAmount(200, 800);
//		contentStream2.drawString("SerailNumber: ASDASDASDAS");
//		contentStream2.endText();
//		contentStream2.close();

		// Save the newly created document
		document.save(sourceFile);
		// finally make sure that the document is properly
		// closed.
		document.close();

	}

}
