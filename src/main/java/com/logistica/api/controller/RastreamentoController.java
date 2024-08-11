package com.logistica.api.controller;

import com.logistica.api.dto.RastreamentoDTO;
import com.logistica.api.model.Usuario;
import com.logistica.api.service.RastreamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rastreamento")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @PostMapping("/{id}")
    public ResponseEntity<RastreamentoDTO> registrarRastreamento(@PathVariable Integer id, @RequestBody @Valid RastreamentoDTO rastreamentoDTO){
        RastreamentoDTO response = this.rastreamentoService.registrarRastreamento(id, rastreamentoDTO);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<RastreamentoDTO>> listarRastreamento(@PathVariable Integer id, @AuthenticationPrincipal Usuario usuarioAuth){
        List<RastreamentoDTO> response = this.rastreamentoService.listarRastreamento(id, usuarioAuth);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

}
