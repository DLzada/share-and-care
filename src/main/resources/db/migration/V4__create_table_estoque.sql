CREATE TABLE estoque(
    id UUID PRIMARY KEY,
    item_id UUID UNIQUE,
    quantidade_atual INT NOT NULL DEFAULT 0,
   ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_item_estoque FOREIGN KEY (item_id) REFERENCES itens(id)
);