-- PRODUCTO 1: Monstruo Deliciosa
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (nextval('productos_id_seq'), 'Monstera Deliciosa', 'Planta tropical con hojas perforadas...', 4500.0, 15, 'SKU-MON-01', true, 3, 'Grande', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (currval('productos_id_seq'), 'INTERIOR', 'Cada 10 días', 'Luz media indirecta', 3.0, 'Fácil', 'Todo el año');

-- PRODUCTO 2: Lavanda
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (nextval('productos_id_seq'), 'Lavanda Angustifolia', 'Arbusto aromático...', 850.0, 40, 'SKU-LAV-02', true, 10, 'Mediano', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (currval('productos_id_seq'), 'EXTERIOR', 'Dos veces por semana', 'Pleno sol', 0.8, 'Bajo', 'Verano');

-- PRODUCTO 3: Sansevieria
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (nextval('productos_id_seq'), 'Sansevieria Trifasciata', 'Conocida como Lengua de Suegra...', 1800.0, 25, 'SKU-SAN-03', true, 5, 'Mediano', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (currval('productos_id_seq'), 'INTERIOR', 'Mensual', 'Baja a alta luz', 1.2, 'Muy fácil', 'Invierno');

INSERT INTO clientes (nombre, email) VALUES ('Juan Perez', 'juan@email.com');