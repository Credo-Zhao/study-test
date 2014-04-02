package org.credo.xpath;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.xml.sax.InputSource;


public class xpath {
	public static void main(String[] args) throws IOException, XPathExpressionException {
		
		InputStream in = new FileInputStream("aa.xml");
		byte[] data = IOUtils.toByteArray(in);
		ByteArrayInputStream bin = new ByteArrayInputStream(data);
		InputSource source = new InputSource(bin);
		bin.mark(0);
		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(new NamespaceContext() {

			@Override
			public String getNamespaceURI(String prefix) {

				return "http://tempuri.org/";
			}

			@Override
			public String getPrefix(String namespaceURI) {

				// do nothing
				return ":";
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Iterator getPrefixes(String namespaceURI) {

				// do nothing
				return null;
			}
		});
		String result=xpath.evaluate("//:MongateCsSpSendSmsNewResponse/:MongateCsSpSendSmsNewResult", source);
		System.out.println("result:"+result);
	}
}
