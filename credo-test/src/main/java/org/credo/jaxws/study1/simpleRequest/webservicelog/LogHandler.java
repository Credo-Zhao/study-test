package org.credo.jaxws.study1.simpleRequest.webservicelog;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
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
