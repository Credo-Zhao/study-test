package org.credo.jaxws.study1.simpleRequest.webservicelog;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class LogResolver implements HandlerResolver
{

	@SuppressWarnings("rawtypes")
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo)
	{
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(new LogHandler());
		return handlerChain;
	}

}
