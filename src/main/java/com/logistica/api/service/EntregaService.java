package com.logistica.api.service;

import com.logistica.api.dto.AtualizarStatusDTO;
import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.dto.response.EntregaResponse;

import java.util.List;

public interface EntregaService {
    EntregaResponse cadastrarEntrega(EntregaDTO entregaDTO);
    List<EntregaResponse> listarEntregas();
    EntregaResponse detalharEntrega(Integer idEntrega);
    EntregaResponse atualizarStatusEntrega(Integer idEntrega, AtualizarStatusDTO statusDTO);
    void deletarEntrega(Integer idEntrega);
}
