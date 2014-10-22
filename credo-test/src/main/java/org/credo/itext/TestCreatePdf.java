package org.credo.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TestCreatePdf
{

	public static void main(String[] args) throws Exception
	{
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, new FileOutputStream("d:/test/test.pdf"));
		doc.open();

		// 标题字体
		BaseFont bfTitle = BaseFont.createFont("C:\\Windows\\Fonts\\simfang.ttf", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font titleFont = new Font(bfTitle, 18, Font.NORMAL);

		// 内容字体
		BaseFont bfComic = BaseFont.createFont("C:\\Windows\\Fonts\\simfang.ttf", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font font = new Font(bfComic, 9, Font.NORMAL);

		Paragraph titleP = new Paragraph("儿童信息 Child Information\n\n", titleFont);
		titleP.setAlignment(titleP.ALIGN_CENTER);
		doc.add(titleP);
		// 生成4列的表格
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setWidthPercentage(100);
		table.addCell(new Paragraph("Children-id", font));
		PdfPCell cell = new PdfPCell(new Paragraph("09140800002", font));
		cell.setColspan(3);
		table.addCell(cell);
		// 添加第一行
		table.addCell(new Paragraph("Name(CN)", font));
		table.addCell(new Paragraph("党宁生", font));
		table.addCell(new Paragraph("Name(EN)", font));
		table.addCell(new Paragraph("DANG NING SHENG", font));

		// 添加第二行
		table.addCell(new Paragraph("Sex(CN)", font));
		table.addCell(new Paragraph("男", font));
		table.addCell(new Paragraph("Sex(EN)", font));
		table.addCell(new Paragraph("MALE", font));
		// 添加第8行
		table.addCell(new Paragraph("Note", font));
		cell = new PdfPCell(new Paragraph("儿童资料", font));
		cell.setColspan(3);
		table.addCell(cell);

		// 添加第9行
//		table.addCell(new Paragraph("Pictures", font));
//		Image photo = Image.getInstance("c:/test/pdf/1246588678828.jpg");
//		cell = new PdfPCell(photo);
//		cell.setColspan(3);
//		table.addCell(cell);

		for (PdfPRow row : (ArrayList<PdfPRow>) table.getRows())
		{
			for (PdfPCell cells : row.getCells())
			{
				if (cells != null)
				{
					cells.setPadding(10.0f);
				}
			}
		}

		doc.add(table);
		doc.newPage();

		// 插入图片
		doc.newPage();
		Image image1 = Image.getInstance("c:/test/pdf/1246588315281.jpg");
		image1.setAlignment(image1.ALIGN_CENTER);
		image1.scaleToFit(PageSize.A4.getHeight(), PageSize.A4.getWidth());
		doc.add(image1);

		doc.close();

	}

}
