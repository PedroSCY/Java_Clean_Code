CREATE TABLE produtos(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR (255),
    preco DECIMAL(10,2) NOT NULL,
    inserido_em TIMESTAMP NOT NULL,
    categoria ENUM('ELETRONICO', 'ROUPA', 'ESCRITORIO', 'MOVEIS') NOT NULL,
    id_usuario INTEGER DEFAULT 1
);

INSERT INTO produtos (nome, descricao, preco, inserido_em, categoria) VALUES
('Smart TV 50"', 'Smart TV 50" 4K', 2799.90, CURRENT_TIMESTAMP(), 'ELETRONICO'),
('Camiseta Polo', 'Camiseta Polo Azul Marinho', 89.90, CURRENT_TIMESTAMP(), 'ROUPA'),
('Livro Arquitetura Limpa', 'Livro Arquitetura Limpa - Robert C. Martin', 159.90, CURRENT_TIMESTAMP(), 'ESCRITORIO');