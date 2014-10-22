package org.credo.itext;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfContentByte;

public class PdfBarcode
{

	public static void main(String[] args)
	{
		String myString = "http://www.google.com";  
		  
		Barcode128 code128 = new Barcode128();  
		code128.setCode(myString.trim());  
		code128.setCodeType(Barcode128.CODE128);  
		Image code128Image = code128.createImageWithBarcode(new PdfContentByte(null), null, null);  
		code128Image.setAbsolutePosition(10,700);  
		code128Image.scalePercent(125);  
	}

}
