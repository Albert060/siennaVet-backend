-- Insert sample data to test the schema
INSERT INTO clientes (nombre, apellido, dni, direccion, telefono, codigo_postal) VALUES
('Juan', 'Pérez', '12345678A', 'Calle Falsa 123', '600123456', '28001'),
('María', 'González', '87654321B', 'Avenida Real 456', '600987654', '28002');

INSERT INTO vets (nombre, apellido, dni, sexo, num_colegiado, email, contrasena, telefono, fecha_inicio) VALUES
('Carlos', 'López', '11111111C', 'H', 'COL12345', 'carlos@veterinaria.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', '600111222', '2023-01-15');

INSERT INTO razas (tipo_raza, nombre) VALUES
('Perro', 'Labrador'),
('Gato', 'Persa');

INSERT INTO jaulas (tamano, disponibilidad) VALUES
('Grande', 'Libre'),
('Mediana', 'Ocupada');

INSERT INTO fichas (nombre, sexo, edad, peso, chip, id_raza, id_cliente) VALUES
('Bobby', 'M', '3 años', '25kg', 'CHIP001', 1, 1),
('Luna', 'H', '2 años', '4kg', 'CHIP002', 2, 2);