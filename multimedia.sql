-- object: Pelicula | type: TABLE --
CREATE TABLE Pelicula (
    nombrePelicula varchar(50) NOT NULL,
    sinopsis varchar(500) NOT NULL,
    paginaOficial varchar(50),
    tituloOriginal varchar(50),
    genero varchar(50) NOT NULL,
    nacionalidad varchar(50) NOT NULL,
    duracion integer NOT NULL,
    anho integer NOT NULL,
    distribuidora varchar(50),
    director varchar(50) NOT NULL,
    clasificacionEdad smallint NOT NULL,
    otrosDatos varchar(200) NOT NULL,
    actores varchar(200) NOT NULL,
    url_image varchar(500) NOT NULL,
    url_video varchar(500) NOT NULL,
    CONSTRAINT PK_Pelicula PRIMARY KEY (nombrePelicula)
);


-- object: Usuario | type: TABLE --
CREATE TABLE Usuario (
    nombre varchar(50) NOT NULL,
    apellidos varchar(50) NOT NULL,
    contrasenha varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    fechaNacimiento varchar(12) NOT NULL,
    CONSTRAINT PK_Usuario PRIMARY KEY (email)
);

-- object: Comentario | type: TABLE --
CREATE TABLE Comentario (
    texto varchar(500) NOT NULL,
    valoracion smallint NOT NULL,
    fechaComentario varchar(12) NOT NULL,
    email_Usuario varchar(50) NOT NULL,
    nombrePelicula_Pelicula varchar(50)
);


-- object: ComentarioUsuario_fk | type: CONSTRAINT --
ALTER TABLE Comentario ADD CONSTRAINT ComentarioUsuario_fk FOREIGN KEY (email_Usuario)
REFERENCES Usuario (email);

-- object: ComentarioPelicula_fk | type: CONSTRAINT --
ALTER TABLE Comentario ADD CONSTRAINT ComentarioPelicula_fk FOREIGN KEY (nombrePelicula_Pelicula)
REFERENCES Pelicula (nombrePelicula);



--IMPORTS--

-- Usuarios
INSERT INTO Usuario (nombre, apellidos, contrasenha, email, fecha_nacimiento)
VALUES ('Rafael', 'Gonzalez', '1234', 'rafael@example.com', '1990-05-15');

INSERT INTO Usuario (nombre, apellidos, contrasenha, email, fecha_nacimiento)
VALUES ('Maria', 'Lopez', '12345', 'maria@example.com', '1985-09-22');

INSERT INTO Usuario (nombre, apellidos, contrasenha, email, fecha_nacimiento)
VALUES ('Carlos', 'Martinez', '12345', 'carlos@example.com', '1995-12-10');

