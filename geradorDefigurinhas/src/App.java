import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {


// Montagem do Http e conexão

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geradora = new GeradorDeSticker();


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