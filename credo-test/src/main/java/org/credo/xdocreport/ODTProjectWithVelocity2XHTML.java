package org.credo.xdocreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.credo.xdocreport.model.Project;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class ODTProjectWithVelocity2XHTML {

	public static void main(String[] args) {
		try {
			// 1) Load ODT file by filling Velocity template engine and cache it to the registry
			//InputStream in = ODTProjectWithVelocity2XHTML.class.getResourceAsStream("ODTProjectWithVelocity.odt");
			InputStream in= new FileInputStream(new File("E:\\temp\\ODTProjectWithVelocity.odt"));
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			// 2) Create context Java model
			IContext context = report.createContext();
			Project project = new Project("XDocReport");
			context.put("project", project);

			// 3) Generate report by merging Java model with the ODT
			OutputStream out = new FileOutputStream(new File("E:\\temp\\ODTProjectWithVelocity_Out.html"));
			// report.process(context, out);
			Options options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM);
			report.convert(context, options, out);
			System.out.println("over");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
	}
}
