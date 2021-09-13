CREATE TABLE libro (
  libro_id INT NOT NULL,
  libro_resumen VARCHAR(250) NOT NULL,
  libro_anio INT NOT NULL,
  libro_editor INT NOT NULL,
  PRIMARY KEY (libro_id),
  FOREIGN KEY (libro_editor) REFERENCES editor(edit_id),
  FOREIGN KEY (libro_id) REFERENCES contenido(conte_id)
);
INSERT INTO libro
  (libro_id, libro_resumen, libro_anio, libro_editor)
VALUES
  (101, 'Libro de superheroes basado en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra', 1990, 52),
  (102, 'Libro de ciencia fición, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajana traves de un agujero de gusano en busca de un nuevo hogar.', 2014, 53),
  (103, 'Libro de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.', 2001, 51),
  (104, 'Libro de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano', 2019, 54),
  (105, 'Libro de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.', 1998, 55)
;