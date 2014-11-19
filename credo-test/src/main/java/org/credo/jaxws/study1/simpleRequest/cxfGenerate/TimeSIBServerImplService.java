package org.credo.jaxws.study1.simpleRequest.cxfGenerate;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

@WebServiceClient(name = "TimeSIBServerImplService", 
                  wsdlLocation = "http://127.0.0.1:9876/ts?wsdl",
                  targetNamespace = "http://study1.jaxws.credo.org/") 
public class TimeSIBServerImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://study1.jaxws.credo.org/", "TimeSIBServerImplService");
    public final static QName TimeSIBServerImplPort = new QName("http://study1.jaxws.credo.org/", "TimeSIBServerImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:9876/ts?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TimeSIBServerImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:9876/ts?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TimeSIBServerImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TimeSIBServerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TimeSIBServerImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TimeSIBServerImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TimeSIBServerImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TimeSIBServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns TimeSEIServer
     */
    @WebEndpoint(name = "TimeSIBServerImplPort")
    public TimeSEIServer getTimeSIBServerImplPort() {
        return super.getPort(TimeSIBServerImplPort, TimeSEIServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TimeSEIServer
     */
    @WebEndpoint(name = "TimeSIBServerImplPort")
    public TimeSEIServer getTimeSIBServerImplPort(WebServiceFeature... features) {
        return super.getPort(TimeSIBServerImplPort, TimeSEIServer.class, features);
    }

}
