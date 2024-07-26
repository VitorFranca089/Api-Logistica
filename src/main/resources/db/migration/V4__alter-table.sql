ALTER TABLE pedidos
ADD CONSTRAINT fk_pedidos_origem
FOREIGN KEY (origem_id) REFERENCES enderecos(id);

ALTER TABLE pedidos
ADD CONSTRAINT fk_pedidos_destino
FOREIGN KEY (destino_id) REFERENCES enderecos(id);

ALTER TABLE rastreamento
ADD CONSTRAINT fk_rastreamento_pedido
FOREIGN KEY (pedido_id) REFERENCES pedidos(id);

ALTER TABLE rastreamento
ADD CONSTRAINT fk_rastreamento_endereco
FOREIGN KEY (endereco_id) REFERENCES enderecos(id);