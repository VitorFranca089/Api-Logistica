package com.logistica.api.service;

import com.logistica.api.dto.RastreamentoDTO;
import com.logistica.api.dto.response.RastreamentoResponse;
import com.logistica.api.model.Usuario;

import java.util.List;

public interface RastreamentoService {
    RastreamentoResponse registrarRastreamento(Integer idEntrega, RastreamentoDTO rastreamentoDTO);
    List<RastreamentoResponse> listarRastreamento(Integer idEntrega, Usuario usuario);
}
