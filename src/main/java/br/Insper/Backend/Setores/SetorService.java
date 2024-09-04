package br.Insper.Backend.Setores;

import br.Insper.Backend.Beneficios.Beneficio;
import br.Insper.Backend.Beneficios.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;

    public SetorService(SetorRepository setorRepository, BeneficioRepository beneficioRepository) {
        this.setorRepository = setorRepository;
        this.beneficioRepository = beneficioRepository;
    }

    // Cadastra um novo setor
    public Setor cadastrarSetor(Setor setor) {
        // Procura o setor no banco de dados
        Setor setorExistente = setorRepository.findBySetor(setor.getSetor());

        // Se o setor existir, lança uma exceção
        if (setorExistente != null) {
            throw new RuntimeException("Setor já cadastrado");
        }

        // Verifica se o setor está vazio
        if (setor.getSetor().isEmpty() || setor.getSetor() == null) {
            throw new RuntimeException("Setor não pode ser vazio");
        }

        // Salva o setor no banco de dados
        return setorRepository.save(setor);
    }

    // Lista todos os setores
    public List<Setor> listarSetores() {
        // Retorna todos os setores
        return setorRepository.findAll();
    }

    // Deleta um setor
    public Setor deletarSetor(String id) {
        // Procura o setor no banco de dados
        Setor setorExistente = setorRepository.findById(id).orElse(null);

        // Se o setor não existir, lança uma exceção
        if (setorExistente == null) {
            throw new RuntimeException("Setor não encontrado");
        }

        // Verifica se existem benefícios associados ao setor
        List<Beneficio> beneficios = beneficioRepository.findBySetor(setorExistente.getSetor());

        // Se existirem benefícios associados ao setor, lança uma exceção
        if (!beneficios.isEmpty()) {
            throw new RuntimeException("Existem benefícios associados ao setor");
        }

        // Deleta o setor do banco de dados
        setorRepository.delete(setorExistente);

        // Retorna o setor deletado
        return setorExistente;
    }
}
