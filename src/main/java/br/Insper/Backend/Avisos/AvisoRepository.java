package br.Insper.Backend.Avisos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisoRepository extends MongoRepository<Aviso, String> {
    Aviso findByNome(String nome);
}
