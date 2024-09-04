package br.Insper.Backend.Beneficios;

import br.Insper.Backend.Setores.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficioService {
    @Autowired
    private BeneficioRepository beneficioRepository;

    @Autowired
    private SetorRepository setorRepository;

    public BeneficioService(BeneficioRepository beneficioRepository, SetorRepository setorRepository) {
        this.beneficioRepository = beneficioRepository;
        this.setorRepository = setorRepository;
    }

    // Cadastrar beneficio
    public Beneficio cadastrarBeneficio(Beneficio beneficio) {
        // Procura o benefício no banco de dados
        Beneficio beneficioExistente = beneficioRepository.findByNome(beneficio.getNome());

        // Se o benefício existir, lança uma exceção
        if (beneficioExistente != null) {
            throw new RuntimeException("Benefício já cadastrado");
        }

        // Verifica se o setor está presente
        if (beneficio.getSetor().equals("") || beneficio.getSetor() == null) {
            throw new RuntimeException("Setor não pode ser vazio");
        }

        // Verifica se o setor existe no banco de dados de setores
        if (setorRepository.findBySetor(beneficio.getSetor()) == null) {
            throw new RuntimeException("Setor não cadastrado");
        }

        // Verifica se o nome do benefício está vazio
        if (beneficio.getNome().equals("") || beneficio.getNome() == null) {
            throw new RuntimeException("Nome do benefício não pode ser vazio");
        }

        // Verifica se a descrição do benefício está vazia
        if (beneficio.getDescricao().equals("") || beneficio.getDescricao() == null) {
            throw new RuntimeException("Descrição do benefício não pode ser vazia");
        }

        // Verifica se a lista de requisitos do benefício está vazia
        if (beneficio.getRequisitos().isEmpty()) {
            throw new RuntimeException("Requisitos do benefício não podem ser vazios");
        }

        // Verifica se a lista de documentos do benefício está vazia
        if (beneficio.getDocumentos().isEmpty()) {
            throw new RuntimeException("Documentos do benefício não podem ser vazios");
        }

        // Salva o benefício no banco de dados
        return beneficioRepository.save(beneficio);
    }

    // Atualiza beneficio
    public Beneficio atualizarBeneficio(String id, String setor, String nome, String descricao, List<String> requisitos, List<String> documentos, String imagem) {
        // Procura o benefício no banco de dados usando o ID
        Beneficio beneficioExistente = beneficioRepository.findById(id).orElse(null);

        // Se o benefício não existir, lança uma exceção
        if (beneficioExistente == null) {
            throw new RuntimeException("Benefício não cadastrado");
        }

        // Verifica se o setor existe no banco de dados de setores
        if (setorRepository.findBySetor(setor) == null) {
            throw new RuntimeException("Setor não cadastrado");
        }

        // Verifica se o setor está presente
        if (setor == null) {
            throw new RuntimeException("Setor não pode ser vazio");
        }

        // Verifica se o nome do benefício está vazio
        if (nome.isEmpty()) {
            throw new RuntimeException("Nome do benefício não pode ser vazio");
        }

        // Verifica se a descrição do benefício está vazia
        if (descricao.isEmpty()) {
            throw new RuntimeException("Descrição do benefício não pode ser vazia");
        }

        // Verifica se a lista de requisitos do benefício está vazia
        if (requisitos.isEmpty()) {
            throw new RuntimeException("Requisitos do benefício não podem ser vazios");
        }

        // Verifica se a lista de documentos do benefício está vazia
        if (documentos.isEmpty()) {
            throw new RuntimeException("Documentos do benefício não podem ser vazios");
        }

        // Atualiza o benefício no banco de dados
        beneficioExistente.setSetor(setor);
        beneficioExistente.setNome(nome);
        beneficioExistente.setDescricao(descricao);
        beneficioExistente.setRequisitos(requisitos);
        beneficioExistente.setDocumentos(documentos);
        beneficioExistente.setImagem(imagem);

        // Salva o benefício no banco de dados
        return beneficioRepository.save(beneficioExistente);
    }

    // Deletar beneficio
    public Beneficio deletarBeneficio(String id) {
        // Procura o benefício no banco de dados usando o ID
        Beneficio beneficioExistente = beneficioRepository.findById(id).orElse(null);

        // Se o benefício não existir, lança uma exceção
        if (beneficioExistente == null) {
            throw new RuntimeException("Benefício não cadastrado");
        }

        // Deleta o benefício do banco de dados
        beneficioRepository.delete(beneficioExistente);

        // Retorna o benefício deletado
        return beneficioExistente;
    }

    // Listar beneficios
    public List<Beneficio> listarBeneficios(String setor) {
        // Se o setor não for vazio, retorna todos os benefícios
        if (setor != null) {
            return beneficioRepository.findBySetor(setor);
        }
        // Se o setor for vazio, retorna todos os benefícios
        return beneficioRepository.findAll();
    }

    // Encontrar beneficio
    public Beneficio encontrarBeneficio(String id) {
        // Retorna o benefício pelo ID
        return beneficioRepository.findById(id).orElse(null);
    }
}
