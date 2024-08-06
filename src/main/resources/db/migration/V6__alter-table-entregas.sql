ALTER TABLE entregas
ADD COLUMN usuario_id INT;

ALTER TABLE entregas
ADD CONSTRAINT fk_entregas_usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios(id);
