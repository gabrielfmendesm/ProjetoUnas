package br.Insper.Backend.Beneficios;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Getter
@Setter
public class Beneficio {
    @MongoId
    private String id;
    private String setor;
    private String nome;
    private String descricao;
    private List<String> requisitos;
    private List<String> documentos;
    private String imagem;
}
