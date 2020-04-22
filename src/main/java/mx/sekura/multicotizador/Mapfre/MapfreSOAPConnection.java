package mx.sekura.multicotizador.Mapfre;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;


public class MapfreSOAPConnection {

    SOAPConnection createSOAPConnection() throws UnsupportedOperationException, SOAPException {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        return soapConnectionFactory.createConnection();

    }
}
