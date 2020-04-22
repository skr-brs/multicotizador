package mx.sekura.multicotizador.Qualitas;

import javax.xml.soap.*;

import static mx.sekura.multicotizador.Constants.*;

public class QualitasReactor {


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

    public SOAPMessage getListaMarcas() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(QUALITAS_NAMESPACE_DECLARATION, QUALITAS_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement qbcListaMarcas = soapBody.addChildElement("listaMarcas", QUALITAS_NAMESPACE_DECLARATION );
        SOAPElement cotIdLineaNegocio = qbcListaMarcas.addChildElement("cUsuario", QUALITAS_NAMESPACE_DECLARATION);
        cotIdLineaNegocio.addTextNode(QUALITAS_USUARIO);
        SOAPElement cotToken = qbcListaMarcas.addChildElement("cTarifa", QUALITAS_NAMESPACE_DECLARATION);
        cotToken.addTextNode(QUALITAS_TARIFA);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(QUALITAS_SOAP_HEADER, QUALITAS_SERVER_URI + "/listaMarcas");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getListaTarifas(String marca) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(QUALITAS_NAMESPACE_DECLARATION, QUALITAS_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement qbcListaTarifas = soapBody.addChildElement("listaTarifas", QUALITAS_NAMESPACE_DECLARATION );
        SOAPElement qbccUsuario = qbcListaTarifas.addChildElement("cUsuario", QUALITAS_NAMESPACE_DECLARATION);
        qbccUsuario.addTextNode(QUALITAS_USUARIO);
        SOAPElement qbccTarifa = qbcListaTarifas.addChildElement("cTarifa", QUALITAS_NAMESPACE_DECLARATION);
        qbccTarifa.addTextNode(QUALITAS_TARIFA);
        SOAPElement qbccMarca = qbcListaTarifas.addChildElement("cMarca", QUALITAS_NAMESPACE_DECLARATION);
        qbccMarca.addTextNode(marca);
        SOAPElement qbccTipo = qbcListaTarifas.addChildElement("cTipo", QUALITAS_NAMESPACE_DECLARATION);
        qbccTipo.addTextNode("");
        SOAPElement qbccVersion = qbcListaTarifas.addChildElement("cVersion", QUALITAS_NAMESPACE_DECLARATION);
        qbccVersion.addTextNode("");
        SOAPElement qbccModelo = qbcListaTarifas.addChildElement("cModelo", QUALITAS_NAMESPACE_DECLARATION);
        qbccModelo.addTextNode("");
        SOAPElement qbccCAMIS = qbcListaTarifas.addChildElement("cCAMIS", QUALITAS_NAMESPACE_DECLARATION);
        qbccCAMIS.addTextNode("");
        SOAPElement qbccCategoria = qbcListaTarifas.addChildElement("cCategoria", QUALITAS_NAMESPACE_DECLARATION);
        qbccCategoria.addTextNode("");
        SOAPElement qbccNvaAMIS = qbcListaTarifas.addChildElement("cNvaAMIS", QUALITAS_NAMESPACE_DECLARATION);
        qbccNvaAMIS.addTextNode("");
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(QUALITAS_SOAP_HEADER, QUALITAS_SERVER_URI + "/listaTarifas");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }
}
