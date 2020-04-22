package mx.sekura.multicotizador.Qualitas;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;


public class QualitasSOAPConnection {

    SOAPConnection createSOAPConnection() throws UnsupportedOperationException, SOAPException {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        return soapConnectionFactory.createConnection();

    }
}
