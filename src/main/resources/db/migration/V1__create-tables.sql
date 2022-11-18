CREATE TABLE IF NOT EXISTS compositores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS interpretes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS catalogos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS musicas (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS versoes (
    id SERIAL PRIMARY KEY,
    musica_id INT NOT NULL,
    FOREIGN KEY (musica_id) REFERENCES musicas (id)
);

CREATE TABLE IF NOT EXISTS musicas_compositores (
    musica_id INT NOT NULL,
    compositor_id INT NOT NULL,
    FOREIGN KEY (musica_id) REFERENCES musicas (id),
    FOREIGN KEY (compositor_id) REFERENCES compositores (id)
);

CREATE TABLE IF NOT EXISTS versoes_interpretes (
    versao_id INT NOT NULL,
    interprete_id INT NOT NULL,
    FOREIGN KEY (versao_id) REFERENCES versoes (id),
    FOREIGN KEY (interprete_id) REFERENCES interpretes (id)
);

CREATE TABLE IF NOT EXISTS catalogos_versoes (
    id SERIAL PRIMARY KEY,
    codigo INT NOT NULL,
    catalogo_id INT NOT NULL,
    versao_id INT NOT NULL,
    FOREIGN KEY (catalogo_id) REFERENCES catalogos (id),
    FOREIGN KEY (versao_id) REFERENCES versoes (id)
);

