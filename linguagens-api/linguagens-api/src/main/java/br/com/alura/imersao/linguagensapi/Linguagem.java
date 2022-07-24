package br.com.alura.imersao.linguagensapi;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "principaisLinguagens")
public class Linguagem {

    @Id
    private String id;

    private String title;
    private String image;
    private int ranking;

    public Linguagem () {

    }


    public Linguagem(String id, String title, String image, int ranking) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }


}
