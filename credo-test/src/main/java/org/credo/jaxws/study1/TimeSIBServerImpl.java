package org.credo.jaxws.study1;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="org.credo.jaxws.study1.TimeSEIServer")
public class TimeSIBServerImpl implements TimeSEIServer
{

	@Override
	public String getTimeAsString()
	{
		return new Date().toString();
	}

	@Override
	public Long getTimeAsLong()
	{
		return new Date().getTime();
	}

}
