package br.com.dio.controllers;

import br.com.dio.entity.Pedido;
import br.com.dio.entity.Produto;
import br.com.dio.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/save")
    public ResponseEntity<Pedido> save (@RequestBody Pedido pedido){
       Pedido pedido0 = service.save(pedido);

       return ResponseEntity.status(HttpStatus.CREATED).body(pedido0);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        List<Pedido> pedidos = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findByID(@PathVariable Long id){
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
}
