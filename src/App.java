package src;

import java.net.URI;
import java.net.http.*;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

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

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }

    }
}
