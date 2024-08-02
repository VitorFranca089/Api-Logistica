package com.logistica.api.service.impl;

import com.logistica.api.dto.EnderecoDTO;
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
        Endereco endereco = this.viaCepService.getEndereco(enderecoDTO.cep());
        if(!enderecoDTO.unidade().isEmpty()) endereco.setUnidade(enderecoDTO.unidade());
        return enderecoRepository.save(endereco);
    }

}
