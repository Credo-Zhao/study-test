package org.credo.apache.pdfbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PageExtractor;
import org.apache.pdfbox.util.Splitter;

public class PdfUtil
{

	private final PDDocument document;

	private InputStream pdfInputStream;

	public PdfUtil(InputStream pdfInputStream) throws IOException
	{

		this.pdfInputStream = pdfInputStream;
		document = PDDocument.load(pdfInputStream);
	}

	public PdfUtil(byte[] data) throws IOException
	{

		this.pdfInputStream = new ByteArrayInputStream(data);
		document = PDDocument.load(pdfInputStream);
	}

	public void setPdfInputStream(InputStream pdfInputStream)
	{

		this.pdfInputStream = pdfInputStream;
	}

	public InputStream getPdfInputStream()
	{

		return pdfInputStream;
	}

	public int getPageCount()
	{

		return document.getNumberOfPages();
	}

	/**
	 * split pdf by page 1
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<PDDocument> split() throws IOException
	{

		Splitter sp = new Splitter();
		return sp.split(document);
	}

	public String convertToText(boolean sort, PDDocument pdDocument) throws IOException
	{

		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		pdfTextStripper.setSortByPosition(sort);
		return pdfTextStripper.getText(pdDocument);
	}

	public String convertToText() throws IOException
	{

		return convertToText(true, 1, 1);
	}

	public String convertToText(boolean sort, int startPage, int endPage) throws IOException
	{

		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		pdfTextStripper.setSortByPosition(sort);
		pdfTextStripper.setStartPage(startPage);
		pdfTextStripper.setEndPage(endPage);
		return pdfTextStripper.getText(document);
	}

	public void encrypt(String ownerPassword, String userPassword) throws CryptographyException, IOException
	{

		document.encrypt(ownerPassword, userPassword);
	}

	public void decrypt(String password) throws CryptographyException, IOException, InvalidPasswordException
	{

		document.decrypt(password);
	}

	public byte[] save() throws COSVisitorException, IOException
	{

		return save(document);
	}

	private static byte[] save(PDDocument pddocument) throws COSVisitorException, IOException
	{

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		pddocument.save(outputStream);
		return outputStream.toByteArray();
	}

	public byte[] extractor(int startPage, int endPage) throws COSVisitorException, IOException
	{

		PageExtractor pageExtractor = new PageExtractor(document);
		pageExtractor.setStartPage(startPage);
		pageExtractor.setEndPage(endPage);
		PDDocument spDocument = pageExtractor.extract();
		byte[] data = save(spDocument);
		spDocument.close();
		return data;
	}

	public PDDocumentInformation getDocumentInformation()
	{

		return document.getDocumentInformation();
	}

	public void close()
	{

		if (document != null)
		{
			try
			{
				document.close();
			} catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * close pdfDocument
	 * 
	 * @param pdDocuments
	 */
	public void closeDocuments(List<PDDocument> pdDocuments)
	{

		for (PDDocument pdDocument : pdDocuments)
		{
			try
			{
				pdDocument.close();
			} catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}

	}

	/**
	 * merge util
	 * 
	 * @param sources
	 * @param out
	 * @throws Exception
	 */
	public static void merge(List<InputStream> sources, OutputStream out) throws Exception
	{

		PDFMergerUtility pdfMergeUtility = new PDFMergerUtility();
		pdfMergeUtility.addSources(sources);
		pdfMergeUtility.setDestinationStream(out);
		pdfMergeUtility.mergeDocuments();
	}

}
