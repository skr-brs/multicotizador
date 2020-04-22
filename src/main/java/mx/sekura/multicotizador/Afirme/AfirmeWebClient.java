package mx.sekura.multicotizador.Afirme;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import static mx.sekura.multicotizador.Constants.SERVER_URI;

public class AfirmeWebClient extends AbstractVerticle {

    private String token;
    private WebClient webClient;

    public String getToken(){

        try {

            webClient = WebClient.create(vertx);
            webClient.getAbs(SERVER_URI).send(ar -> {
                if (ar.succeeded()) {
                    HttpResponse<Buffer> response = ar.result();
                    token = response.bodyAsJsonObject().getJsonObject("data").getString("token");
                    System.out.println("Token: " + token);
                } else {
                    System.out.println("Falló: " + ar.cause().getMessage());
                }
            });

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return token;
    }
}
