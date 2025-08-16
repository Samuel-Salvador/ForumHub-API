CREATE TABLE Topicos(
    id INTEGER PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT,
    data_de_criacao DATE NOT NULL,
    estado_do_topico VARCHAR(50) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(50) NOT NULL
);