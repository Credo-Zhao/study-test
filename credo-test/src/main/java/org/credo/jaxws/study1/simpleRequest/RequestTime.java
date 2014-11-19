package org.credo.jaxws.study1.simpleRequest;

import java.net.MalformedURLException;
import java.net.URL;

import org.credo.jaxws.study1.simpleRequest.cxfGenerate.TimeSEIServer;
import org.credo.jaxws.study1.simpleRequest.cxfGenerate.TimeSIBServerImplService;
import org.credo.jaxws.study1.simpleRequest.webservicelog.LogResolver;

public class RequestTime
{

	public static void main(String[] args) throws MalformedURLException
	{
		String wsdl="http://127.0.0.1:9876/ts?wsdl";
		URL url=new  URL(wsdl);
		TimeSIBServerImplService service= new TimeSIBServerImplService(url);
		service.setHandlerResolver(new LogResolver());
		TimeSEIServer timeSEIServer = service.getTimeSIBServerImplPort();
		System.out.println("timeSEIServer.getTimeAsLong():"+timeSEIServer.getTimeAsLong());
		System.out.println("timeSEIServer.getTimeAsString():"+timeSEIServer.getTimeAsString());
	}

}
