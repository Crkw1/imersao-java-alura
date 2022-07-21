package src;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {


// Montagem do Http e conexão

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extrairConteudos(json);


        var geradora = new GeradorDeSticker();

// exibir e manipular os dados
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "C:/Users/crkw/OneDrive/Imagens/Testes/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }
}
