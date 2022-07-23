package br.com.alura.imersao.linguagensapi;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "principaisLinguagens")
public class Linguagem {

    private String id;

    private String title;
    private String imagem;
    private int ranking;

    public Linguagem () {

    }


    public Linguagem(String id, String title, String imagem, int ranking) {
        this.id = id;
        this.title = title;
        this.imagem = imagem;
        this.ranking = ranking;
    }


}