package com.logistica.api.service.impl;

import com.logistica.api.dto.EnderecoDTO;
import com.logistica.api.dto.RastreamentoDTO;
import com.logistica.api.dto.response.RastreamentoResponse;
import com.logistica.api.model.Endereco;
import com.logistica.api.model.Entrega;
import com.logistica.api.model.Rastreamento;
import com.logistica.api.model.Usuario;
import com.logistica.api.repository.EnderecoRepository;
import com.logistica.api.repository.EntregaRepository;
import com.logistica.api.repository.RastreamentoRepository;
import com.logistica.api.service.RastreamentoService;
import com.logistica.api.util.EnderecoUtils;
import com.logistica.api.util.UsuarioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoServiceImpl implements RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoUtils enderecoUtils;

    @Autowired
    private UsuarioUtils usuarioUtils;

    @Override
    public RastreamentoResponse registrarRastreamento(Integer idEntrega, RastreamentoDTO rastreamentoDTO){
        Optional<Entrega> entrega = this.entregaRepository.findById(idEntrega);
        if(entrega.isPresent()){
            Endereco endereco = this.enderecoRepository.findByCepAndUnidade(rastreamentoDTO.endereco().cep(), rastreamentoDTO.endereco().unidade()).
                    orElseGet(() -> enderecoUtils.criarEndereco(rastreamentoDTO.endereco()));
            Rastreamento rastreamento = criarRastreamento(entrega.get(), rastreamentoDTO, endereco);
            this.rastreamentoRepository.save(rastreamento);
            return convertToDto(rastreamento);
        }
        return null;
    }

    @Override
    public List<RastreamentoResponse> listarRastreamento(Integer idEntrega, Usuario usuario){
        Optional<Entrega> entrega = this.entregaRepository.findById(idEntrega);
        if(entrega.isPresent() && usuarioUtils.usuarioPodeAcessarEntrega(entrega.get(), usuario)){
            List<Rastreamento> rastreamento = this.rastreamentoRepository.findAllByEntrega(entrega.get());
            return rastreamento.stream().map(this::convertToDto).toList();
        }
        return null;
    }

    private Rastreamento criarRastreamento(Entrega entrega, RastreamentoDTO rastreamentoDTO, Endereco endereco){
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setEntrega(entrega);
        rastreamento.setDescricaoLocalizacao(rastreamentoDTO.descricaoLocalizacao());
        rastreamento.setEndereco(endereco);
        rastreamento.setDataHora(LocalDateTime.now());
        return rastreamento;
    }

    private RastreamentoResponse convertToDto(Rastreamento rastreamento){
        return new RastreamentoResponse(
                rastreamento.getId(),
                rastreamento.getDescricaoLocalizacao(),
                new EnderecoDTO(rastreamento.getEndereco()),
                rastreamento.getDataHora()
        );
    }

}
