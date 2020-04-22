package mx.sekura.multicotizador.Mapfre;

import javax.xml.soap.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static mx.sekura.multicotizador.Constants.*;

public class MapfreReactor {

    Calendar c = Calendar.getInstance();
    Calendar c1 = Calendar.getInstance();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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

    public SOAPMessage getWSTWRamos() throws Exception {
        String xml = "";
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_Ramos", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_Ramos");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWEstados() throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        String xml = "<XML><DATA><VALOR COD_RAMO='" + MAPFRE_COD_RAMO + "'/></DATA></XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwEstados = soapBody.addChildElement("WS_TW_Estados", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwEstados.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwEstados.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_Estados");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWPoblaciones(Integer codEstado) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        String xml = "<XML><DATA><VALOR COD_ESTADO='"+codEstado+"' COD_RAMO='" + MAPFRE_COD_RAMO + "'/></DATA></XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwPoblaciones = soapBody.addChildElement("WS_TW_Poblaciones", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwPoblaciones.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwPoblaciones.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_Poblaciones");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWMarcas(Integer anioFabrica) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();
        //soapPart.removeAllMimeHeaders();

        String xml = "<XML><DATA><VALOR ANIO_FABRICA='"+ anioFabrica +"' COD_TIP_VEHI='"+ MAPFRE_COD_TIP_VEHI+"' COD_ZONA_AGT='"+ MAPFRE_COD_ZONA_AGT +"' COD_RAMO='" + MAPFRE_COD_RAMO +"'/></DATA></XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();

        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_Marcas", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_Marcas");
        //soapMessage.saveChanges();
        //soapMessage.writeTo(System.out);

        return soapMessage;

    }

    public SOAPMessage getWSTWModelos(Integer anioFabrica, Integer codMarca) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        String xml = "<XML><DATA><VALOR ANIO_FABRICA='"+ anioFabrica +"' COD_ZONA_AGT='"+ MAPFRE_COD_ZONA_AGT +"' COD_TIP_VEHI='"+ MAPFRE_COD_TIP_VEHI+"' COD_MARCA='"+ codMarca +"' COD_RAMO='" + MAPFRE_COD_RAMO +"'/></DATA></XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_Modelos", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_Modelos");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWCotizacionRC(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                    " <SEGURIDAD>" +
                        "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                    "</SEGURIDAD>" +
                    "<DATA>" +
                        "<COTIZACION>" +
                            "<DATOS_POLIZA " +
                                "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                                "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                                "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                                "COD_PROV='" +codPoblacion+"' "+
                                "COD_ESTADO='" +codEstado+"' "+
                                "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                                "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                                "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                                "COD_USR='" +MAPFRE_COD_USR+"' "+
                                "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                                "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                                "COD_FRACC_PAGO='" +codFraccPago+"' "+
                                "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                                "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                                "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                                "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                                "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                                "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                                "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                            "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                                "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                            "</DATOS_VARIABLES>" +
                            "<DATOS_VARIABLES19 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                                "<CAMPO9 VAL_CAMPO='" +MAPFRE_COD_MODALIDAD+"' COD_CAMPO='COD_MODALIDAD'/>" +
                                "<CAMPO11 VAL_CAMPO='" +codAnioFabrica+"' COD_CAMPO='ANIO_FABRICA'/>" +
                                "<CAMPO12 VAL_CAMPO='" +codMarca+"' COD_CAMPO='COD_MARCA'/>" +
                                "<CAMPO13 VAL_CAMPO='" +codModelo+"' COD_CAMPO='COD_MODELO'/>" +
                                "<CAMPO14 VAL_CAMPO='" +MAPFRE_COD_TIP_VEHI+"' COD_CAMPO='COD_TIP_VEHI'/>" +
                                "<CAMPO15 VAL_CAMPO='" +MAPFRE_COD_USO_VEHI+"' COD_CAMPO='COD_USO_VEHI'/>" +
                                "<CAMPO16 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                                "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_ACTUAL'/>" +
                                "<CAMPO18 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                                "<CAMPO44 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                                "<CAMPO45 VAL_CAMPO='' COD_CAMPO='FEC_FACTURA'/>" +
                                "<CAMPO46 VAL_CAMPO='' COD_CAMPO='NUM_FACTURA'/>" +
                                "<CAMPO47 VAL_CAMPO='' COD_CAMPO='VAL_FACTURA'/>" +
                                "<CAMPO48 VAL_CAMPO='' COD_CAMPO='NUM_PASAJEROS'/>" +
                                "<CAMPO74 VAL_CAMPO='' COD_CAMPO='NUM_SERIE'/>" +
                            "</DATOS_VARIABLES19>" +
                            "<DATOS_VARIABLES22 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                                "<CAMPO19 VAL_CAMPO='999' COD_CAMPO='COD_BONI_RECA'/>" +
                                "<CAMPO21 VAL_CAMPO='-17' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                            "</DATOS_VARIABLES22>" +
                            "<COBERTURAS>" +
                                "<COBERTURA COD_FRANQUICIA='0' SUMA_ASEG='0' COD_COB='4000'/>" +
                                "<COBERTURA24 COD_FRANQUICIA='0' SUMA_ASEG='0' COD_COB='4001'/>" +
                                "<COBERTURA25 SUMA_ASEG='2000000' COD_COB='4010'/>" +
                                "<COBERTURA26 SUMA_ASEG='2000000' COD_COB='4011'/>" +
                                "<COBERTURA27 SUMA_ASEG='400000' COD_COB='4006'/>" +
                                "<COBERTURA29 SUMA_ASEG='1' COD_COB='4004'/>" +
                                "<COBERTURA30 SUMA_ASEG='0' COD_COB='4012'/>" +
                                "<COBERTURA31 SUMA_ASEG='0' COD_COB='4015'/>" +
                                "<COBERTURA32 SUMA_ASEG='100000' COD_COB='4013'/>" +
                                "<COBERTURA33 SUMA_ASEG='0' COD_COB='4022'/>" +
                                "<COBERTURA34 SUMA_ASEG='0' COD_COB='4023'/>" +
                                "<COBERTURA35 SUMA_ASEG='0' COD_COB='4024'/>" +
                                "<COBERTURA37 SUMA_ASEG='0' COD_COB='4028'/>" +
                                "<COBERTURA39 SUMA_ASEG='0' COD_COB='4007'/>" +
                                "<COBERTURA56 SUMA_ASEG='0' COD_COB='4068'/>" +
                            "</COBERTURAS>" +
                            "<DATOS_CH_TMV63>" +
                                "<CAMPO64 VAL_CAMPO='' COD_CAMPO='MCA_SEXO'/>" +
                                "<CAMPO65 VAL_CAMPO='' COD_CAMPO='COD_ESTADO'/>" +
                                "<CAMPO66 VAL_CAMPO='' COD_CAMPO='COD_PROV'/>" +
                                "<CAMPO67 VAL_CAMPO='' COD_CAMPO='FEC_NACIMIENTO'/>" +
                                "<CAMPO68 VAL_CAMPO='' COD_CAMPO='COD_POSTAL'/>" +
                                "<CAMPO69 VAL_CAMPO='' COD_CAMPO='RFC'/>" +
                                "<CAMPO70 VAL_CAMPO='' COD_CAMPO='NOM_TERCERO'/>" +
                                "<CAMPO71 VAL_CAMPO='' COD_CAMPO='APE1_TERCERO'/>" +
                                "<CAMPO72 VAL_CAMPO='' COD_CAMPO='APE2_TERCERO'/>" +
                            "</DATOS_CH_TMV63>" +
                        "</COTIZACION>" +
                    "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_ACotiza", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_ACotiza");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWCotizacionLimitado(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                " <SEGURIDAD>" +
                "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                "</SEGURIDAD>" +
                "<DATA>" +
                "<COTIZACION>" +
                "<DATOS_POLIZA " +
                "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                "COD_PROV='" +codPoblacion+"' "+
                "COD_ESTADO='" +codEstado+"' "+
                "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                "COD_USR='" +MAPFRE_COD_USR+"' "+
                "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                "COD_FRACC_PAGO='" +codFraccPago+"' "+
                "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                "</DATOS_VARIABLES>" +
                "<DATOS_VARIABLES19 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                "<CAMPO9 VAL_CAMPO='" +MAPFRE_COD_MODALIDAD+"' COD_CAMPO='COD_MODALIDAD'/>" +
                "<CAMPO11 VAL_CAMPO='" +codAnioFabrica+"' COD_CAMPO='ANIO_FABRICA'/>" +
                "<CAMPO12 VAL_CAMPO='" +codMarca+"' COD_CAMPO='COD_MARCA'/>" +
                "<CAMPO13 VAL_CAMPO='" +codModelo+"' COD_CAMPO='COD_MODELO'/>" +
                "<CAMPO14 VAL_CAMPO='" +MAPFRE_COD_TIP_VEHI+"' COD_CAMPO='COD_TIP_VEHI'/>" +
                "<CAMPO15 VAL_CAMPO='" +MAPFRE_COD_USO_VEHI+"' COD_CAMPO='COD_USO_VEHI'/>" +
                "<CAMPO16 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_ACTUAL'/>" +
                "<CAMPO18 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                "<CAMPO44 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                "<CAMPO45 VAL_CAMPO='' COD_CAMPO='FEC_FACTURA'/>" +
                "<CAMPO46 VAL_CAMPO='' COD_CAMPO='NUM_FACTURA'/>" +
                "<CAMPO47 VAL_CAMPO='' COD_CAMPO='VAL_FACTURA'/>" +
                "<CAMPO48 VAL_CAMPO='' COD_CAMPO='NUM_PASAJEROS'/>" +
                "<CAMPO74 VAL_CAMPO='' COD_CAMPO='NUM_SERIE'/>" +
                "</DATOS_VARIABLES19>" +
                "<DATOS_VARIABLES22 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                "<CAMPO19 VAL_CAMPO='999' COD_CAMPO='COD_BONI_RECA'/>" +
                "<CAMPO21 VAL_CAMPO='-17' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                "</DATOS_VARIABLES22>" +
                "<COBERTURAS>" +
                "<COBERTURA COD_FRANQUICIA='0' SUMA_ASEG='0' COD_COB='4000'/>" +
                "<COBERTURA24 COD_FRANQUICIA='10' SUMA_ASEG='C' COD_COB='4001'/>" +
                "<COBERTURA25 SUMA_ASEG='2000000' COD_COB='4010'/>" +
                "<COBERTURA26 SUMA_ASEG='2000000' COD_COB='4011'/>" +
                "<COBERTURA27 SUMA_ASEG='400000' COD_COB='4006'/>" +
                "<COBERTURA28 SUMA_ASEG='1' COD_COB='4003'/>" +
                "<COBERTURA29 SUMA_ASEG='1' COD_COB='4004'/>" +
                "<COBERTURA30 SUMA_ASEG='0' COD_COB='4012'/>" +
                "<COBERTURA31 SUMA_ASEG='0' COD_COB='4015'/>" +
                "<COBERTURA32 SUMA_ASEG='100000' COD_COB='4013'/>" +
                "<COBERTURA33 SUMA_ASEG='0' COD_COB='4022'/>" +
                "<COBERTURA34 SUMA_ASEG='0' COD_COB='4023'/>" +
                "<COBERTURA35 SUMA_ASEG='1' COD_COB='4024'/>" +
                "<COBERTURA37 SUMA_ASEG='0' COD_COB='4028'/>" +
                "<COBERTURA39 SUMA_ASEG='0' COD_COB='4007'/>" +
                "<COBERTURA56 SUMA_ASEG='0' COD_COB='4068'/>" +
                "</COBERTURAS>" +
                "<DATOS_CH_TMV63>" +
                "<CAMPO64 VAL_CAMPO='' COD_CAMPO='MCA_SEXO'/>" +
                "<CAMPO65 VAL_CAMPO='' COD_CAMPO='COD_ESTADO'/>" +
                "<CAMPO66 VAL_CAMPO='' COD_CAMPO='COD_PROV'/>" +
                "<CAMPO67 VAL_CAMPO='' COD_CAMPO='FEC_NACIMIENTO'/>" +
                "<CAMPO68 VAL_CAMPO='' COD_CAMPO='COD_POSTAL'/>" +
                "<CAMPO69 VAL_CAMPO='' COD_CAMPO='RFC'/>" +
                "<CAMPO70 VAL_CAMPO='' COD_CAMPO='NOM_TERCERO'/>" +
                "<CAMPO71 VAL_CAMPO='' COD_CAMPO='APE1_TERCERO'/>" +
                "<CAMPO72 VAL_CAMPO='' COD_CAMPO='APE2_TERCERO'/>" +
                "</DATOS_CH_TMV63>" +
                "</COTIZACION>" +
                "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_ACotiza", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_ACotiza");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWCotizacionAmplio(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                " <SEGURIDAD>" +
                "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                "</SEGURIDAD>" +
                "<DATA>" +
                "<COTIZACION>" +
                "<DATOS_POLIZA " +
                "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                "COD_PROV='" +codPoblacion+"' "+
                "COD_ESTADO='" +codEstado+"' "+
                "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                "COD_USR='" +MAPFRE_COD_USR+"' "+
                "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                "COD_FRACC_PAGO='" +codFraccPago+"' "+
                "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                "</DATOS_VARIABLES>" +
                "<DATOS_VARIABLES19 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                "<CAMPO9 VAL_CAMPO='" +MAPFRE_COD_MODALIDAD+"' COD_CAMPO='COD_MODALIDAD'/>" +
                "<CAMPO11 VAL_CAMPO='" +codAnioFabrica+"' COD_CAMPO='ANIO_FABRICA'/>" +
                "<CAMPO12 VAL_CAMPO='" +codMarca+"' COD_CAMPO='COD_MARCA'/>" +
                "<CAMPO13 VAL_CAMPO='" +codModelo+"' COD_CAMPO='COD_MODELO'/>" +
                "<CAMPO14 VAL_CAMPO='" +MAPFRE_COD_TIP_VEHI+"' COD_CAMPO='COD_TIP_VEHI'/>" +
                "<CAMPO15 VAL_CAMPO='" +MAPFRE_COD_USO_VEHI+"' COD_CAMPO='COD_USO_VEHI'/>" +
                "<CAMPO16 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_ACTUAL'/>" +
                "<CAMPO18 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                "<CAMPO44 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                "<CAMPO45 VAL_CAMPO='' COD_CAMPO='FEC_FACTURA'/>" +
                "<CAMPO46 VAL_CAMPO='' COD_CAMPO='NUM_FACTURA'/>" +
                "<CAMPO47 VAL_CAMPO='' COD_CAMPO='VAL_FACTURA'/>" +
                "<CAMPO48 VAL_CAMPO='' COD_CAMPO='NUM_PASAJEROS'/>" +
                "<CAMPO74 VAL_CAMPO='' COD_CAMPO='NUM_SERIE'/>" +
                "</DATOS_VARIABLES19>" +
                "<DATOS_VARIABLES22 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                "<CAMPO19 VAL_CAMPO='"+MAPFRE_COD_BONI_RECA+"' COD_CAMPO='COD_BONI_RECA'/>" +
                "<CAMPO21 VAL_CAMPO='"+MAPFRE_PCT_COD_REC_ESP+"' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                "</DATOS_VARIABLES22>" +
                "<COBERTURAS>" +
                "<COBERTURA COD_FRANQUICIA='5' SUMA_ASEG='C' COD_COB='4000'/>" +
                "<COBERTURA24 COD_FRANQUICIA='10' SUMA_ASEG='C' COD_COB='4001'/>" +
                "<COBERTURA25 SUMA_ASEG='2000000' COD_COB='4010'/>" +
                "<COBERTURA26 SUMA_ASEG='2000000' COD_COB='4011'/>" +
                "<COBERTURA27 SUMA_ASEG='400000' COD_COB='4006'/>" +
                "<COBERTURA28 SUMA_ASEG='1' COD_COB='4003'/>" +
                "<COBERTURA29 SUMA_ASEG='1' COD_COB='4004'/>" +
                "<COBERTURA30 SUMA_ASEG='0' COD_COB='4012'/>" +
                "<COBERTURA31 SUMA_ASEG='0' COD_COB='4015'/>" +
                "<COBERTURA32 SUMA_ASEG='100000' COD_COB='4013'/>" +
                "<COBERTURA33 SUMA_ASEG='0' COD_COB='4022'/>" +
                "<COBERTURA34 SUMA_ASEG='0' COD_COB='4023'/>" +
                "<COBERTURA35 SUMA_ASEG='1' COD_COB='4024'/>" +
                "<COBERTURA37 SUMA_ASEG='0' COD_COB='4028'/>" +
                "<COBERTURA39 SUMA_ASEG='0' COD_COB='4007'/>" +
                "<COBERTURA56 SUMA_ASEG='0' COD_COB='4068'/>" +
                "<COBERTURA57 SUMA_ASEG='1' COD_COB='4014'/>" +
                "</COBERTURAS>" +
                "<DATOS_CH_TMV63>" +
                "<CAMPO64 VAL_CAMPO='' COD_CAMPO='MCA_SEXO'/>" +
                "<CAMPO65 VAL_CAMPO='' COD_CAMPO='COD_ESTADO'/>" +
                "<CAMPO66 VAL_CAMPO='' COD_CAMPO='COD_PROV'/>" +
                "<CAMPO67 VAL_CAMPO='' COD_CAMPO='FEC_NACIMIENTO'/>" +
                "<CAMPO68 VAL_CAMPO='' COD_CAMPO='COD_POSTAL'/>" +
                "<CAMPO69 VAL_CAMPO='' COD_CAMPO='RFC'/>" +
                "<CAMPO70 VAL_CAMPO='' COD_CAMPO='NOM_TERCERO'/>" +
                "<CAMPO71 VAL_CAMPO='' COD_CAMPO='APE1_TERCERO'/>" +
                "<CAMPO72 VAL_CAMPO='' COD_CAMPO='APE2_TERCERO'/>" +
                "</DATOS_CH_TMV63>" +
                "</COTIZACION>" +
                "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_ACotiza", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_ACotiza");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWEmiteAmplio(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                    "<SEGURIDAD>" +
                        "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                    "</SEGURIDAD>" +
                    "<DATA>" +
                        "<POLIZA>" +
                            "<DATOS_POLIZA " +
                                "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                                "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                                "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                                "COD_PROV='" +codPoblacion+"' "+
                                "COD_ESTADO='" +codEstado+"' "+
                                "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                                "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                                "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                                "COD_USR='" +MAPFRE_COD_USR+"' "+
                                "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                                "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                                "COD_FRACC_PAGO='" +codFraccPago+"' "+
                                "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                                "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                                "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                                "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                                "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                                "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                                "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                            "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                                "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                            "</DATOS_VARIABLES>" +
                            "<DATOS_VARIABLES44 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                                "<CAMPO9 VAL_CAMPO='5SA331E631PUEBAS' COD_CAMPO='NUM_SERIE'/>" +
                                "<CAMPO11 VAL_CAMPO='40999' COD_CAMPO='COD_MODALIDAD'/>" +
                                "<CAMPO12 VAL_CAMPO='2010' COD_CAMPO='ANIO_FABRICA'/>" +
                                "<CAMPO13 VAL_CAMPO='2' COD_CAMPO='COD_MARCA'/>" +
                                "<CAMPO14 VAL_CAMPO='188' COD_CAMPO='COD_MODELO'/>" +
                                "<CAMPO15 VAL_CAMPO='1' COD_CAMPO='COD_TIP_VEHI'/>" +
                                "<CAMPO16 VAL_CAMPO='401' COD_CAMPO='COD_USO_VEHI'/>" +
                                "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                                "<CAMPO19 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                                "<CAMPO20 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                                "<CAMPO21 VAL_CAMPO='123ABC' COD_CAMPO='NUM_MATRICULA'/>" +
                                "<CAMPO22 VAL_CAMPO='XYZ789' COD_CAMPO='NUM_MOTOR'/>" +
                                "<CAMPO23 VAL_CAMPO='5' COD_CAMPO='NUM_PASAJEROS'/>" +
                                "<CAMPO24 VAL_CAMPO='250000' COD_CAMPO='VAL_FACTURA'/>" +
                                "<CAMPO25 VAL_CAMPO='1234ABCD' COD_CAMPO='NUM_FACTURA'/>" +
                                "<CAMPO26 VAL_CAMPO='30032020' COD_CAMPO='FEC_FACTURA'/>" +
                            "</DATOS_VARIABLES44>" +
                            "<DATOS_VARIABLES49 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                                "<CAMPO44 VAL_CAMPO='"+MAPFRE_COD_BONI_RECA+"' COD_CAMPO='COD_BONI_RECA'/>" +
                                "<CAMPO46 VAL_CAMPO='"+MAPFRE_PCT_COD_REC_ESP+"' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                                "<CAMPO47 VAL_CAMPO='"+MAPFRE_PCT_CESION_COM_AGT+"' COD_CAMPO='PCT_CESION_COM_AGT'/>" +
                                "<CAMPO48 VAL_CAMPO='"+MAPFRE_MEDIO_CAPTACION+"' COD_CAMPO='MEDIO_CAPTACION'/>" +
                            "</DATOS_VARIABLES49>" +
                            "<COBERTURAS>" +
                                "<COBERTURA COD_COB='4000' SUMA_ASEG='C' COD_FRANQUICIA='5'/>" +
                                "<COBERTURA51 COD_COB='4001' SUMA_ASEG='C' COD_FRANQUICIA='10'/>" +
                                "<COBERTURA52 COD_COB='4010' SUMA_ASEG='2000000'/>" +
                                "<COBERTURA53 COD_COB='4011' SUMA_ASEG='2000000'/>" +
                                "<COBERTURA54 COD_COB='4006' SUMA_ASEG='400000'/>" +
                                "<COBERTURA55 COD_COB='4003' SUMA_ASEG='1'/>" +
                                "<COBERTURA56 COD_COB='4004' SUMA_ASEG='1'/>" +
                                "<COBERTURA57 COD_COB='4012' SUMA_ASEG='0'/>" +
                                "<COBERTURA58 COD_COB='4015' SUMA_ASEG='0'/>" +
                                "<COBERTURA59 COD_COB='4013' SUMA_ASEG='100000'/>" +
                                "<COBERTURA60 COD_COB='4022' SUMA_ASEG='0'/>" +
                                "<COBERTURA61 COD_COB='4023' SUMA_ASEG='0'/>" +
                                "<COBERTURA62 COD_COB='4024' SUMA_ASEG='1'/>" +
                                "<COBERTURA64 COD_COB='4028' SUMA_ASEG='0'/>" +
                                "<COBERTURA66 COD_COB='4007' SUMA_ASEG='0'/>" +
                                "<COBERTURA67 COD_COB='4014' SUMA_ASEG='1'/>" +
                                "<COBERTURA68 COD_COB='4068' SUMA_ASEG='0'/>" +
                            "</COBERTURAS>" +
                            "<TERCEROS>" +
                                "<CONTRATANTE " +
                                    "EMAIL=\"RAUL@MAIL.COM\" " +
                                    "APE2_TERCERO=\"FLORES\" " +
                                    "APE1_TERCERO=\"CORTES\" " +
                                    "NOM_TERCERO=\"RAUL\" " +
                                    "COD_PROV=\"9011\" " +
                                    "COD_ESTADO=\"9\" " +
                                    "COD_DOCUM=\"COFR750101\" " +
                                    "MCA_FISICO=\"S\" " +
                                    "NOM_DOMICILIO1=\"ARTICO\" " +
                                    "NOM_DOMICILIO3=\"ATLANTA\" " +
                                    "COD_LOCALIDAD=\"9011\" " +
                                    "MCA_SEXO=\"1\" " +
                                    "FEC_NACIMIENTO=\"01/01/1975\" " +
                                    "COD_POSTAL=\"54740\" " +
                                    "TLF_NUMERO=\"58711248\" " +
                                    "TLF_MOVIL=\"5518422670\" " +
                                    "MODIFICADO=\"N\"/>" +
                                "<CONDUCTOR " +
                                    "EMAIL=\"RAUL@MAIL.COM\" " +
                                    "APE2_TERCERO=\"FLORES\" " +
                                    "APE1_TERCERO=\"CORTES\" " +
                                    "NOM_TERCERO=\"RAUL\" " +
                                    "COD_PROV=\"9011\" " +
                                    "COD_ESTADO=\"9\" " +
                                    "COD_DOCUM=\"COFR750101\" " +
                                    "MCA_FISICO=\"S\" " +
                                    "NOM_DOMICILIO1=\"ARTICO\" " +
                                    "NOM_DOMICILIO3=\"ATLANTA\" " +
                                    "COD_LOCALIDAD=\"9011\" " +
                                    "MCA_SEXO=\"1\" " +
                                    "FEC_NACIMIENTO=\"01/01/1975\" " +
                                    "COD_POSTAL=\"54740\" " +
                                    "TLF_NUMERO=\"58711248\" " +
                                    "TLF_MOVIL=\"5518422670\" " +
                                    "MODIFICADO=\"N\"/>" +
                                "<BENEFICIARIO " +
                                    "EMAIL=\"SON@MAIL.COM\" " +
                                    "APE2_TERCERO=\"MARTINEZ\" " +
                                    "APE1_TERCERO=\"RAMIREZ\" " +
                                    "NOM_TERCERO=\"SONIA\" " +
                                    "COD_PROV=\"9011\" " +
                                    "COD_ESTADO=\"9\" " +
                                    "COD_DOCUM=\"RAMS790421QJ0\" " +
                                    "MCA_FISICO=\"S\" " +
                                    "NOM_DOMICILIO1=\"ARTICO\" " +
                                    "NOM_DOMICILIO3=\"ATLANTA\" " +
                                    "COD_LOCALIDAD=\"9011\" " +
                                    "MCA_SEXO=\"0\" " +
                                    "FEC_NACIMIENTO=\"21/04/1979\" " +
                                    "COD_POSTAL=\"54740\" " +
                                    "TLF_NUMERO=\"58711248\" " +
                                    "TLF_MOVIL=\"5518422670\" " +
                                    "MODIFICADO=\"N\"/>" +
                                "<YO" +
                                    " EMAIL=\"SON@MAIL.COM\" " +
                                    "APE2_TERCERO=\"MARTINEZ\" " +
                                    "APE1_TERCERO=\"RAMIREZ\" " +
                                    "NOM_TERCERO=\"SONIA\" " +
                                    "COD_PROV=\"9011\" " +
                                    "COD_ESTADO=\"9\" " +
                                    "COD_DOCUM=\"RAMS790421QJ0\" " +
                                    "MCA_FISICO=\"S\" " +
                                    "NOM_DOMICILIO1=\"ARTICO\" " +
                                    "NOM_DOMICILIO3=\"ATLANTA\" " +
                                    "COD_LOCALIDAD=\"9011\" " +
                                    "MCA_SEXO=\"0\" " +
                                    "FEC_NACIMIENTO=\"21/04/1979\" " +
                                    "COD_POSTAL=\"54740\" " +
                                    "TLF_NUMERO=\"58711248\" " +
                                    "TLF_MOVIL=\"5518422670\" " +
                                    "MODIFICADO=\"N\"/>" +
                            "</TERCEROS>" +
                        "</POLIZA>" +
                    "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_AEmite", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_AEmite");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWEmiteLimitado(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                "<SEGURIDAD>" +
                    "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                "</SEGURIDAD>" +
                "<DATA>" +
                    "<POLIZA>" +
                        "<DATOS_POLIZA " +
                            "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                            "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                            "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                            "COD_PROV='" +codPoblacion+"' "+
                            "COD_ESTADO='" +codEstado+"' "+
                            "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                            "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                            "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                            "COD_USR='" +MAPFRE_COD_USR+"' "+
                            "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                            "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                            "COD_FRACC_PAGO='" +codFraccPago+"' "+
                            "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                            "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                            "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                            "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                            "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                            "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                            "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                        "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                            "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                        "</DATOS_VARIABLES>" +
                        "<DATOS_VARIABLES44 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                            "<CAMPO9 VAL_CAMPO='5SA331E1PUEAS' COD_CAMPO='NUM_SERIE'/>" +
                            "<CAMPO11 VAL_CAMPO='40999' COD_CAMPO='COD_MODALIDAD'/>" +
                            "<CAMPO12 VAL_CAMPO='2010' COD_CAMPO='ANIO_FABRICA'/>" +
                            "<CAMPO13 VAL_CAMPO='2' COD_CAMPO='COD_MARCA'/>" +
                            "<CAMPO14 VAL_CAMPO='188' COD_CAMPO='COD_MODELO'/>" +
                            "<CAMPO15 VAL_CAMPO='1' COD_CAMPO='COD_TIP_VEHI'/>" +
                            "<CAMPO16 VAL_CAMPO='401' COD_CAMPO='COD_USO_VEHI'/>" +
                            "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                            "<CAMPO19 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                            "<CAMPO20 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                            "<CAMPO21 VAL_CAMPO='123ABC' COD_CAMPO='NUM_MATRICULA'/>" +
                            "<CAMPO22 VAL_CAMPO='XYZ789' COD_CAMPO='NUM_MOTOR'/>" +
                            "<CAMPO23 VAL_CAMPO='5' COD_CAMPO='NUM_PASAJEROS'/>" +
                            "<CAMPO24 VAL_CAMPO='250000' COD_CAMPO='VAL_FACTURA'/>" +
                            "<CAMPO25 VAL_CAMPO='1234ABCD' COD_CAMPO='NUM_FACTURA'/>" +
                            "<CAMPO26 VAL_CAMPO='30032020' COD_CAMPO='FEC_FACTURA'/>" +
                        "</DATOS_VARIABLES44>" +
                        "<DATOS_VARIABLES49 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                            "<CAMPO44 VAL_CAMPO='"+MAPFRE_COD_BONI_RECA+"' COD_CAMPO='COD_BONI_RECA'/>" +
                            "<CAMPO46 VAL_CAMPO='"+MAPFRE_PCT_COD_REC_ESP+"' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                            "<CAMPO47 VAL_CAMPO='"+MAPFRE_PCT_CESION_COM_AGT+"' COD_CAMPO='PCT_CESION_COM_AGT'/>" +
                            "<CAMPO48 VAL_CAMPO='"+MAPFRE_MEDIO_CAPTACION+"' COD_CAMPO='MEDIO_CAPTACION'/>" +
                        "</DATOS_VARIABLES49>" +
                        "<COBERTURAS>" +
                            "<COBERTURA COD_COB='4000' SUMA_ASEG='0' COD_FRANQUICIA='0'/>" +
                            "<COBERTURA51 COD_COB='4001' SUMA_ASEG='C' COD_FRANQUICIA='10'/>" +
                            "<COBERTURA52 COD_COB='4010' SUMA_ASEG='2000000'/>" +
                            "<COBERTURA53 COD_COB='4011' SUMA_ASEG='2000000'/>" +
                            "<COBERTURA54 COD_COB='4006' SUMA_ASEG='400000'/>" +
                            "<COBERTURA55 COD_COB='4003' SUMA_ASEG='1'/>" +
                            "<COBERTURA56 COD_COB='4004' SUMA_ASEG='1'/>" +
                            "<COBERTURA57 COD_COB='4012' SUMA_ASEG='0'/>" +
                            "<COBERTURA58 COD_COB='4015' SUMA_ASEG='0'/>" +
                            "<COBERTURA59 COD_COB='4013' SUMA_ASEG='100000'/>" +
                            "<COBERTURA60 COD_COB='4022' SUMA_ASEG='0'/>" +
                            "<COBERTURA61 COD_COB='4023' SUMA_ASEG='0'/>" +
                            "<COBERTURA62 COD_COB='4024' SUMA_ASEG='1'/>" +
                            "<COBERTURA64 COD_COB='4028' SUMA_ASEG='0'/>" +
                            "<COBERTURA66 COD_COB='4007' SUMA_ASEG='0'/>" +
                            "<COBERTURA68 COD_COB='4068' SUMA_ASEG='0'/>" +
                        "</COBERTURAS>" +
                        "<TERCEROS>" +
                            "<CONTRATANTE " +
                                "EMAIL=\"RAUL@MAIL.COM\" " +
                                "APE2_TERCERO=\"FLORES\" " +
                                "APE1_TERCERO=\"CORTES\" " +
                                "NOM_TERCERO=\"RAUL\" " +
                                "COD_PROV=\"9011\" " +
                                "COD_ESTADO=\"9\" " +
                                "COD_DOCUM=\"COFR750101\" " +
                                "MCA_FISICO=\"S\" " +
                                "NOM_DOMICILIO1=\"ARTICO\" " +
                                "NOM_DOMICILIO3=\"ATLANTA\" " +
                                "COD_LOCALIDAD=\"9011\" " +
                                "MCA_SEXO=\"1\" " +
                                "FEC_NACIMIENTO=\"01/01/1975\" " +
                                "COD_POSTAL=\"54740\" " +
                                "TLF_NUMERO=\"58711248\" " +
                                "TLF_MOVIL=\"5518422670\" " +
                                "MODIFICADO=\"N\"/>" +
                            "<CONDUCTOR " +
                                "EMAIL=\"RAUL@MAIL.COM\" " +
                                "APE2_TERCERO=\"FLORES\" " +
                                "APE1_TERCERO=\"CORTES\" " +
                                "NOM_TERCERO=\"RAUL\" " +
                                "COD_PROV=\"9011\" " +
                                "COD_ESTADO=\"9\" " +
                                "COD_DOCUM=\"COFR750101\" " +
                                "MCA_FISICO=\"S\" " +
                                "NOM_DOMICILIO1=\"ARTICO\" " +
                                "NOM_DOMICILIO3=\"ATLANTA\" " +
                                "COD_LOCALIDAD=\"9011\" " +
                                "MCA_SEXO=\"1\" " +
                                "FEC_NACIMIENTO=\"01/01/1975\" " +
                                "COD_POSTAL=\"54740\" " +
                                "TLF_NUMERO=\"58711248\" " +
                                "TLF_MOVIL=\"5518422670\" " +
                                "MODIFICADO=\"N\"/>" +
                            "<BENEFICIARIO " +
                                "EMAIL=\"SON@MAIL.COM\" " +
                                "APE2_TERCERO=\"MARTINEZ\" " +
                                "APE1_TERCERO=\"RAMIREZ\" " +
                                "NOM_TERCERO=\"SONIA\" " +
                                "COD_PROV=\"9011\" " +
                                "COD_ESTADO=\"9\" " +
                                "COD_DOCUM=\"RAMS790421QJ0\" " +
                                "MCA_FISICO=\"S\" " +
                                "NOM_DOMICILIO1=\"ARTICO\" " +
                                "NOM_DOMICILIO3=\"ATLANTA\" " +
                                "COD_LOCALIDAD=\"9011\" " +
                                "MCA_SEXO=\"0\" " +
                                "FEC_NACIMIENTO=\"21/04/1979\" " +
                                "COD_POSTAL=\"54740\" " +
                                "TLF_NUMERO=\"58711248\" " +
                                "TLF_MOVIL=\"5518422670\" " +
                                "MODIFICADO=\"N\"/>" +
                            "<YO" +
                                " EMAIL=\"SON@MAIL.COM\" " +
                                "APE2_TERCERO=\"MARTINEZ\" " +
                                "APE1_TERCERO=\"RAMIREZ\" " +
                                "NOM_TERCERO=\"SONIA\" " +
                                "COD_PROV=\"9011\" " +
                                "COD_ESTADO=\"9\" " +
                                "COD_DOCUM=\"RAMS790421QJ0\" " +
                                "MCA_FISICO=\"S\" " +
                                "NOM_DOMICILIO1=\"ARTICO\" " +
                                "NOM_DOMICILIO3=\"ATLANTA\" " +
                                "COD_LOCALIDAD=\"9011\" " +
                                "MCA_SEXO=\"0\" " +
                                "FEC_NACIMIENTO=\"21/04/1979\" " +
                                "COD_POSTAL=\"54740\" " +
                                "TLF_NUMERO=\"58711248\" " +
                                "TLF_MOVIL=\"5518422670\" " +
                                "MODIFICADO=\"N\"/>" +
                        "</TERCEROS>" +
                    "</POLIZA>" +
                "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_AEmite", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_AEmite");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public SOAPMessage getWSTWEmiteRC(Integer codPoblacion, Integer codEstado, int codFraccPago, Integer codAnioFabrica, Integer codMarca, Integer codModelo) throws Exception {
        soapMessage.getSOAPBody().removeContents();
        soapMessage.getMimeHeaders().removeAllHeaders();

        c1.add(Calendar.YEAR, 1);
        String xml = "" +
                "<XML>" +
                "<SEGURIDAD>" +
                "<USER PWD='"+ MAPFRE_PWD+"' ID='"+ MAPFRE_ID +"'/>" +
                "</SEGURIDAD>" +
                "<DATA>" +
                "<POLIZA>" +
                "<DATOS_POLIZA " +
                "TIP_GESTOR='" +MAPFRE_TIP_GESTOR+"' "+
                "COD_GESTOR='" +MAPFRE_COD_GESTOR+"' "+
                "PCT_AGT='" +MAPFRE_PCT_AGT+"' "+
                "COD_PROV='" +codPoblacion+"' "+
                "COD_ESTADO='" +codEstado+"' "+
                "COD_DOCUM='" +MAPFRE_COD_DOCUM+"' "+
                "TIP_DOCUM='" +MAPFRE_TIP_DOCUM+"' "+
                "COD_NIVEL3_CAPTURA='" +MAPFRE_COD_NIVEL3_CAPTURA+"' "+
                "COD_USR='" +MAPFRE_COD_USR+"' "+
                "COD_AGT='" +MAPFRE_COD_AGT+"' "+
                "COD_CUADRO_COM='" +MAPFRE_COD_CUADRO_COM+"' "+
                "COD_FRACC_PAGO='" +codFraccPago+"' "+
                "FEC_VCTO_POLIZA='" + df.format(c1.getTime())+"' "+
                "FEC_EFEC_POLIZA='" + df.format(c.getTime())+"' "+
                "COD_RAMO='" +MAPFRE_COD_RAMO+"' "+
                "COD_SECTOR='" +MAPFRE_COD_SECTOR+"' "+
                "NUM_CONTRATO='" +MAPFRE_NUM_CONTRATO+"' "+
                "NUM_POLIZA_GRUPO='" +MAPFRE_COD_POLIZA_GRUPO+"' "+
                "ID_NEGOCIO='" +MAPFRE_ID_NEGOCIO+"'/>"+
                "<DATOS_VARIABLES TIP_NIVEL='3' NUM_RIESGO='1'>" +
                "<CAMPO VAL_CAMPO='1' COD_CAMPO='COD_MATERIA'/>" +
                "</DATOS_VARIABLES>" +
                "<DATOS_VARIABLES44 TIP_NIVEL='2' NUM_RIESGO='1'>" +
                "<CAMPO9 VAL_CAMPO='5SA331E1PUDEAS' COD_CAMPO='NUM_SERIE'/>" +
                "<CAMPO11 VAL_CAMPO='40999' COD_CAMPO='COD_MODALIDAD'/>" +
                "<CAMPO12 VAL_CAMPO='2010' COD_CAMPO='ANIO_FABRICA'/>" +
                "<CAMPO13 VAL_CAMPO='2' COD_CAMPO='COD_MARCA'/>" +
                "<CAMPO14 VAL_CAMPO='188' COD_CAMPO='COD_MODELO'/>" +
                "<CAMPO15 VAL_CAMPO='1' COD_CAMPO='COD_TIP_VEHI'/>" +
                "<CAMPO16 VAL_CAMPO='401' COD_CAMPO='COD_USO_VEHI'/>" +
                "<CAMPO17 VAL_CAMPO='N' COD_CAMPO='MCA_FACTURA'/>" +
                "<CAMPO19 VAL_CAMPO='S' COD_CAMPO='MCA_COMERCIAL'/>" +
                "<CAMPO20 VAL_CAMPO='N' COD_CAMPO='MCA_COMERCIAL10'/>" +
                "<CAMPO21 VAL_CAMPO='123ABC' COD_CAMPO='NUM_MATRICULA'/>" +
                "<CAMPO22 VAL_CAMPO='XYZ789' COD_CAMPO='NUM_MOTOR'/>" +
                "<CAMPO23 VAL_CAMPO='5' COD_CAMPO='NUM_PASAJEROS'/>" +
                "<CAMPO24 VAL_CAMPO='250000' COD_CAMPO='VAL_FACTURA'/>" +
                "<CAMPO25 VAL_CAMPO='1234ABCD' COD_CAMPO='NUM_FACTURA'/>" +
                "<CAMPO26 VAL_CAMPO='30032020' COD_CAMPO='FEC_FACTURA'/>" +
                "</DATOS_VARIABLES44>" +
                "<DATOS_VARIABLES49 TIP_NIVEL='1' NUM_RIESGO='0'>" +
                "<CAMPO44 VAL_CAMPO='"+MAPFRE_COD_BONI_RECA+"' COD_CAMPO='COD_BONI_RECA'/>" +
                "<CAMPO46 VAL_CAMPO='"+MAPFRE_PCT_COD_REC_ESP+"' COD_CAMPO='PCT_COD_REC_ESP'/>" +
                "<CAMPO47 VAL_CAMPO='"+MAPFRE_PCT_CESION_COM_AGT+"' COD_CAMPO='PCT_CESION_COM_AGT'/>" +
                "<CAMPO48 VAL_CAMPO='"+MAPFRE_MEDIO_CAPTACION+"' COD_CAMPO='MEDIO_CAPTACION'/>" +
                "</DATOS_VARIABLES49>" +
                "<COBERTURAS>" +
                "<COBERTURA COD_COB='4000' SUMA_ASEG='0' COD_FRANQUICIA='0'/>" +
                "<COBERTURA51 COD_COB='4001' SUMA_ASEG='0' COD_FRANQUICIA='0'/>" +
                "<COBERTURA52 COD_COB='4010' SUMA_ASEG='2000000'/>" +
                "<COBERTURA53 COD_COB='4011' SUMA_ASEG='2000000'/>" +
                "<COBERTURA54 COD_COB='4006' SUMA_ASEG='400000'/>" +
                "<COBERTURA56 COD_COB='4004' SUMA_ASEG='1'/>" +
                "<COBERTURA57 COD_COB='4012' SUMA_ASEG='0'/>" +
                "<COBERTURA58 COD_COB='4015' SUMA_ASEG='0'/>" +
                "<COBERTURA59 COD_COB='4013' SUMA_ASEG='100000'/>" +
                "<COBERTURA60 COD_COB='4022' SUMA_ASEG='0'/>" +
                "<COBERTURA61 COD_COB='4023' SUMA_ASEG='0'/>" +
                "<COBERTURA62 COD_COB='4024' SUMA_ASEG='0'/>" +
                "<COBERTURA64 COD_COB='4028' SUMA_ASEG='0'/>" +
                "<COBERTURA66 COD_COB='4007' SUMA_ASEG='0'/>" +
                "<COBERTURA68 COD_COB='4068' SUMA_ASEG='0'/>" +
                "</COBERTURAS>" +
                "<TERCEROS>" +
                "<CONTRATANTE " +
                "EMAIL=\"RAUL@MAIL.COM\" " +
                "APE2_TERCERO=\"FLORES\" " +
                "APE1_TERCERO=\"CORTES\" " +
                "NOM_TERCERO=\"RAUL\" " +
                "COD_PROV=\"9011\" " +
                "COD_ESTADO=\"9\" " +
                "COD_DOCUM=\"COFR750101\" " +
                "MCA_FISICO=\"S\" " +
                "NOM_DOMICILIO1=\"ARTICO\" " +
                "NOM_DOMICILIO3=\"ATLANTA\" " +
                "COD_LOCALIDAD=\"9011\" " +
                "MCA_SEXO=\"1\" " +
                "FEC_NACIMIENTO=\"01/01/1975\" " +
                "COD_POSTAL=\"54740\" " +
                "TLF_NUMERO=\"58711248\" " +
                "TLF_MOVIL=\"5518422670\" " +
                "MODIFICADO=\"N\"/>" +
                "<CONDUCTOR " +
                "EMAIL=\"RAUL@MAIL.COM\" " +
                "APE2_TERCERO=\"FLORES\" " +
                "APE1_TERCERO=\"CORTES\" " +
                "NOM_TERCERO=\"RAUL\" " +
                "COD_PROV=\"9011\" " +
                "COD_ESTADO=\"9\" " +
                "COD_DOCUM=\"COFR750101\" " +
                "MCA_FISICO=\"S\" " +
                "NOM_DOMICILIO1=\"ARTICO\" " +
                "NOM_DOMICILIO3=\"ATLANTA\" " +
                "COD_LOCALIDAD=\"9011\" " +
                "MCA_SEXO=\"1\" " +
                "FEC_NACIMIENTO=\"01/01/1975\" " +
                "COD_POSTAL=\"54740\" " +
                "TLF_NUMERO=\"58711248\" " +
                "TLF_MOVIL=\"5518422670\" " +
                "MODIFICADO=\"N\"/>" +
                "<BENEFICIARIO " +
                "EMAIL=\"SON@MAIL.COM\" " +
                "APE2_TERCERO=\"MARTINEZ\" " +
                "APE1_TERCERO=\"RAMIREZ\" " +
                "NOM_TERCERO=\"SONIA\" " +
                "COD_PROV=\"9011\" " +
                "COD_ESTADO=\"9\" " +
                "COD_DOCUM=\"RAMS790421QJ0\" " +
                "MCA_FISICO=\"S\" " +
                "NOM_DOMICILIO1=\"ARTICO\" " +
                "NOM_DOMICILIO3=\"ATLANTA\" " +
                "COD_LOCALIDAD=\"9011\" " +
                "MCA_SEXO=\"0\" " +
                "FEC_NACIMIENTO=\"21/04/1979\" " +
                "COD_POSTAL=\"54740\" " +
                "TLF_NUMERO=\"58711248\" " +
                "TLF_MOVIL=\"5518422670\" " +
                "MODIFICADO=\"N\"/>" +
                "<YO" +
                " EMAIL=\"SON@MAIL.COM\" " +
                "APE2_TERCERO=\"MARTINEZ\" " +
                "APE1_TERCERO=\"RAMIREZ\" " +
                "NOM_TERCERO=\"SONIA\" " +
                "COD_PROV=\"9011\" " +
                "COD_ESTADO=\"9\" " +
                "COD_DOCUM=\"RAMS790421QJ0\" " +
                "MCA_FISICO=\"S\" " +
                "NOM_DOMICILIO1=\"ARTICO\" " +
                "NOM_DOMICILIO3=\"ATLANTA\" " +
                "COD_LOCALIDAD=\"9011\" " +
                "MCA_SEXO=\"0\" " +
                "FEC_NACIMIENTO=\"21/04/1979\" " +
                "COD_POSTAL=\"54740\" " +
                "TLF_NUMERO=\"58711248\" " +
                "TLF_MOVIL=\"5518422670\" " +
                "MODIFICADO=\"N\"/>" +
                "</TERCEROS>" +
                "</POLIZA>" +
                "</DATA>" +
                "</XML>";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(MAPFRE_NAMESPACE_DECLARATION, MAPFRE_SERVER_URI);
        SOAPBody soapBody = envelope.getBody();

        SOAPElement temWsTwMarcas = soapBody.addChildElement("WS_TW_AEmite", MAPFRE_NAMESPACE_DECLARATION );
        SOAPElement cotXML = temWsTwMarcas.addChildElement("xml", MAPFRE_NAMESPACE_DECLARATION);
        cotXML.addTextNode(xml);
        SOAPElement cotToken = temWsTwMarcas.addChildElement("token", MAPFRE_NAMESPACE_DECLARATION);
        cotToken.addTextNode(MAPFRE_TOKEN_DEV);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader(MAPFRE_SOAP_HEADER, MAPFRE_SERVER_URI + "WS_TW_AEmite");
        soapMessage.saveChanges();
        soapMessage.writeTo(System.out);

        return soapMessage;
    }
}
