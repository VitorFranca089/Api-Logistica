package com.logistica.api.service;

import com.logistica.api.dto.RastreamentoDTO;

public interface RastreamentoService {
    RastreamentoDTO registrarRastreamento(Integer idEntrega, RastreamentoDTO rastreamentoDTO);
}
