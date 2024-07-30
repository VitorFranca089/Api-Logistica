package com.logistica.api.dto;

import com.logistica.api.model.Endereco;

public record EnderecoDTO (
    String cep,
    String logradouro,
    String complemento,
    String unidade,
    String bairro,
    String localidade,
    String uf,
    String ibge,
    String gia,
    String ddd,
    String siafi
){
    public EnderecoDTO(Endereco e){
        this(e.getCep(),
             e.getLogradouro(),
             e.getComplemento(),
             e.getUnidade(),
             e.getBairro(),
             e.getLocalidade(),
             e.getUf(),
             e.getIbge(),
             e.getGia(),
             e.getDdd(),
             e.getSiafi()
        );
    }
}