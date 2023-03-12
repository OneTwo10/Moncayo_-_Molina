CREATE TABLE usuarios (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  contraseña TEXT NOT NULL
);
INSERT INTO usuarios (nombre, contraseña) VALUES
  ('usuario1', 'contraseña1'),
  ('usuario2', 'contraseña2'),
  ('usuario3', 'contraseña3'),
  ('usuario4', 'contraseña4');
  SELECT * FROM usuarios;

SELECT name FROM sqlite_master WHERE type='table' AND name='usuarios';
