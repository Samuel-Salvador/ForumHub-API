CREATE TABLE Topicos(
    id INTEGER PRIMARY KEY,
    titulo VARCHAR(100),
    mensagem TEXT,
    data_de_criacao DATE,
    estado_do_topico VARCHAR(50),
    autor VARCHAR(100),
    curso VARCHAR(50)
);