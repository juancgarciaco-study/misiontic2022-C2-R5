CREATE TABLE contenido (
  conte_id INT NOT NULL,
  conte_titulo VARCHAR(50) NOT NULL ,
  PRIMARY KEY (conte_id)
);
INSERT INTO contenido
  ( conte_id, conte_titulo)
VALUES 
  (101, 'Los Vengadores'),
  (102, 'Interestelar'),
  (103, 'El viaje de Chihiro'),
  (104, 'Parasitos'),
  (105, 'Mas alla de los sueños'),
  (151, 'The walking dead'),
  (152, 'Viaje a las estrellas: la serie original'),
  (153, 'Glow'),
  (154, 'La casa de papel'),
  (155, 'Friends'),
  (156, 'Arrow'),
  (157, 'The big bang theory'),
  (158, 'Vikingos')
;