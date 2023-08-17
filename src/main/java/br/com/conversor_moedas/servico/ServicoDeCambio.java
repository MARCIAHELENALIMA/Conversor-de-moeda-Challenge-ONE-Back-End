package br.com.conversor_moedas.servico;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe que realiza a comunicação com um serviço de câmbio para buscar taxas de câmbio.
 */
public class ServicoDeCambio {

    private static final String URL_BASE = "https://economia.awesomeapi.com.br/json/last/";
    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * Busca as taxas de câmbio para as moedas especificadas.
     *
     * @param moedas String contendo as abreviações das moedas desejadas (ex: "USD-BRL,EUR-BRL").
     * @return Objeto JSON contendo as taxas de câmbio.
     * @throws RuntimeException Se ocorrer um erro durante a busca de dados.
     */
    public JSONObject buscarTaxasDeCambio(String moedas) {
        return buscarDados(URL_BASE + moedas);
    }

    /**
     * Realiza uma requisição HTTP para buscar dados a partir de uma URL.
     *
     * @param url URL de onde os dados serão buscados.
     * @return Objeto JSON contendo os dados obtidos.
     * @throws RuntimeException Se ocorrer um erro durante a busca de dados.
     */
    private JSONObject buscarDados(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Caramba! Deu erro ao buscar dados, não fique brabo. Código de resposta: " + response.statusCode());
            }

            return new JSONObject(response.body());
        } catch (Exception e) {
            throw new RuntimeException("Poxa vida! Deu erro ao buscar dados", e);
        }
    }
}
