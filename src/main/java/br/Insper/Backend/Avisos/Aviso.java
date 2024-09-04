package br.Insper.Backend.Avisos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "avisos")
@Getter
@Setter
public class Aviso {
    @MongoId
    private String id;
    private String nome;
    private String descricao;
}
