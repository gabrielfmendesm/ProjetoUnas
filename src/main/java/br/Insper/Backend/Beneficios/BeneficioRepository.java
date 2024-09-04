package br.Insper.Backend.Beneficios;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BeneficioRepository extends MongoRepository<Beneficio, String> {
    // Mostra todos os benefícios de um setor
    List<Beneficio> findBySetor(String setor);

    // Encontra um benefício pelo nome
    Beneficio findByNome(String nome);
}
