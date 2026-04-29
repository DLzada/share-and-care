CREATE TABLE itens (
    id UUID PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    unidade_medida VARCHAR(20) NOT NULL,
    categoria_id BIGINT NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);