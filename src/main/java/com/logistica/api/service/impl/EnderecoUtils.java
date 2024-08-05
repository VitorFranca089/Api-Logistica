package com.logistica.api.service.impl;

import com.logistica.api.dto.EnderecoDTO;
import com.logistica.api.exception.CepNotFoundException;
import com.logistica.api.model.Endereco;
import com.logistica.api.repository.EnderecoRepository;
import com.logistica.api.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoUtils {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = obterEnderecoPeloCep(enderecoDTO.cep());
        atualizarEnderecoComDadosDTO(endereco, enderecoDTO);
        return enderecoRepository.save(endereco);
    }

    private Endereco obterEnderecoPeloCep(String cep) {
        Endereco endereco = this.viaCepService.getEndereco(cep);
        if(endereco.getCep() == null) throw new CepNotFoundException();
        return endereco;
    }

    private void atualizarEnderecoComDadosDTO(Endereco endereco, EnderecoDTO enderecoDTO) {
        if (!enderecoDTO.unidade().isEmpty()) {
            endereco.setUnidade(enderecoDTO.unidade());
        }
    }

}
