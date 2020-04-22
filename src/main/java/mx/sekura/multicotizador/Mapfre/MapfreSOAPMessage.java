package mx.sekura.multicotizador.Mapfre;

import io.vertx.ext.web.RoutingContext;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static mx.sekura.multicotizador.Constants.MAPFRE_SOAP_ENDPOINT_URI;


public class MapfreSOAPMessage {

    private MapfreReactor mapfreReactor = new MapfreReactor();
    private MapfreSOAPConnection mapfreSOAPConnection = new MapfreSOAPConnection();
    private SOAPConnection soapConnection;

    public MapfreSOAPMessage() {
        try {
            this.soapConnection = mapfreSOAPConnection.createSOAPConnection();
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

    public SOAPMessage getMessageWSTWRamos() throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWRamos(), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWEstados() throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWEstados(), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWPoblaciones(Integer codEstado) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWPoblaciones(codEstado), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWMarcas(Integer anioFabrica) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWMarcas(anioFabrica), MAPFRE_SOAP_ENDPOINT_URI);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);


        return soapResponse;
    }

    public SOAPMessage getMessageWSTWModelos(Integer anioFabrica, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWModelos(anioFabrica, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWCotizacionRC(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWCotizacionRC(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWCotizacionLimitado(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWCotizacionLimitado(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWCotizacionAmplio(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWCotizacionAmplio(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWEmiteAmplio(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWEmiteAmplio(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWEmiteLimitado(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWEmiteLimitado(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageWSTWEmiteRC(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(mapfreReactor.getWSTWEmiteRC(codPoblacion, codEstado, codFraccPago, codAnioFabrica, codMarca, codModelo), MAPFRE_SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }


}
