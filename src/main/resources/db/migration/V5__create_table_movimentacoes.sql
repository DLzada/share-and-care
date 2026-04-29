CREATE TABLE movimentacoes(
    id UUID PRIMARY KEY,
    item_id UUID NOT NULL,
    doador_id UUID,
    tipo VARCHAR(20) NOT NULL,
    quantidade INT NOT NULL,
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    observacao VARCHAR(255),
    CONSTRAINT fk_item_movimentado FOREIGN KEY (item_id) REFERENCES itens(id),
    CONSTRAINT fk_doador_movimentacao FOREIGN KEY (doador_id) REFERENCES doadores(id)
);