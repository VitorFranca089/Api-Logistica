package com.logistica.api.service;

import com.logistica.api.dto.EntregaDTO;

import java.util.List;

public interface EntregaService {
    EntregaDTO cadastrarEntrega(EntregaDTO entregaDTO);
    List<EntregaDTO> listarEntregas();
    EntregaDTO detalharEntrega(Integer id);
}
