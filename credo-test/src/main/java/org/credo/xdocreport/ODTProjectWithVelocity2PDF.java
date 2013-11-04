package org.credo.xdocreport;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.credo.xdocreport.model.Project;
import org.odftoolkit.odfdom.converter.pdf.ITextFontRegistry;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class ODTProjectWithVelocity2PDF {

	public static void main(String[] args) throws DocumentException {
		try {
			// 1) Load ODT file by filling Velocity template engine and cache it
			// to the registry
			InputStream in = new FileInputStream(new File("E:\\temp\\ODTProjectWithVelocity.odt"));
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			Project project = new Project("天气");
			context.put("project", project);

			// 3) Generate report by merging Java model with the ODT
			OutputStream out = new FileOutputStream(new File("E:\\temp\\ODTProjectWithVelocity_Out.pdf"));
			// ODFDOM-->ODT XWPF--->DOCX
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM).subOptions(
					PdfOptions.create().fontProvider(new IFontProvider() {

				public Font getFont(String familyName, String encoding, float size, int style, Color color) {
					System.out.println("familyName:"+familyName);
					System.out.println("encoding:"+encoding);
					System.out.println("size:"+size);
					System.out.println("style:"+style);
					System.out.println("color:"+color);
					try {
						// STSong-Light C:/Windows/Fonts/arialuni.ttf   UniGB-UCS2-H BaseFont.IDENTITY_H
						BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
						Font fontChinese = new Font(bfChinese, size, style, color);
						if (familyName != null)
							fontChinese.setFamily(familyName);
						return fontChinese;
					} catch (Throwable e) {
						e.printStackTrace();
						return ITextFontRegistry.getRegistry().getFont(familyName, encoding, size, style, color);
					}
				}
			}));

			report.convert(context, options, out);
			System.out.println("Over");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
	}
}
