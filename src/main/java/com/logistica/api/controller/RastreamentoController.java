package com.logistica.api.controller;

import com.logistica.api.dto.RastreamentoDTO;
import com.logistica.api.service.impl.RastreamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rastreamento")
public class RastreamentoController {

    @Autowired
    private RastreamentoServiceImpl rastreamentoService;

    @PostMapping("/{id}")
    public ResponseEntity<RastreamentoDTO> registrarRastreamento(@PathVariable Integer id, @RequestBody RastreamentoDTO rastreamentoDTO){
        RastreamentoDTO response = this.rastreamentoService.registrarRastreamento(id, rastreamentoDTO);
        if(response != null) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

}
