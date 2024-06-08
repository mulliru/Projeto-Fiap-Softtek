-- Código para processar o esquema de banco de dados arquitetado para a terceira sprint do projeto challenge proposto pela softtek.
-- O banco de dados terá papel fundamental no sistema de integração com JAVA

-- Integrantes:
-- Murillo Ferreira Ramos      RM: 553315
-- Pedro Luiz Prado            RM: 553874
-- William Kenzo Hayashi       RM: 552659

-- Removendo tabelas na ordem correta para evitar problemas de dependência de chave estrangeira
DROP TABLE suporte;
DROP TABLE downloadproduto;
DROP TABLE login;
DROP TABLE cliente;
DROP TABLE cep;
DROP TABLE atendente; 

-- Criação das tabelas
CREATE TABLE cep(
    idcep INT PRIMARY KEY,
    pais VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    cep CHAR(9) NOT NULL,
    numero INT
);

CREATE TABLE cliente(
    celular VARCHAR(15) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL,
    rg CHAR(9) NOT NULL,
    idcep INT,
    FOREIGN KEY (idcep) REFERENCES cep(idcep)
);

CREATE TABLE login(
    email VARCHAR(100) PRIMARY KEY,
    senha VARCHAR(50) NOT NULL,
    celular_cliente VARCHAR(15) UNIQUE,
    FOREIGN KEY (celular_cliente) REFERENCES cliente(celular)
);

CREATE TABLE downloadproduto(
    idproduto INT PRIMARY KEY,
    hrsaquisicao TIMESTAMP,
    diaaquisicao DATE,
    email_login VARCHAR(100) UNIQUE,
    FOREIGN KEY (email_login) REFERENCES login(email)
);

CREATE TABLE atendente( 
    idfuncionario INT PRIMARY KEY,
    nomeatendente VARCHAR(100) NOT NULL,
    cargo VARCHAR(50)
);

CREATE TABLE suporte(
    idAtendimento INT PRIMARY KEY,
    hrsinicio TIMESTAMP,
    hrstermino TIMESTAMP,
    notafeedback INT,
    id_atendente INT,
    FOREIGN KEY (id_atendente) REFERENCES atendente(idfuncionario)
);

-- Visualizando as Tabelas criadas
SELECT * FROM cep;
SELECT * FROM cliente;
SELECT * FROM login;
SELECT * FROM downloadproduto;
SELECT * FROM atendente; 
SELECT * FROM suporte;

-- Realizando os inserts nas tabelas

-- Inserts na tabela cep
INSERT INTO cep(idcep, pais, estado, logradouro, cep, numero) VALUES (1, 'Brasil', 'SP', 'Rua 6', '12345678', 6);
INSERT INTO cep(idcep, pais, estado, logradouro, cep, numero) VALUES (2, 'Brasil', 'SP', 'Rua 7', '12345678', 7);
INSERT INTO cep(idcep, pais, estado, logradouro, cep, numero) VALUES (3, 'Brasil', 'SP', 'Rua 8', '12345678', 8);
INSERT INTO cep(idcep, pais, estado, logradouro, cep, numero) VALUES (4, 'Brasil', 'SP', 'Rua 9', '12345678', 9);
INSERT INTO cep(idcep, pais, estado, logradouro, cep, numero) VALUES (5, 'Brasil', 'SP', 'Rua 10', '12345678', 10);

-- Inserts na tabela cliente
INSERT INTO cliente(celular, nome, cpf, rg, idcep) VALUES ('11111111111', 'Cliente 1', '12345678901', '123456789', 1);
INSERT INTO cliente(celular, nome, cpf, rg, idcep) VALUES ('22222222222', 'Cliente 2', '23456789012', '234567890', 2);
INSERT INTO cliente(celular, nome, cpf, rg, idcep) VALUES ('33333333333', 'Cliente 3', '34567890123', '345678901', 3);
INSERT INTO cliente(celular, nome, cpf, rg, idcep) VALUES ('44444444444', 'Cliente 4', '45678901234', '456789012', 4);
INSERT INTO cliente(celular, nome, cpf, rg, idcep) VALUES ('55555555555', 'Cliente 5', '56789012345', '567890123', 5);

-- Inserts na tabela login
INSERT INTO login(email, senha, celular_cliente) VALUES ('email1@example.com', 'senha1', '11111111111');
INSERT INTO login(email, senha, celular_cliente) VALUES ('email2@example.com', 'senha2', '22222222222');
INSERT INTO login(email, senha, celular_cliente) VALUES ('email3@example.com', 'senha3', '33333333333');
INSERT INTO login(email, senha, celular_cliente) VALUES ('email4@example.com', 'senha4', '44444444444');
INSERT INTO login(email, senha, celular_cliente) VALUES ('email5@example.com', 'senha5', '55555555555');

