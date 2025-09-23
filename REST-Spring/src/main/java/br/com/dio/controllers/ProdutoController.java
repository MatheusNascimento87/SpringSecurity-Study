package br.com.dio.controllers;

import br.com.dio.entity.Produto;
import br.com.dio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {

       service.save(produto);

       return ResponseEntity.ok().body(produto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){

        Produto produto = service.findById(id);

        return ResponseEntity.ok().body(produto);

    }
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){

        List<Produto> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
