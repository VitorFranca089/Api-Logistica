package com.logistica.api.service;

import com.logistica.api.dto.AtualizarStatusDTO;
import com.logistica.api.dto.EntregaDTO;

import java.util.List;

public interface EntregaService {
    EntregaDTO cadastrarEntrega(EntregaDTO entregaDTO);
    List<EntregaDTO> listarEntregas();
    EntregaDTO detalharEntrega(Integer idEntrega);
    EntregaDTO atualizarStatusEntrega(Integer idEntrega, AtualizarStatusDTO statusDTO);
}
