-- PRODUCTO 1: Monstruo Deliciosa
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (1, 'Monstera Deliciosa', 'Planta tropical con hojas perforadas icónicas, ideal para rincones con luz indirecta.', 4500.0, 15, 'SKU-MON-01', true, 3, 'Grande', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (1, 'INTERIOR', 'Cada 10 días', 'Luz media indirecta', 3.0, 'Fácil', 'Todo el año');

-- PRODUCTO 2: Lavanda
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (2, 'Lavanda Angustifolia', 'Arbusto aromático con flores púrpuras, atrae polinizadores.', 850.0, 40, 'SKU-LAV-02', true, 10, 'Mediano', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (2, 'EXTERIOR', 'Dos veces por semana', 'Pleno sol', 0.8, 'Bajo', 'Verano');

-- PRODUCTO 3: Sansevieria
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (3, 'Sansevieria Trifasciata', 'Conocida como Lengua de Suegra, es casi indestructible y purifica el aire.', 1800.0, 25, 'SKU-SAN-03', true, 5, 'Mediano', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (3, 'INTERIOR', 'Mensual', 'Baja a alta luz', 1.2, 'Muy fácil', 'Invierno');

-- PRODUCTO 4: Helecho de Boston
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (4, 'Helecho de Boston', 'Planta colgante frondosa que adora la humedad ambiental.', 1200.0, 12, 'SKU-HEL-04', true, 4, 'Mediano', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (4, 'INTERIOR', 'Frecuente (mantener húmedo)', 'Sombra parcial', 0.6, 'Medio', 'Primavera');

-- PRODUCTO 5: Suculenta Echeveria
INSERT INTO productos (id, nombre, descripcion, precio, stock, codigosku, activo, min_stock, tamaño, tipo_producto, fecha_creacion, fecha_actualizacion)
VALUES (5, 'Echeveria Elegans', 'Suculenta en forma de roseta color verde azulado.', 600.0, 50, 'SKU-SUC-05', true, 10, 'Pequeño', 'PLANTA', NOW(), NOW());

INSERT INTO plantas (producto_id, tipo_planta, frecuencia_riego, requerimientos_luz, altura_maxima, nivel_cuidado, temporada)
VALUES (5, 'SUCULENTA', 'Solo cuando la tierra esté seca', 'Sol directo', 0.2, 'Bajo', 'Otoño');