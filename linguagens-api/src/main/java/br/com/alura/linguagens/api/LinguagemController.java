package br.com.alura.linguagens.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LinguagemController {

    //mongodb+srv://guipimenta08:<password>@cluster0.indkm9j.mongodb.net/?retryWrites=true&w=majority

    @Autowired
    private LinguagemRepository repo;


    // GET = retorna algo em .json pro navegador
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repo.findByOrderByRanking();
        return linguagens;
    }

    // Caso o ID seja referenciado, printa em .json o conteúdo daquele ID
    @GetMapping("/linguagens/{id}")
    public Linguagem encontraLinguagem(@PathVariable String id) {
        return repo.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Método pro POST (POST = Insere algo no DB)
    @PostMapping("/linguagens")
    @ResponseStatus(HttpStatus.CREATED)
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repo.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping("/linguagens/{id}")
    public void apagaLinguagem(@PathVariable String id) {
        repo.deleteById(id);
    }


}
