CREATE TABLE doadores (
    id UUID PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    contato VARCHAR(100),
    tipo_doador VARCHAR(20) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);