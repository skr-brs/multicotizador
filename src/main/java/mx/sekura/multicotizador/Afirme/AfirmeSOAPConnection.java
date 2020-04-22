package mx.sekura.multicotizador.Afirme;

import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPConnection;


public class AfirmeSOAPConnection {

    SOAPConnection createSOAPConnection() throws UnsupportedOperationException, SOAPException {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        return soapConnectionFactory.createConnection();

    }
}
