package src;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {


// Montagem do Http e conexão
        String url = "https://imdb-api.com/en/API/Top250TVs/k_2djg2apy";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();


// extrair só os dados que interessam ( titulo, poster, classificação
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);


// exibir e manipular os dados
        var geradora = new GeradorDeSticker();
        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();

        }

    }
}
