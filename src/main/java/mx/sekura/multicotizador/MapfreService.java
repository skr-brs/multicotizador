package mx.sekura.multicotizador;

import io.vertx.core.json.JsonObject;
import mx.sekura.multicotizador.Afirme.AfirmeSOAPMessage;
import mx.sekura.multicotizador.Mapfre.MapfreSOAPMessage;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.handler.BodyHandler;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import mx.sekura.multicotizador.Qualitas.QualitasSOAPMessage;
import org.json.JSONObject;
import org.json.XML;

public class MapfreService extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(MapfreService.class);
    private static final MapfreSOAPMessage mapfreSOAPMessage = new MapfreSOAPMessage();
    private static final AfirmeSOAPMessage afirmeSOAPMessage = new AfirmeSOAPMessage();
    public static final QualitasSOAPMessage qualitasSOAPMessage = new QualitasSOAPMessage();
    private WebClient webClient;

    @Override
    public void start() throws SOAPException {

        Set<String> allowedHeaders = new HashSet<>();
        allowedHeaders.add("x-requested-with");
        allowedHeaders.add("Access-Control-Allow-Origin");
        allowedHeaders.add("Access-Control-Allow-Headers");
        allowedHeaders.add("origin");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("Accept");
        allowedHeaders.add("AuditId");
        allowedHeaders.add("Authorization");


        Set<HttpMethod> allowedMethods = new HashSet<>();
        allowedMethods.add(HttpMethod.GET);
        allowedMethods.add(HttpMethod.POST);
        allowedMethods.add(HttpMethod.OPTIONS);
        allowedMethods.add(HttpMethod.DELETE);
        allowedMethods.add(HttpMethod.PATCH);
        allowedMethods.add(HttpMethod.PUT);

        Router router = Router.router(vertx);
        webClient = WebClient.create(vertx);

        router.route().handler(CorsHandler.create("*").allowedHeaders(allowedHeaders).allowedMethods(allowedMethods));
        router.route().handler(BodyHandler.create());

        //MAPFRE
        router.get("/mapfre/getMarcas/:anioFabrica").handler(this::getMarcas);
        router.get("/mapfre/getModelos/:anioFabrica/:codMarca").handler(this::getModelos);
        router.get("/mapfre/getEstados").handler(this::getEstados);
        router.get("/mapfre/getPoblaciones/:codEstado").handler(this::getPoblaciones);
        router.post("/mapfre/getCotizacion").handler(this::getCotizacionAmplio);

        //AFIRME
        router.get("/afirme/getMarcas").handler(this::getListMarcasAfirme);
        router.get("/afirme/getModelos/:idMarca").handler(this::getListModelosAfirme);
        router.get("/afirme/getEstilos/:idMarca").handler(this::getListEstilosAfirme);
        router.get("/afirme/getBuscarEstilo/:idMarca/:idModelo").handler(this::getBuscarEstilo);

        //QUALITÁS
        router.get("/qualitas/getMarcas").handler(this::getListMarcasQualitas);
        router.get("/qualitas/getTarifas/:marca").handler(this::getListTarifasQualitas);

        router.route().failureHandler( failureRoutingContext -> {
            int statusCode = failureRoutingContext.statusCode();
            HttpServerResponse response = failureRoutingContext.response();
            response.setStatusCode(statusCode).end("Error");
            System.out.println(failureRoutingContext);
        });

        vertx.createHttpServer().requestHandler(router).listen(9008);
    }

    private void getEstados(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = mapfreSOAPMessage.getMessageWSTWEstados();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                //System.out.println(strMsg);
                JSONObject jsonObject = XML.toJSONObject(strMsg);
                String json = jsonObject.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("WS_TW_EstadosResponse").getJSONObject("WS_TW_EstadosResult").getJSONObject("xml").getJSONObject("data").get("lista").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getPoblaciones(RoutingContext routingContext) {
        SOAPMessage response = null;
        Integer codEstado = Integer.parseInt(routingContext.request().getParam("codEstado"));
        System.out.println(codEstado);

        try {
            response = mapfreSOAPMessage.getMessageWSTWPoblaciones(codEstado);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                //System.out.println(strMsg);
                JSONObject jsonObject = XML.toJSONObject(strMsg);
                String json = jsonObject.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("WS_TW_PoblacionesResponse").getJSONObject("WS_TW_PoblacionesResult").getJSONObject("xml").getJSONObject("data").get("lista").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getMarcas(RoutingContext routingContext) {
        SOAPMessage response = null;
        Integer anioFabrica = Integer.parseInt(routingContext.request().getParam("anioFabrica"));

        try {
            response = mapfreSOAPMessage.getMessageWSTWMarcas(anioFabrica);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                //System.out.println(strMsg);
                JSONObject jsonObject = XML.toJSONObject(strMsg);
                String json = jsonObject.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("WS_TW_MarcasResponse").getJSONObject("WS_TW_MarcasResult").getJSONObject("xml").getJSONObject("data").get("lista").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getModelos(RoutingContext routingContext) {
        SOAPMessage response = null;
        Integer anioFabrica = Integer.parseInt(routingContext.request().getParam("anioFabrica"));
        Integer codMarca = Integer.parseInt(routingContext.request().getParam("codMarca"));
        System.out.println(anioFabrica + " "+codMarca);

        try {
            response = mapfreSOAPMessage.getMessageWSTWModelos(anioFabrica,codMarca);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                //System.out.println(strMsg);
                JSONObject jsonObject = XML.toJSONObject(strMsg);
                String json = jsonObject.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("WS_TW_ModelosResponse").getJSONObject("WS_TW_ModelosResult").getJSONObject("xml").getJSONObject("data").get("lista").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getCotizacionAmplio(RoutingContext routingContext) {
        SOAPMessage response = null;
        JsonObject   jsonObject = new JsonObject(routingContext.getBodyAsString());
        Integer anioFabrica = Integer.valueOf(jsonObject.getString("anioFabrica"));
        Integer codMarca = Integer.valueOf(jsonObject.getString("codMarca"));
        Integer codModelo = Integer.valueOf(jsonObject.getString("codModelo"));
        Integer codEstado = Integer.valueOf(jsonObject.getString("codEstado"));
        Integer codPoblacion = Integer.valueOf(jsonObject.getString("codPoblacion"));
        Integer codFraccPago = Integer.valueOf(jsonObject.getString("codFraccPago"));

        try {
            response = mapfreSOAPMessage.getMessageWSTWCotizacionAmplio(codPoblacion, codEstado, codFraccPago, anioFabrica, codMarca,codModelo);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                //System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("WS_TW_ACotizaResponse").getJSONObject("WS_TW_ACotizaResult").getJSONObject("xml").getJSONObject("data").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    //AFIRME
    private void getListMarcasAfirme(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = afirmeSOAPMessage.getMessageListMarcas(Integer.parseInt(Constants.ID_LINEA_NEGOCIO));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("dlwmin:getListMarcasResponse").get("return").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getListModelosAfirme(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = afirmeSOAPMessage.getMessageListModelos(Integer.parseInt(Constants.ID_LINEA_NEGOCIO), Integer.parseInt(routingContext.request().getParam("idMarca")));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("dlwmin:getListModelosResponse").get("return").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getListEstilosAfirme(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = afirmeSOAPMessage.getMessageListEstilos(Integer.parseInt(routingContext.request().getParam("idMarca")));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("dlwmin:getListEstilosResponse").get("return").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getBuscarEstilo(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = afirmeSOAPMessage.getBuscarEstilo(Integer.parseInt(routingContext.request().getParam("idMarca")),Integer.parseInt(routingContext.request().getParam("idModelo")));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("dlwmin:buscarEstiloResponse").get("return").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    //QUÁLITAS
    private void getListMarcasQualitas(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = qualitasSOAPMessage.getMessageListaMarcas();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("listaMarcasResponse").getJSONObject("listaMarcasResult").getJSONObject("salida").getJSONObject("datos").get("Elemento").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void getListTarifasQualitas(RoutingContext routingContext) {
        SOAPMessage response = null;

        try {
            response = qualitasSOAPMessage.getMessageListaTarifas(routingContext.request().getParam("marca"));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                response.writeTo(out);
                String strMsg = new String(out.toByteArray());
                System.out.println(strMsg);
                JSONObject jsonObj = XML.toJSONObject(strMsg);
                String json = jsonObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("listaTarifasResponse").getJSONObject("listaTarifasResult").getJSONObject("salida").getJSONObject("datos").get("Elemento").toString();

                routingContext.response().setStatusCode(200).putHeader("Contentype", "application/json: charset:UTF-8").end(json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }
}