-- Inserts na tabela atendente
INSERT INTO atendente(idfuncionario, nomeatendente, cargo) VALUES (1, 'Atendente 1', 'Cargo 1');
INSERT INTO atendente(idfuncionario, nomeatendente, cargo) VALUES (2, 'Atendente 2', 'Cargo 2');
INSERT INTO atendente(idfuncionario, nomeatendente, cargo) VALUES (3, 'Atendente 3', 'Cargo 3');
INSERT INTO atendente(idfuncionario, nomeatendente, cargo) VALUES (4, 'Atendente 4', 'Cargo 4');
INSERT INTO atendente(idfuncionario, nomeatendente, cargo) VALUES (5, 'Atendente 5', 'Cargo 5');

-- Inserts na tabela downloadproduto
INSERT INTO downloadproduto(idproduto, hrsaquisicao, diaaquisicao, email_login) VALUES (1, TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('22-01-2001', 'DD-MM-YYYY'), 'email1@example.com');
INSERT INTO downloadproduto(idproduto, hrsaquisicao, diaaquisicao, email_login) VALUES (2, TO_DATE('11:00:00', 'HH24:MI:SS'), TO_DATE('22-02-2002', 'DD-MM-YYYY'), 'email2@example.com');
INSERT INTO downloadproduto(idproduto, hrsaquisicao, diaaquisicao, email_login) VALUES (3, TO_DATE('12:00:00', 'HH24:MI:SS'), TO_DATE('22-03-2003', 'DD-MM-YYYY'), 'email3@example.com');
INSERT INTO downloadproduto(idproduto, hrsaquisicao, diaaquisicao, email_login) VALUES (4, TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('22-04-2004', 'DD-MM-YYYY'), 'email4@example.com');
INSERT INTO downloadproduto(idproduto, hrsaquisicao, diaaquisicao, email_login) VALUES (5, TO_DATE('14:00:00', 'HH24:MI:SS'), TO_DATE('22-05-2005', 'DD-MM-YYYY'), 'email5@example.com');

-- Inserts na tabela suporte
INSERT INTO suporte(idAtendimento, hrsinicio, hrstermino, notafeedback, id_atendente) VALUES (1, TO_DATE('09:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 5, 1);
INSERT INTO suporte(idAtendimento, hrsinicio, hrstermino, notafeedback, id_atendente) VALUES (2, TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('11:00:00', 'HH24:MI:SS'), 4, 2);
INSERT INTO suporte(idAtendimento, hrsinicio, hrstermino, notafeedback, id_atendente) VALUES (3, TO_DATE('11:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 3, 3);
INSERT INTO suporte(idAtendimento, hrsinicio, hrstermino, notafeedback, id_atendente) VALUES (4, TO_DATE('12:00:00', 'HH24:MI:SS'), TO_DATE('13:00:00', 'HH24:MI:SS'), 2, 4);
INSERT INTO suporte(idAtendimento, hrsinicio, hrstermino, notafeedback, id_atendente) VALUES (5, TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('14:00:00', 'HH24:MI:SS'), 1, 5);

-- Visualizando as Tabelas populadas
SELECT * FROM cep;
SELECT * FROM login;
SELECT * FROM cliente;
SELECT * FROM downloadproduto;
SELECT * FROM suporte;
SELECT * FROM atendente;

-- Relatórios
-- 1 relatório usando classificação crescente de dados
SELECT *
FROM cliente
ORDER BY nome ASC;

-- 1 relatório usando BETWEEN e LIKE
SELECT *
FROM cliente
WHERE nome BETWEEN 'A' AND 'Z';

-- 1 relatório usando função caractere - a seu critério 
SELECT UPPER(nome) AS nome_maiusculo, celular, cpf, rg, idcep
FROM cliente;

-- 1 relatório usando função data - a seu critério 
SELECT *
FROM downloadproduto
WHERE diaaquisicao = DATE '2001-01-22';

-- 1 relatório usando GROUP BY
SELECT id_atendente, COUNT(*) as total_atendimentos
FROM suporte
GROUP BY id_atendente;

-- 1 relatório usando junção de equivalência
SELECT c.nome, c.celular, c.cpf, c.rg, c.idcep, cep.logradouro, cep.estado, cep.pais
FROM cliente c
INNER JOIN cep ON c.idcep = cep.idcep;

-- 1 relatório usando junção de diferença
SELECT c.nome, c.celular, c.cpf, c.rg, c.idcep
FROM cliente c
LEFT JOIN suporte s ON c.celular = s.idAtendimento
WHERE s.idAtendimento IS NULL;
