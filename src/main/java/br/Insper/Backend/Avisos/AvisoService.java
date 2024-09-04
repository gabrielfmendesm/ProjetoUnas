package br.Insper.Backend.Avisos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {
    @Autowired
    private AvisoRepository avisoRepository;

    public AvisoService(AvisoRepository avisoRepository) {
        this.avisoRepository = avisoRepository;
    }

    // Criar um aviso
    public Aviso criarAviso(Aviso aviso) {
        // Procura o aviso no banco de dados
        Aviso avisoExistente = avisoRepository.findByNome(aviso.getNome());

        // Se o aviso existir, lança uma exceção
        if (avisoExistente != null) {
            throw new IllegalArgumentException("Aviso já cadastrado");
        }

        // Verifica se o nome está presente
        if (aviso.getNome() == null || aviso.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        // Verifica se a descrição está presente
        if (aviso.getDescricao() == null || aviso.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória");
        }

        // Salva o aviso no banco de dados
        return avisoRepository.save(aviso);
    }

    // Atualizar um aviso
    public Aviso atualizarAviso(String id, String nome, String descricao) {
        // Busca o aviso no banco de dados pelo id
        Aviso aviso = avisoRepository.findById(id).orElse(null);

        // Verifica se o aviso existe
        if (aviso == null) {
            throw new IllegalArgumentException("Aviso não existe");
        }

        // Verifica se o nome está presente
        if (nome != null && !nome.isEmpty()) {
            aviso.setNome(nome);
        }

        // Verifica se a descrição está presente
        if (descricao != null && !descricao.isEmpty()) {
            aviso.setDescricao(descricao);
        }

        // Salva o aviso no banco de dados
        return avisoRepository.save(aviso);
    }

    // Deletar um aviso
    public Aviso deletarAviso(String id) {
        // Busca o aviso no banco de dados pelo id
        Aviso aviso = avisoRepository.findById(id).orElse(null);

        // Verifica se o aviso existe
        if (aviso == null) {
            throw new IllegalArgumentException("Aviso não existe");
        }

        // Deleta o aviso do banco de dados
        avisoRepository.delete(aviso);

        // Retorna o aviso deletado
        return aviso;
    }

    // Listar avisos
    public List<Aviso> listarAvisos() {
        // Retorna todos os avisos
        return avisoRepository.findAll();
    }

    // Buscar um aviso pelo id
    public Aviso buscarAviso(String id) {
        // Busca o aviso no banco de dados pelo id
        Aviso aviso = avisoRepository.findById(id).orElse(null);

        // Verifica se o aviso existe
        if (aviso == null) {
            throw new IllegalArgumentException("Aviso não existe");
        }

        // Retorna o aviso
        return aviso;
    }
}
