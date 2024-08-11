package com.logistica.api.service.impl;

import com.logistica.api.dto.AtualizarStatusDTO;
import com.logistica.api.dto.EnderecoDTO;
import com.logistica.api.dto.EntregaDTO;
import com.logistica.api.dto.response.EntregaResponse;
import com.logistica.api.dto.response.UsuarioResponse;
import com.logistica.api.model.Endereco;
import com.logistica.api.model.Entrega;
import com.logistica.api.model.Usuario;
import com.logistica.api.repository.EnderecoRepository;
import com.logistica.api.repository.EntregaRepository;
import com.logistica.api.service.AuthenticationService;
import com.logistica.api.service.EntregaService;
import com.logistica.api.util.EnderecoUtils;
import com.logistica.api.util.UsuarioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EnderecoUtils enderecoUtils;

    @Autowired
    private UsuarioUtils usuarioUtils;

    @Override
    public EntregaResponse cadastrarEntrega(EntregaDTO entregaDTO) {
        Usuario usuario = this.authenticationService.registerCliente(entregaDTO.emailUsuario());
        Endereco origemEndereco = this.enderecoRepository.findByCepAndUnidade(entregaDTO.origemCep().cep(), entregaDTO.origemCep().unidade()).
                orElseGet(() -> enderecoUtils.criarEndereco(entregaDTO.origemCep()));
        Endereco destinoEndereco = this.enderecoRepository.findByCepAndUnidade(entregaDTO.destinoCep().cep(), entregaDTO.destinoCep().unidade()).
                orElseGet(() -> enderecoUtils.criarEndereco(entregaDTO.destinoCep()));
        Entrega entrega = criarEntrega(entregaDTO, origemEndereco, destinoEndereco, usuario);
        this.entregaRepository.save(entrega);
        return convertToDto(entrega);
    }

    @Override
    public List<EntregaResponse> listarEntregas(){
         List<Entrega> entregas = (List<Entrega>) this.entregaRepository.findAll();
         return entregas.stream().map(this::convertToDto).toList();
    }

    @Override
    public EntregaResponse detalharEntrega(Integer idEntrega, Usuario usuario){
        return entregaRepository.findById(idEntrega)
                .filter(entrega -> usuarioUtils.usuarioPodeAcessarEntrega(entrega, usuario))
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public EntregaResponse atualizarStatusEntrega(Integer idEntrega, AtualizarStatusDTO statusDTO){
        Optional<Entrega> entrega = this.entregaRepository.findById(idEntrega);
        if(entrega.isPresent()){
            Entrega entregaAtualizada = entrega.get();
            entregaAtualizada.setStatus(statusDTO.status());
            this.entregaRepository.save(entregaAtualizada);
            return this.convertToDto(entregaAtualizada);
        }
        return null;
    }

    @Override
    public void deletarEntrega(Integer idEntrega){
        Optional<Entrega> entrega = this.entregaRepository.findById(idEntrega);
        entrega.ifPresent(e -> this.entregaRepository.delete(e));
    }

    private EntregaResponse convertToDto(Entrega entrega) {
        Usuario u = entrega.getUsuario();
        return new EntregaResponse(
                entrega.getId(),
                entrega.getStatus(),
                entrega.getLojaResponsavel(),
                new EnderecoDTO(entrega.getOrigem()),
                new EnderecoDTO(entrega.getDestino()),
                entrega.getDataCriacao(),
                new UsuarioResponse(u.getId(), u.getEmail(), u.getRole())
        );
    }

    private Entrega criarEntrega(EntregaDTO entregaDTO, Endereco origemEndereco, Endereco destinoEndereco, Usuario usuario) {
        Entrega entrega = new Entrega();
        entrega.setStatus(entregaDTO.status());
        entrega.setLojaResponsavel(entregaDTO.lojaResponsavel());
        entrega.setOrigem(origemEndereco);
        entrega.setDestino(destinoEndereco);
        entrega.setDataCriacao(LocalDateTime.now());
        entrega.setUsuario(usuario);
        return entrega;
    }

}
