CREATE SCHEMA IF NOT EXISTS financas;
USE financas;

-- Cria a tabela Categoria
CREATE TABLE IF NOT EXISTS categoria (
                                         id INT PRIMARY KEY AUTO_INCREMENT,
                                         nome VARCHAR(100) NOT NULL,
                                         descricao VARCHAR(255)
);

-- Insere alguns dados de exemplo na tabela Categoria
INSERT INTO categoria (nome, descricao) VALUES
                                            ('Alimentação', 'Gastos com alimentação'),
                                            ('Transporte', 'Gastos com transporte'),
                                            ('Lazer', 'Gastos com lazer');

-- Cria a tabela Despesa
CREATE TABLE IF NOT EXISTS despesa (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       categoria_id INT NOT NULL,
                                       data DATE NOT NULL,
                                       descricao VARCHAR(255) NOT NULL,
                                       valor DECIMAL(10, 2) NOT NULL,
                                       FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

-- Insere alguns dados de exemplo na tabela Despesa
INSERT INTO despesa (categoria_id, data, descricao, valor) VALUES
                                                               (1, '2023-07-25', 'Restaurante', 50.00),
                                                               (2, '2023-07-24', 'Uber', 25.00),
                                                               (3, '2023-07-23', 'Cinema', 20.00);

-- Cria a tabela Receita
CREATE TABLE IF NOT EXISTS receita (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       categoria_id INT NOT NULL,
                                       data DATE NOT NULL,
                                       descricao VARCHAR(255) NOT NULL,
                                       valor DECIMAL(10, 2) NOT NULL,
                                       FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

-- Insere alguns dados de exemplo na tabela Receita
INSERT INTO receita (descricao, valor, data, categoria_id) VALUES
                                                               ('Salário', 3000.00, '2023-07-25', 1),
                                                               ('Restaurante', 50.00, '2023-07-24', 1),
                                                               ('Uber', 25.00, '2023-07-23', 2),
                                                               ('Cinema', 20.00, '2023-07-22', 3);

-- Cria a tabela Usuario
CREATE TABLE IF NOT EXISTS usuario (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       meta_financeira DECIMAL(10, 2)
);

-- Insere alguns dados de exemplo na tabela Usuario
INSERT INTO usuario (meta_financeira) VALUES
                                          (5000.00),
                                          (8000.00);
