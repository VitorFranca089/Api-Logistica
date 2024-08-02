package com.logistica.api.repository;

import com.logistica.api.model.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
    Optional<Endereco> findByCepAndUnidade(String cep, String unidade);
}
