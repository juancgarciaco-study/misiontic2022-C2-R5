CREATE TABLE revista (
  revta_id INT NOT NULL,
  revta_temporada INT NOT NULL,
  revta_episodio INT NOT NULL,
  PRIMARY KEY (revta_id),
  FOREIGN KEY (revta_id) REFERENCES contenido(conte_id)
);
INSERT INTO revista
  (revta_id, revta_temporada, revta_episodio)
VALUES
  (151, 11, 153),
  (152, 3, 80),
  (153, 3, 30),
  (154, 4, 31),
  (155, 10, 236),
  (156, 8, 170),
  (157, 12, 279),
  (158, 6, 79)
;