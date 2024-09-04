package br.Insper.Backend.Avisos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avisos")
public class AvisoController {
    @Autowired
    private AvisoService avisoService;

    // Cadastro de aviso
    @PostMapping
    public Aviso cadastrarAviso(@RequestBody Aviso aviso) {
        return avisoService.criarAviso(aviso);
    }

    // Listar avisos
    @GetMapping
    public List<Aviso> listarAvisos() {
        return avisoService.listarAvisos();
    }

    // Buscar aviso
    @GetMapping("/{id}")
    public Aviso buscarAviso(@PathVariable String id) {
        return avisoService.buscarAviso(id);
    }

    // Deletar aviso
    @DeleteMapping("/{id}")
    public Aviso deletarAviso(@PathVariable String id) {
        return avisoService.deletarAviso(id);
    }

    // Atualizar aviso
    @PutMapping("/{id}")
    public Aviso atualizarAviso(@RequestBody Aviso aviso, @PathVariable String id) {
        return avisoService.atualizarAviso(id, aviso.getNome(), aviso.getDescricao());
    }
}
