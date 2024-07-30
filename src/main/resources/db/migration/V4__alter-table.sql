ALTER TABLE entregas
ADD CONSTRAINT fk_entregas_origem
FOREIGN KEY (origem_id) REFERENCES enderecos(id);

ALTER TABLE entregas
ADD CONSTRAINT fk_entregas_destino
FOREIGN KEY (destino_id) REFERENCES enderecos(id);

ALTER TABLE rastreamento
ADD CONSTRAINT fk_rastreamento_pedido
FOREIGN KEY (entrega_id) REFERENCES entregas(id);

ALTER TABLE rastreamento
ADD CONSTRAINT fk_rastreamento_endereco
FOREIGN KEY (endereco_id) REFERENCES enderecos(id);