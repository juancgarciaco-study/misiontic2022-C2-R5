CREATE TABLE usuario (
  usu_username VARCHAR(50) NOT NULL PRIMARY KEY,
  usu_nombre VARCHAR(30) NOT NULL,
  usu_apellido VARCHAR(30),
  usu_email VARCHAR(100),
  usu_celular VARCHAR(10),
  usu_secret VARCHAR(80) NOT NULL,
  usu_fechanacimiento DATE
);
INSERT INTO
  usuario ( usu_username, usu_nombre, usu_apellido, usu_email, usu_celular, usu_secret, usu_fechanacimiento)
VALUES 
  ("lucky", "Pedro","Perez", "lucky@maiil.com", "3112111111", 'lucky-pass*', DATE('1981-12-01') ),
  ("malopez", "Maria","Lopez", "malopez@maiil.com", "3112111112", 'malopez-pass*', DATE('1983-12-03') ),
  ("diva", "Ana","Diaz", "diva@maiil.com", NULL, 'diva-pass*', DATE('1985-12-05') ),
  ("dreamer", "Luis","Rojas", NULL, "3112111114", 'dreamer-pass*', DATE('1987-12-07') ),
  ("ninja", "Andres","Cruz", "ninja@maiil.com", "3112111115", 'ninja-pass*', DATE('1991-12-09') ),
  ("neon", "Nelson","Ruiz", "neon@maiil.com", "3112111116", 'ninja-pass*', DATE('1993-12-11') ),
  ("rose", "Claudia","Mendez", "rose@maiil.com", "3112111117", 'ninja-pass*', DATE('1995-12-13') ),
  ("green", "Jorge","Rodriguez", "green@maiil.com", "3112111118", 'ninja-pass*', DATE('1997-12-17') )
 ;