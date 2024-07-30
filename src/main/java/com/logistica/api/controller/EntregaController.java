package com.logistica.api.controller;

import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/cadastro")
    public ResponseEntity<EntregaDTO> cadastrarEntrega(@RequestBody EntregaDTO entregaDTO){
        EntregaDTO response = this.entregaService.cadastrarEntrega(entregaDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EntregaDTO>> listarEntrega(){
        List<EntregaDTO> response = this.entregaService.listarEntregas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> detalharEntrega(@PathVariable Integer id){
        EntregaDTO response = this.entregaService.detalharEntrega(id);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

}
