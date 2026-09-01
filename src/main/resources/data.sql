-- ==========================================
-- USERS
-- ==========================================

INSERT INTO tb_user (name, phone, email, password)
VALUES
    ('Igor Schmitz', '41999999999', 'igor@email.com', '123456'),
    ('Jessica Schmitz', '41988888888', 'jessica@email.com', '123456'),
    ('Suvas Silva', '24977777777', 'suvas@email.com', '123456');


-- ==========================================
-- CATEGORIES
-- ==========================================

INSERT INTO tb_category (name, description)
VALUES
    ('Tênis', 'Calçados esportivos e casuais'),
    ('Bota', 'Botas masculinas e femininas'),
    ('Sandália', 'Sandálias femininas');


-- ==========================================
-- ADDRESSES
-- ==========================================

-- Igor
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('81050-300', 'Rua Jaime Rodrigues da Rocha', '1883',
     'Capão Raso', 'Curitiba', NULL, NULL, 1);


-- Jessica
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('81020-180', 'Rua Orlindo Sequinel', '1309',
     'Capão Raso', 'Curitiba', NULL, NULL, 2);


-- Suvas
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('27260-000', 'Rua Dezessete', '250',
     'Vila Santa Cecília', 'Volta Redonda', NULL, NULL, 3);


-- ==========================================
-- STORE ADDRESSES
-- ==========================================

-- Andaraki Palladium
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('80220-000', 'Avenida Presidente Kennedy', '4121',
     'Portão', 'Curitiba', NULL, NULL, NULL);


-- Andaraki Fazendinha
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('81320-000', 'Avenida Frederico Lambertucci', '2000',
     'Fazendinha', 'Curitiba', NULL, NULL, NULL);


-- Andaraki Hauer
INSERT INTO tb_address
(cep, rua, numero, bairro, cidade, longitude, latitude, user_id)
VALUES
    ('81610-000', 'Rua Marechal Floriano Peixoto', '5000',
     'Hauer', 'Curitiba', NULL, NULL, NULL);


-- ==========================================
-- PRODUCTS
-- ==========================================

-- NIKE
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Nike Air Max', 'Nike',
     'Tênis Nike Air Max para uso casual e esportivo',
     'nike-air-max.jpg', 699.90, TRUE, 1),

    ('Nike Revolution', 'Nike',
     'Tênis Nike Revolution confortável para corrida e academia',
     'nike-revolution.jpg', 399.90, TRUE, 1);


-- PUMA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Puma Smash', 'Puma',
     'Tênis Puma Smash casual',
     'puma-smash.jpg', 299.90, TRUE, 1),

    ('Puma Flyer', 'Puma',
     'Tênis Puma Flyer esportivo',
     'puma-flyer.jpg', 349.90, TRUE, 1);


-- ADIDAS
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Adidas Grand Court', 'Adidas',
     'Tênis Adidas Grand Court casual',
     'adidas-grand-court.jpg', 379.90, TRUE, 1),

    ('Adidas Runfalcon', 'Adidas',
     'Tênis Adidas Runfalcon para corrida',
     'adidas-runfalcon.jpg', 329.90, TRUE, 1);


-- BOTTERO - SANDÁLIA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Sandália Bottero', 'Bottero',
     'Sandália feminina Bottero',
     'bottero-sandalia.jpg', 249.90, TRUE, 3);


-- DAKOTA - SANDÁLIA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Sandália Dakota', 'Dakota',
     'Sandália feminina Dakota',
     'dakota-sandalia.jpg', 229.90, TRUE, 3);


-- MISSISSIPI - SANDÁLIA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Sandália Mississipi', 'Mississipi',
     'Sandália feminina Mississipi',
     'mississipi-sandalia.jpg', 199.90, TRUE, 3);


-- BOTTERO - BOTA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Bota Bottero', 'Bottero',
     'Bota feminina Bottero',
     'bottero-bota.jpg', 499.90, TRUE, 2);


-- DAKOTA - BOTA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Bota Dakota', 'Dakota',
     'Bota feminina Dakota',
     'dakota-bota.jpg', 449.90, TRUE, 2);


-- PEGADA - BOTA
INSERT INTO tb_product
(name, marca, description, image_url, price, active, category_id)
VALUES
    ('Bota Pegada', 'Pegada',
     'Bota masculina Pegada',
     'pegada-bota.jpg', 399.90, TRUE, 2);


-- ==========================================
-- PRODUCT VARIANTS
-- ==========================================

-- Nike Air Max
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Preto', 'NIKE-AIRMAX-38-PRETO', 699.90, TRUE, 1),
    ('39', 'Preto', 'NIKE-AIRMAX-39-PRETO', 699.90, TRUE, 1),
    ('40', 'Preto', 'NIKE-AIRMAX-40-PRETO', 699.90, TRUE, 1),
    ('41', 'Branco', 'NIKE-AIRMAX-41-BRANCO', 699.90, TRUE, 1);


