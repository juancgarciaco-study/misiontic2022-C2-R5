CREATE TABLE publicacion (
  publ_usuario VARCHAR(50) NOT NULL,
  publ_contenido INT NOT NULL,
  publ_fechalectura DATETIME NOT NULL,
  FOREIGN KEY (publ_contenido) REFERENCES contenido(conte_id)
);
INSERT INTO publicacion
  ( publ_usuario, publ_contenido, publ_fechalectura )
VALUES
  ('lucky', 101, '2017-10-25 20:00:00'),
  ('lucky', 104, '2019-03-15 18:30:00'),
  ('lucky', 154, '2019-05-20 20:30:00'),
  ('malopez', 101, '2018-05-20 20:30:00'),
  ('malopez', 154, '2020-01-20 20:30:00'),
  ('diva', 102, '2019-05-20 20:30:00'),
  ('diva', 103, '2018-06-22 21:30:00'),
  ('diva', 151, '2020-03-17 15:30:20'),
  ('dreamer', 151, '2020-03-17 15:30:20'),
  ('dreamer', 152, '2020-04-10 18:30:20'),
  ('ninja', 153, '2020-02-17 20:30:20'),
  ('ninja', 154, '2020-02-20 16:30:20'),
  ('ninja', 156, '2020-03-27 18:30:20'),
  ('rose', 155, '2020-03-20 21:30:20'),
  ('green', 102, '2020-01-10 17:30:20'),
  ('green', 104, '2020-02-15 20:30:20'),
  ('green', 105, '2020-03-17 18:30:20')
;