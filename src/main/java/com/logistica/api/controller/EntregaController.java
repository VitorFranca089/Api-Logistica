package com.logistica.api.controller;

import com.logistica.api.dto.AtualizarStatusDTO;
import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.dto.response.EntregaResponse;
import com.logistica.api.model.Usuario;
import com.logistica.api.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/cadastro")
    public ResponseEntity<EntregaResponse> cadastrarEntrega(@RequestBody @Valid EntregaDTO entregaDTO){
        EntregaResponse response = this.entregaService.cadastrarEntrega(entregaDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponse>> listarEntrega(){
        List<EntregaResponse> response = this.entregaService.listarEntregas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponse> detalharEntrega(@PathVariable Integer id, @AuthenticationPrincipal Usuario usuarioAuth){
        EntregaResponse response = this.entregaService.detalharEntrega(id, usuarioAuth);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<EntregaResponse> atualizarStatusEntrega(@PathVariable Integer id, @RequestBody AtualizarStatusDTO statusDTO){
        EntregaResponse response = this.entregaService.atualizarStatusEntrega(id, statusDTO);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Integer id){
        this.entregaService.deletarEntrega(id);
        return ResponseEntity.noContent().build();
    }

}
