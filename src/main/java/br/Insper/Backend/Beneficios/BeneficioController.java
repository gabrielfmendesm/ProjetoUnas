package br.Insper.Backend.Beneficios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficios")
public class BeneficioController {
    @Autowired
    private BeneficioService beneficioService;

    // Listar benefícios
    @GetMapping
    public List<Beneficio> listarBeneficios(@RequestParam(required = false) String setor) {
        return beneficioService.listarBeneficios(setor);
    }

    // Encontrar benefício
    @GetMapping("/{id}")
    public Beneficio encontrarBeneficio(@PathVariable String id) {
        return beneficioService.encontrarBeneficio(id);
    }

    // Cadastrar benefício
    @PostMapping
    public Beneficio cadastrarBeneficio(@RequestBody Beneficio beneficio) {
        return beneficioService.cadastrarBeneficio(beneficio);
    }

    // Deletar benefício
    @DeleteMapping("/{id}")
    public Beneficio deletarBeneficio(@PathVariable String id) {
        return beneficioService.deletarBeneficio(id);
    }

    // Atualizar benefício
    @PutMapping("/{id}")
    public Beneficio atualizarBeneficio(@RequestBody Beneficio beneficio, @PathVariable String id) {
        return beneficioService.atualizarBeneficio(id, beneficio.getSetor(), beneficio.getNome(), beneficio.getDescricao(), beneficio.getRequisitos(), beneficio.getDocumentos(), beneficio.getImagem());
    }
}
