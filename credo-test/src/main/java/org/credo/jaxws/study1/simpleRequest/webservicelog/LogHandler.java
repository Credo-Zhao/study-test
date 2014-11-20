package org.credo.jaxws.study1.simpleRequest.webservicelog;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LogHandler implements SOAPHandler<SOAPMessageContext>
{

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.
	 * MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context)
	{

		SOAPMessage msg = context.getMessage();
		MimeHeaders mimeHeaders=msg.getMimeHeaders();
		Iterator iter = mimeHeaders.getAllHeaders();
		while (iter.hasNext())
		{
			 MimeHeader mimeHeader = (MimeHeader)iter.next();             
			 String headerName = mimeHeader.getName(); 
			 System.out.println(headerName);
			 String[] headerValues = mimeHeaders.getHeader(headerName);     
			 System.out.println("headerValues:"+headerValues.toString());
			 for(String str:headerValues) {
				 System.out.println(str);
			 }
		}
		try
		{
			msg.writeTo(System.out);
			System.out.println();
		} catch (SOAPException ex)
		{
			ex.printStackTrace();
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext
	 * )
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context)
	{

		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context)
	{

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders()
	{

		// TODO Auto-generated method stub
		return null;
	}

}
