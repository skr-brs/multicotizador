package mx.sekura.multicotizador.Afirme;
import io.vertx.core.json.JsonObject;
import mx.sekura.multicotizador.Constants;

import static mx.sekura.multicotizador.Constants.*;

import javax.xml.soap.*;

public class AfirmeReactor {


    public static MessageFactory messageFactory;

    static {
        try { messageFactory = MessageFactory.newInstance();}
        catch (SOAPException e) { e.printStackTrace(); }
    }

    public static SOAPMessage soapMessage;

    static {
        try { soapMessage = messageFactory.createMessage();}
        catch (SOAPException e) { e.printStackTrace(); }
    }

    public static SOAPPart soapPart = soapMessage.getSOAPPart();

    public SOAPMessage getListMarcas(int idLineaNegocio) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListMarcas = soapBody.addChildElement("getListMarcas" );
        SOAPElement cotIdLineaNegocio = cotListMarcas.addChildElement("idLineaNegocio");
        cotIdLineaNegocio.addTextNode(String.valueOf(idLineaNegocio));
        SOAPElement cotToken = cotListMarcas.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getListModelos(int idLineaNegocio, int idMarca) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListModelos = soapBody.addChildElement("getListModelos" );
        SOAPElement cotIdLineaNegocio = cotListModelos.addChildElement("idLineaNegocio");
        cotIdLineaNegocio.addTextNode(String.valueOf(idLineaNegocio));
        SOAPElement cotIdMarca = cotListModelos.addChildElement("idMarca");
        cotIdMarca.addTextNode(String.valueOf(idMarca));

        SOAPElement cotToken = cotListModelos.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getListEstilos(int idTcMarcaVehiculo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();


        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListModelos = soapBody.addChildElement("getListEstilos" );
        SOAPElement cotIdTcMarcaVehiculo = cotListModelos.addChildElement("idTcMarcaVehiculo");
        cotIdTcMarcaVehiculo.addTextNode(String.valueOf(idTcMarcaVehiculo));
        SOAPElement cotToken = cotListModelos.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getBuscarEstilo(int idTcMarcaVehiculo, int modelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        JsonObject json = new JsonObject();
        json.put("idMarca", idTcMarcaVehiculo);
        json.put("modelo", modelo);
        json.put("idLineaNegocio", ID_LINEA_NEGOCIO);
        json.put("descripcion", "");

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotBuscarEstilo = soapBody.addChildElement("buscarEstilo" );
        SOAPElement codJson = cotBuscarEstilo.addChildElement("json");
        codJson.addTextNode(String.valueOf(json));
        SOAPElement cotToken = cotBuscarEstilo.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListProductos() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListProductos = soapBody.addChildElement("getListProductos" );
        SOAPElement cotIdNegocio = cotListProductos.addChildElement("idNegocio");
        cotIdNegocio.addTextNode(ID_NEGOCIO);
        SOAPElement cotToken = cotListProductos.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListTiposPoliza() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListTiposPoliza = soapBody.addChildElement("getListTiposPoliza" );
        SOAPElement cotIdToNegProducto = cotListTiposPoliza.addChildElement("idToNegProducto");
        cotIdToNegProducto.addTextNode(ID_PRODUCTO);
        SOAPElement cotToken = cotListTiposPoliza.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListLineasNegocio() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListLineasNegocio = soapBody.addChildElement("getListLineasNegocio" );
        SOAPElement cotIdToNegTipoPoliza = cotListLineasNegocio.addChildElement("idToNegTipoPoliza");
        cotIdToNegTipoPoliza.addTextNode(ID_TIPO_POLIZA);
        SOAPElement cotToken = cotListLineasNegocio.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListPaquetes(int idLineaNegocio) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListPaquetes = soapBody.addChildElement("getListPaquetes" );
        SOAPElement cotIdLineaNegocio = cotListPaquetes.addChildElement("idLineaNegocio");
        cotIdLineaNegocio.addTextNode(String.valueOf(idLineaNegocio));
        SOAPElement cotToken = cotListPaquetes.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListFormasPago(int idTipoPoliza) throws Exception {

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListFormasPago = soapBody.addChildElement("getListFormasDePago" );
        SOAPElement cotIdTipoPoliza = cotListFormasPago.addChildElement("idTipoPoliza");
        cotIdTipoPoliza.addTextNode(String.valueOf(idTipoPoliza));
        SOAPElement cotToken = cotListFormasPago.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListEstados() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListEstados = soapBody.addChildElement("getListEstados" );
        SOAPElement cotNegocio = cotListEstados.addChildElement("idNegocio");
        cotNegocio.addTextNode(ID_NEGOCIO);
        SOAPElement cotToken = cotListEstados.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getListMunicipios(String idEstado) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotListMunicipios = soapBody.addChildElement("getListMunicipios" );
        SOAPElement cotIdEstado = cotListMunicipios.addChildElement("idEstado");
        cotIdEstado.addTextNode(idEstado);
        SOAPElement cotToken = cotListMunicipios.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getImprimirCotizacion() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();
        String json = "{\"idToCotizacion\":14542933,\"caratula\":true,\"todosLosIncisos\":false,\"incisoInicial\":1,\"incisoFinal\":1}";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE_DECLARATION, SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement cotImprimirCotizacion= soapBody.addChildElement("imprimirCotizacion" );
        SOAPElement cotJson = cotImprimirCotizacion.addChildElement("json");
        cotJson.addTextNode(json);
        SOAPElement cotToken = cotImprimirCotizacion.addChildElement("token");
        cotToken.addTextNode(TOKEN);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(SOAP_HEADER, SERVER_URI);
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;

    }

}