-- Nike Revolution
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Cinza', 'NIKE-REV-38-CINZA', 399.90, TRUE, 2),
    ('39', 'Cinza', 'NIKE-REV-39-CINZA', 399.90, TRUE, 2),
    ('40', 'Preto', 'NIKE-REV-40-PRETO', 399.90, TRUE, 2),
    ('41', 'Preto', 'NIKE-REV-41-PRETO', 399.90, TRUE, 2);


-- Puma Smash
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Branco', 'PUMA-SMASH-38-BRANCO', 299.90, TRUE, 3),
    ('39', 'Branco', 'PUMA-SMASH-39-BRANCO', 299.90, TRUE, 3),
    ('40', 'Preto', 'PUMA-SMASH-40-PRETO', 299.90, TRUE, 3);


-- Puma Flyer
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Preto', 'PUMA-FLYER-38-PRETO', 349.90, TRUE, 4),
    ('39', 'Preto', 'PUMA-FLYER-39-PRETO', 349.90, TRUE, 4),
    ('40', 'Azul', 'PUMA-FLYER-40-AZUL', 349.90, TRUE, 4);


-- Adidas Grand Court
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Branco', 'ADIDAS-GC-38-BRANCO', 379.90, TRUE, 5),
    ('39', 'Branco', 'ADIDAS-GC-39-BRANCO', 379.90, TRUE, 5),
    ('40', 'Preto', 'ADIDAS-GC-40-PRETO', 379.90, TRUE, 5);


-- Adidas Runfalcon
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('38', 'Preto', 'ADIDAS-RUN-38-PRETO', 329.90, TRUE, 6),
    ('39', 'Preto', 'ADIDAS-RUN-39-PRETO', 329.90, TRUE, 6),
    ('40', 'Cinza', 'ADIDAS-RUN-40-CINZA', 329.90, TRUE, 6);


-- Bottero Sandália
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('35', 'Preto', 'BOTTERO-SAND-35-PRETO', 249.90, TRUE, 7),
    ('36', 'Preto', 'BOTTERO-SAND-36-PRETO', 249.90, TRUE, 7),
    ('37', 'Bege', 'BOTTERO-SAND-37-BEGE', 249.90, TRUE, 7);


-- Dakota Sandália
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('35', 'Preto', 'DAKOTA-SAND-35-PRETO', 229.90, TRUE, 8),
    ('36', 'Preto', 'DAKOTA-SAND-36-PRETO', 229.90, TRUE, 8),
    ('37', 'Nude', 'DAKOTA-SAND-37-NUDE', 229.90, TRUE, 8);


-- Mississipi Sandália
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('35', 'Preto', 'MISS-SAND-35-PRETO', 199.90, TRUE, 9),
    ('36', 'Preto', 'MISS-SAND-36-PRETO', 199.90, TRUE, 9),
    ('37', 'Bege', 'MISS-SAND-37-BEGE', 199.90, TRUE, 9);


-- Bottero Bota
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('37', 'Preto', 'BOTTERO-BOTA-37-PRETO', 499.90, TRUE, 10),
    ('38', 'Preto', 'BOTTERO-BOTA-38-PRETO', 499.90, TRUE, 10),
    ('39', 'Marrom', 'BOTTERO-BOTA-39-MARROM', 499.90, TRUE, 10);


-- Dakota Bota
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('37', 'Preto', 'DAKOTA-BOTA-37-PRETO', 449.90, TRUE, 11),
    ('38', 'Preto', 'DAKOTA-BOTA-38-PRETO', 449.90, TRUE, 11),
    ('39', 'Marrom', 'DAKOTA-BOTA-39-MARROM', 449.90, TRUE, 11);


-- Pegada Bota
INSERT INTO tb_product_variant
(size, color, sku, price, active, product_id)
VALUES
    ('39', 'Preto', 'PEGADA-BOTA-39-PRETO', 399.90, TRUE, 12),
    ('40', 'Preto', 'PEGADA-BOTA-40-PRETO', 399.90, TRUE, 12),
    ('41', 'Marrom', 'PEGADA-BOTA-41-MARROM', 399.90, TRUE, 12);


-- ==========================================
-- STORES
-- ==========================================

INSERT INTO tb_store
(name, cnpj, phone, active, address_id)
VALUES
    ('Andaraki Palladium',
     '00.000.000/0001-01',
     '4130000001',
     TRUE,
     4);


INSERT INTO tb_store
(name, cnpj, phone, active, address_id)
VALUES
    ('Andaraki Fazendinha',
     '00.000.000/0001-02',
     '4130000002',
     TRUE,
     5);


INSERT INTO tb_store
(name, cnpj, phone, active, address_id)
VALUES
    ('Andaraki Hauer',
     '00.000.000/0001-03',
     '4130000003',
     TRUE,
     6);