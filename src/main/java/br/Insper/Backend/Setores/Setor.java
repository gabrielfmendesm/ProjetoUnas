package br.Insper.Backend.Setores;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "setores")
@Getter
@Setter
public class Setor {
    @MongoId
    private String id;
    private String setor;
}
