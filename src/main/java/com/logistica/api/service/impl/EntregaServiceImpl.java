package com.logistica.api.service.impl;

import com.logistica.api.dto.EnderecoDTO;
import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.model.Endereco;
import com.logistica.api.model.Entrega;
import com.logistica.api.repository.EnderecoRepository;
import com.logistica.api.repository.EntregaRepository;
import com.logistica.api.service.EntregaService;
import com.logistica.api.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public EntregaDTO cadastraEntrega(EntregaDTO entregaDTO) {
        Endereco origemEndereco = this.enderecoRepository.findByCep(entregaDTO.origemCep().cep()).
                orElseGet(() -> salvarEndereco(entregaDTO.origemCep()));
        Endereco destinoEndereco = this.enderecoRepository.findByCep(entregaDTO.destinoCep().cep()).
                orElseGet(() -> salvarEndereco(entregaDTO.destinoCep()));
        Entrega entrega = new Entrega();
        entrega.setStatus(entregaDTO.status());
        entrega.setLojaResponsavel(entregaDTO.lojaResponsavel());
        entrega.setOrigem(origemEndereco);
        entrega.setDestino(destinoEndereco);
        entrega.setDataCriacao(LocalDateTime.now());
        this.entregaRepository.save(entrega);
        return new EntregaDTO(entrega.getStatus(), entrega.getLojaResponsavel(), new EnderecoDTO(entrega.getOrigem()), new EnderecoDTO(entrega.getDestino()), entrega.getDataCriacao());
    }

    private Endereco salvarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = this.viaCepService.getEndereco(enderecoDTO.cep());
        if(!enderecoDTO.unidade().isEmpty()) endereco.setUnidade(enderecoDTO.unidade());
        return enderecoRepository.save(endereco);
    }

}
