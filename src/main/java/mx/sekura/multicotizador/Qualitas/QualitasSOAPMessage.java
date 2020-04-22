package mx.sekura.multicotizador.Qualitas;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.vertx.core.json.JsonObject;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static mx.sekura.multicotizador.Constants.QUALITAS_SOAP_ENDPOINT_URI;
import static mx.sekura.multicotizador.Constants.SOAP_ENDPOINT_URI;


public class QualitasSOAPMessage {

    private QualitasReactor qualitasReactor = new QualitasReactor();
    private QualitasSOAPConnection qualitasSOAPConnection = new QualitasSOAPConnection();
    private SOAPConnection soapConnection;

    public QualitasSOAPMessage() {
        try {
            this.soapConnection = qualitasSOAPConnection.createSOAPConnection();
        } catch (SOAPException e) {
            e.printStackTrace();
        }

    }

    public void printMessage(SOAPMessage message) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            message.writeTo(out);
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SOAPMessage getMessageListaMarcas() throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(qualitasReactor.getListaMarcas(), QUALITAS_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListaTarifas(String marca) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(qualitasReactor.getListaTarifas(marca), QUALITAS_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

}
