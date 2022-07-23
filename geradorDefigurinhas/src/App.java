package src;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {


// Montagem do Http e conexão

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extrairConteudos(json);


        var geradora = new GeradorDeSticker();

// exibir e manipular os dados
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "C:/Users/crkw/OneDrive/Imagens/Testes/" + conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();

        }

    }
}
