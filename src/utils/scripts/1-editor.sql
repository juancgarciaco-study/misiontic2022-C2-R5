CREATE TABLE editor (
  edit_id INT PRIMARY KEY,
  edit_nombre VARCHAR(30) NOT NULL,
  edit_apellido VARCHAR(30) NOT NULL,
  edit_nacionalidad VARCHAR(50)
);
INSERT INTO editor 
  ( edit_id, edit_nombre, edit_apellido, edit_nacionalidad )
VALUES 
  (51, "Hayo","Miyazaki", "japones"),
  (52, "Joss", "Whedon", "estadounidense"),
  (53, "Christopher", "Nolan", "estadounidense"),
  (54, "Bong", "Joon-ho", "coreano"),
  (55, "Vincent", "Ward", "neozelandes")
;
