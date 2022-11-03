DROP TABLE IF EXISTS test;

CREATE TABLE test (
  id INT PRIMARY KEY,
  NOME VARCHAR(250) NOT NULL,
  POSICAO INTEGER NOT NULL
);

INSERT INTO test (ID, NOME, POSICAO) VALUES
  (1, 'Player1', 1),
  (2, 'Player2', 1),
  (3, 'Player3', 1),
  (4, 'Player4', 1);