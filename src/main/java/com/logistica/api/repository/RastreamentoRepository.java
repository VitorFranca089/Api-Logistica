package com.logistica.api.repository;

import com.logistica.api.model.Entrega;
import com.logistica.api.model.Rastreamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RastreamentoRepository extends CrudRepository<Rastreamento, Integer> {
    List<Rastreamento> findAllByEntrega(Entrega entrega);
}
