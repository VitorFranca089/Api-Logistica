package com.logistica.api.service;

import com.logistica.api.dto.RastreamentoDTO;
import com.logistica.api.model.Usuario;

import java.util.List;

public interface RastreamentoService {
    RastreamentoDTO registrarRastreamento(Integer idEntrega, RastreamentoDTO rastreamentoDTO);
    List<RastreamentoDTO> listarRastreamento(Integer idEntrega, Usuario usuario);
}
