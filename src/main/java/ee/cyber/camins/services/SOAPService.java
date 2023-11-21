package ee.cyber.camins.services;

import eu.x_road.xsd.identifiers.XRoadClientIdentifierType;
import eu.x_road.xsd.identifiers.XRoadServiceIdentifierType;
import eu.x_road.xsd.xroad.RequestHash;
import io.quarkus.logging.Log;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(
        targetNamespace = "http://services.camins.cyber.ee/",
        serviceName = "testService",
        wsdlLocation = "/wsdl/test.wsdl",
        portName = "testPort"
)
public class SOAPService implements TestPortType {

    @Override
    public String test(
            String query,
            Holder<XRoadClientIdentifierType> client,
            Holder<XRoadServiceIdentifierType> service,
            Holder<String> id, Holder<String> userId,
            Holder<String> issue,
            Holder<String> protocolVersion,
            Holder<RequestHash> requestHash) {
        Log.info(query);
        return "Hello SOAP!";
    }

    @Override
    public String anotherTest(
            String query,
            Holder<XRoadClientIdentifierType> client,
            Holder<XRoadServiceIdentifierType> service,
            Holder<String> id,
            Holder<String> userId,
            Holder<String> issue,
            Holder<String> protocolVersion,
            Holder<RequestHash> requestHash) {
        Log.info(query);
        return "Hello another SOAP!";
    }
}
