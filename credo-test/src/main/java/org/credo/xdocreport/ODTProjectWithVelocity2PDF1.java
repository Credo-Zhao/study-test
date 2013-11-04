package org.credo.xdocreport;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.odftoolkit.odfdom.converter.pdf.ITextFontRegistry;
import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class ODTProjectWithVelocity2PDF1 {

	public static void main(String[] args) throws Exception {
		try {
			// 1) 加载ODT文件到Velocity模板引擎以及缓存中.并进行注册.
			InputStream in = new FileInputStream(new File("E:\\temp\\shiji\\1_Out.odt"));
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			// 2) Create context Java model,"aaa"可以是变量等
			IContext context = report.createContext();
			context.put("project", "aaa");
			
			//额外的步骤,生成实际内容的ODT
			OutputStream outODT = new FileOutputStream(new File("E:\\temp\\shiji\\ODTHelloWordWithVelocity_Out.odt"));
			report.process(context, outODT);
			OdfTextDocument document = OdfTextDocument.loadDocument(new FileInputStream(new File("E:\\temp\\shiji\\ODTHelloWordWithVelocity_Out.odt")));

			// 3) 通过合并ODT Java模型生成PDF
			OutputStream out = new FileOutputStream(new File("E:\\temp\\shiji\\ODTProjectWithVelocity_Out.pdf"));
			PdfOptions options = PdfOptions.create();

			options.fontProvider(new IFontProvider() {

				public Font getFont(String familyName, String encoding, float size, int style, Color color) {
					try
					{
						System.out.println("familyName:"+familyName);
						if ( familyName.equals("Arial") )
						{
							// C:/Windows/Fonts/msyh.ttf
							BaseFont bfChinese = BaseFont.createFont("E:/font/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
							Font fontChinese = new Font(bfChinese, size, style, color);
							if ( familyName != null )
								fontChinese.setFamily(familyName);
							return fontChinese;
						} else
							return ITextFontRegistry.getRegistry().getFont(familyName, encoding, size, style, color);
					}
					catch ( Throwable e )
					{
						e.printStackTrace();
						return ITextFontRegistry.getRegistry().getFont(familyName, encoding, size, style, color);
					}
				}
			});
			PdfConverter.getInstance().convert(document, out, options);
			System.out.println("Over");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
	}
}