-- Películas

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('El Padrino', 'Un poderoso drama criminal que sigue la vida de la familia Corleone en el mundo del crimen organizado.', 'https://example.com/godfather', 'Il Padrino', 'Crimen, Drama', 'Estados Unidos', 175, 1972, 'Paramount Pictures', 'Francis Ford Coppola', 18, 'Ganadora de 3 premios Oscar.', 'Marlon Brando, Al Pacino, James Caan','images/ElPadrino.jpeg', 'https://www.youtube.com/embed/iOyQx7MXaz0?si=nuCJfNniJoPzuQTb');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Cadena Perpetua', 'La historia de un hombre inocente encarcelado que encuentra esperanza y amistad en Shawshank.', 'https://example.com/shawshank', 'Shawshank Redemption', 'Drama', 'Estados Unidos', 142, 1994, 'Columbia Pictures', 'Frank Darabont', 15, 'Basada en la novela de Stephen King.', 'Tim Robbins, Morgan Freeman', 'images/CadenaPerpetua.jpeg', 'https://www.youtube.com/embed/4u87tmlj4oE?si=n318897_-rDPVLzP');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('El Caballero Oscuro', 'Batman se enfrenta a su némesis, el Joker, en un juego de ingenio que amenaza Gotham City.', 'https://example.com/darkknight', 'The Dark Knight', 'Accion, Crimen, Drama', 'Estados Unidos', 152, 2008, 'Warner Bros.', 'Christopher Nolan', 16, 'Ganadora de 2 premios Oscar.', 'Christian Bale, Heath Ledger, Aaron Eckhart', 'images/CaballeroOscuro.jpeg', 'https://www.youtube.com/embed/9MEuGQtM9wA?si=A5YSZGVuwDCtK83o');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Cars', 'En un mundo donde los autos son seres vivos, el aspirante a corredor Rayo McQueen termina en un pequeño pueblo llamado Radiador Springs. Aprendiendo lecciones valiosas de amistad y humildad, Rayo descubre el verdadero significado de la velocidad.', 'https://www.paginaoficial.com/cars', 'Cars', 'Animacion', 'Estadounidense', 120, 2006, 'Pixar', 'John Lasseter', 3, 'Datos adicionales sobre la película Cars.', 'Owen Wilson, Bonnie Hunt', 'images/Cars.png', 'https://www.youtube.com/embed/nuQDFYpPUh4?si=owxKwSIVF6QzUeh1');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Cars 2', 'Rayo McQueen y su amigo Mate se ven envueltos en una misión internacional de espionaje cuando son reclutados para participar en el Grand Prix Mundial. Intrigas, giros y vueltas esperan a nuestros héroes mientras luchan contra una misteriosa amenaza.', 'https://www.paginaoficial.com/cars2', 'Cars 2', 'Animacion', 'Estadounidense', 130, 2011, 'Pixar', 'John Lasseter', 3, 'Datos adicionales sobre la película Cars 2.', 'Owen Wilson, Larry the Cable Guy', 'images/Cars2.png', 'https://www.youtube.com/embed/oGpIMRq1O3k?si=UUSOoOjMZg_RPptk');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Cars 3', 'Con una nueva generación de corredores amenazando su posición, Rayo McQueen se embarca en un emocionante viaje de redescubrimiento y superación. Con la ayuda de entrenadores y nuevos amigos, Rayo intenta volver al ruedo y dejar su marca.', 'https://www.paginaoficial.com/cars3', 'Cars 3', 'Animacion', 'Estadounidense', 110, 2017, 'Pixar', 'Brian Fee', 3, 'Datos adicionales sobre la película Cars 3.', 'Owen Wilson, Cristela Alonzo', 'images/Cars3.png', 'https://www.youtube.com/embed/wtmW9rSRIzU?si=MttED7g2UgQk5A08');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Kung Fu Panda', 'Po, un torpe oso panda, sueña con convertirse en un hábil guerrero de kung fu. Su vida da un giro cuando es elegido accidentalmente para cumplir una antigua profecía. Po se embarca en una aventura cómica y emocionante para aprender las artes marciales y salvar el Valle de la Paz.', 'https://www.paginaoficial.com/kungfupanda', 'Kung Fu Panda', 'Animacion', 'Estadounidense', 95, 2008, 'DreamWorks Animation', 'Mark Osborne, John Stevenson', 3, 'Datos adicionales sobre la película Kung Fu Panda.', 'Jack Black, Angelina Jolie', 'images/KunfuPanda.png', 'https://www.youtube.com/embed/vRhMIpFu-Zw?si=Hwgor3iZaTcqtmz4');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('One Piece', 'Monkey D. Luffy y su valiente tripulación emprenden un viaje épico en busca del legendario tesoro conocido como "One Piece". Enfrentándose a peligros, enemigos y desafíos, Luffy se esfuerza por convertirse en el Rey de los Piratas.', 'https://www.paginaoficial.com/onepiece', 'One Piece', 'Animacion', 'Japonesa', 120, 2022, 'Toei Animation', 'Eiichiro Oda', 12, 'Datos adicionales sobre la película One Piece.', 'Mayumi Tanaka, Kazuya Nakai', 'images/OnePiece.png', 'https://www.youtube.com/embed/CWrJQzm0diI?si=tzF0AIbtEib0kGCV');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Rocky', 'Rocky Balboa, un boxeador de Filadelfia con pocas oportunidades, recibe la oportunidad de enfrentarse al campeón de peso pesado Apollo Creed. Aunque inicialmente es considerado como un oponente fácil, Rocky se prepara para la pelea de su vida, demostrando coraje y determinación.', 'https://www.paginaoficial.com/rocky', 'Rocky', 'Drama', 'Estadounidense', 120, 1976, 'United Artists', 'John G. Avildsen', 12, 'Datos adicionales sobre la película Rocky.', 'Sylvester Stallone, Talia Shire, Burgess Meredith', 'images/Rocky.png', 'https://www.youtube.com/embed/Vb-Bx2YkIPA?si=UZigoaMfxKRR6Hy8');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Harry Potter y la Piedra Filosofal', 'Harry Potter, un niño huérfano, descubre que es un mago y comienza su educación en la escuela de magia de Hogwarts. Junto a sus amigos, enfrenta misterios y descubre la verdad sobre su pasado.', 'https://example.com/harrypotter1', 'Harry Potter and the Philosophers Stone', 'Aventura, Familia, Fantasia', 'Reino Unido', 152, 2001, 'Warner Bros.', 'Chris Columbus', 7, 'Basada en la novela de J.K. Rowling.', 'Daniel Radcliffe, Emma Watson, Rupert Grint', 'images/potter.png', 'https://www.youtube.com/embed/VyHV0BRtdxo?si=3DCTwOj-S_GY1s_X');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Matrix', 'Neo, un hacker, descubre que vive en un simulacro y se une a una rebelión contra las máquinas que controlan la realidad. Una historia de ciencia ficcion llena de acción y reflexión filosófica.', 'https://example.com/matrix', 'The Matrix', 'Accion, Ciencia Ficcion', 'Estados Unidos', 136, 1999, 'Warner Bros.', 'Lana Wachowski, Lilly Wachowski', 15, 'Ganadora de 4 premios Oscar.', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss', 'images/Matrix.png', 'https://www.youtube.com/embed/m8e-FF8MsqU?si=LKyR-3B4Q2qFD0Js');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Jurassic Park', 'Un parque temático con dinosaurios creados mediante ingeniería genética se convierte en una pesadilla cuando los animales escapan y amenazan a los visitantes. Una aventura llena de suspense y emoción.', 'https://example.com/jurassicpark', 'Jurassic Park', 'Aventura, Ciencia Ficcion', 'Estados Unidos', 127, 1993, 'Universal Pictures', 'Steven Spielberg', 12, 'Basada en la novela de Michael Crichton.', 'Sam Neill, Laura Dern, Jeff Goldblum', 'images/JurassicPark.jpg', 'https://www.youtube.com/embed/lc0UehYemQA?si=UqjSjLRnQ4S4izZk');

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video)
VALUES ('Titanic', 'La historia de amor entre Jack y Rose se desarrolla a bordo del Titanic, el famoso transatlántico que choca con un iceberg y enfrenta un trágico destino. Una épica romántica y dramática.', 'https://example.com/titanic', 'Titanic', 'Drama, Romance', 'Estados Unidos', 195, 1997, '20th Century Fox', 'James Cameron', 12, 'Ganadora de 11 premios Oscar.', 'Leonardo DiCaprio, Kate Winslet', 'images/Titanic.jpg', 'https://www.youtube.com/embed/2e-eXJ6HgkQ?si=IctQRBQoTeKUh86p');


-- Comentarios
INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
VALUES ('Una obra maestra, actuaciones increíbles.', 5, '2023-01-05', 'rafael@example.com', 'El Padrino');

INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
VALUES ('Emocionante de principio a fin.', 4, '2023-01-06', 'maria@example.com', 'Cadena Perpetua');

INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
VALUES ('Efectos visuales asombrosos.', 4, '2023-01-07', 'carlos@example.com', 'El Caballero Oscuro');




