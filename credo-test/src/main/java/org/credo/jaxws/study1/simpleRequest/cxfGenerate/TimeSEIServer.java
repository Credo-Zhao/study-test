package org.credo.jaxws.study1.simpleRequest.cxfGenerate;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService(targetNamespace = "http://study1.jaxws.credo.org/", name = "TimeSEIServer")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TimeSEIServer {

    @WebResult(name = "return", targetNamespace = "http://study1.jaxws.credo.org/", partName = "return")
    @Action(input = "http://study1.jaxws.credo.org/TimeSEIServer/getTimeAsLongRequest", output = "http://study1.jaxws.credo.org/TimeSEIServer/getTimeAsLongResponse")
    @WebMethod
    public long getTimeAsLong();

    @WebResult(name = "return", targetNamespace = "http://study1.jaxws.credo.org/", partName = "return")
    @Action(input = "http://study1.jaxws.credo.org/TimeSEIServer/getTimeAsStringRequest", output = "http://study1.jaxws.credo.org/TimeSEIServer/getTimeAsStringResponse")
    @WebMethod
    public java.lang.String getTimeAsString();
}
