package com.logistica.api.service;

import com.logistica.api.dto.RastreamentoDTO;

import java.util.List;

public interface RastreamentoService {
    RastreamentoDTO registrarRastreamento(Integer idEntrega, RastreamentoDTO rastreamentoDTO);
    List<RastreamentoDTO> listarRastreamento(Integer idEntrega);
}
