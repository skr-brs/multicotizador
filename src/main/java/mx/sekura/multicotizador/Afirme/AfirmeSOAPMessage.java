package mx.sekura.multicotizador.Afirme;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static mx.sekura.multicotizador.Constants.SOAP_ENDPOINT_URI;


public class AfirmeSOAPMessage {

    private AfirmeReactor afirmeReactor = new AfirmeReactor();
    private AfirmeSOAPConnection afirmeSOAPConnection = new AfirmeSOAPConnection();
    private SOAPConnection soapConnection;

    public AfirmeSOAPMessage() {
        try {
            this.soapConnection = afirmeSOAPConnection.createSOAPConnection();
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

    public SOAPMessage getMessageListMarcas(int idLineaNegocio) throws SOAPException{
        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListMarcas(idLineaNegocio), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListModelos(int idLineaNegocio, int idMarca) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListModelos(idLineaNegocio, idMarca), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }


    public SOAPMessage getMessageListEstilos(int idTcMarcaVehiculo) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListEstilos(idTcMarcaVehiculo), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getBuscarEstilo(int idTcMarcaVehiculo, int idModelo) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getBuscarEstilo(idTcMarcaVehiculo, idModelo), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListProductos() throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListProductos(), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListTiposPoliza() throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListTiposPoliza(), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListLineasNegocio() throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListLineasNegocio(), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListPaquetes(int idLineaNegocio) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListPaquetes(idLineaNegocio), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListFormasPago(int idTipoPoliza) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListFormasPago(idTipoPoliza), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListEstados() throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListEstados(), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageListMunicipios(String idEstado) throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getListMunicipios(idEstado), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }

    public SOAPMessage getMessageImprimirCotizacion() throws SOAPException{

        SOAPMessage soapResponse = null;

        try {
            soapResponse = soapConnection.call(afirmeReactor.getImprimirCotizacion(), SOAP_ENDPOINT_URI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" \n Response SOAP Message : \n"+ soapResponse.getSOAPBody().getTextContent());
        printMessage(soapResponse);

        return soapResponse;
    }



}
