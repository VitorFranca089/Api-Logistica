package com.logistica.api.controller;

import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/cadastro")
    public ResponseEntity<EntregaDTO> cadastraEntrega(@RequestBody EntregaDTO entregaDTO){
        EntregaDTO response = this.entregaService.cadastraEntrega(entregaDTO);
        return ResponseEntity.ok(response);
    }

}
