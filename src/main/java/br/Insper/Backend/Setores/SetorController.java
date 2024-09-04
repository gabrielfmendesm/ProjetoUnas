package br.Insper.Backend.Setores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    // Cadastrar setor
    @PostMapping
    public Setor cadastrarSetor(@RequestBody Setor setor) {
        return setorService.cadastrarSetor(setor);
    }

    // Listar setores
    @GetMapping
    public List<Setor> listarSetores() {
        return setorService.listarSetores();
    }

    // Deletar setor
    @DeleteMapping("/{id}")
    public Setor deletarSetor(@PathVariable String id ) {
        return setorService.deletarSetor(id);
    }
}
