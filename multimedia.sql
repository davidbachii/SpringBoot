-- Usuarios
INSERT INTO Usuario (nombre, nickname, contrasenha, email, fecha_nacimiento,plan_suscripcion)
VALUES ('Rafael', 'Rafa33', '1234', 'rafael@example.com', '1990-05-15','Gratis');

INSERT INTO Usuario (nombre, nickname, contrasenha, email, fecha_nacimiento,plan_suscripcion)
VALUES ('Maria', 'Maria33', '12345', 'maria@example.com', '1985-09-22','Pro');

INSERT INTO Usuario (nombre, nickname, contrasenha, email, fecha_nacimiento,plan_suscripcion)
VALUES ('Carlos', 'Carlos33', '12345', 'carlos@example.com', '1995-12-10','Pro');

-- Películas
INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('El Padrino', 'Un poderoso drama criminal que sigue la vida de la familia Corleone en el mundo del crimen organizado.', 'https://example.com/godfather', 'Il Padrino', 'Crimen, Drama', 'Estados Unidos', 175, 1972, 'Paramount Pictures', 'Francis Ford Coppola', 18, 'Ganadora de 3 premios Oscar.', 'Marlon Brando, Al Pacino, James Caan','images/ElPadrino.jpeg', 'https://www.youtube.com/embed/iOyQx7MXaz0?si=nuCJfNniJoPzuQTb', 7.8);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Cadena Perpetua', 'La historia de un hombre inocente encarcelado que encuentra esperanza y amistad en Shawshank.', 'https://example.com/shawshank', 'Shawshank Redemption', 'Drama', 'Estados Unidos', 142, 1994, 'Columbia Pictures', 'Frank Darabont', 15, 'Basada en la novela de Stephen King.', 'Tim Robbins, Morgan Freeman', 'images/CadenaPerpetua.jpeg', 'https://www.youtube.com/embed/4u87tmlj4oE?si=n318897_-rDPVLzP', 9.3);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('El Caballero Oscuro', 'Batman se enfrenta a su némesis, el Joker, en un juego de ingenio que amenaza Gotham City.', 'https://example.com/darkknight', 'The Dark Knight', 'Accion, Crimen, Drama', 'Estados Unidos', 152, 2008, 'Warner Bros.', 'Christopher Nolan', 16, 'Ganadora de 2 premios Oscar.', 'Christian Bale, Heath Ledger, Aaron Eckhart', 'images/CaballeroOscuro.jpeg', 'https://www.youtube.com/embed/9MEuGQtM9wA?si=A5YSZGVuwDCtK83o', 9.0);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Cars', 'En un mundo donde los autos son seres vivos, el aspirante a corredor Rayo McQueen termina en un pequeño pueblo llamado Radiador Springs. Aprendiendo lecciones valiosas de amistad y humildad, Rayo descubre el verdadero significado de la velocidad.', 'https://www.paginaoficial.com/cars', 'Cars', 'Animacion', 'Estadounidense', 120, 2006, 'Pixar', 'John Lasseter', 3, 'Datos adicionales sobre la película Cars.', 'Owen Wilson, Bonnie Hunt', 'images/Cars.png', 'https://www.youtube.com/embed/nuQDFYpPUh4?si=owxKwSIVF6QzUeh1', 7.1);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Cars 2', 'Rayo McQueen y su amigo Mate se ven envueltos en una misión internacional de espionaje cuando son reclutados para participar en el Grand Prix Mundial. Intrigas, giros y vueltas esperan a nuestros héroes mientras luchan contra una misteriosa amenaza.', 'https://www.paginaoficial.com/cars2', 'Cars 2', 'Animacion', 'Estadounidense', 130, 2011, 'Pixar', 'John Lasseter', 3, 'Datos adicionales sobre la película Cars 2.', 'Owen Wilson, Larry the Cable Guy', 'images/Cars2.png', 'https://www.youtube.com/embed/oGpIMRq1O3k?si=UUSOoOjMZg_RPptk', 6.2);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Cars 3', 'Con una nueva generación de corredores amenazando su posición, Rayo McQueen se embarca en un emocionante viaje de redescubrimiento y superación. Con la ayuda de entrenadores y nuevos amigos, Rayo intenta volver al ruedo y dejar su marca.', 'https://www.paginaoficial.com/cars3', 'Cars 3', 'Animacion', 'Estadounidense', 110, 2017, 'Pixar', 'Brian Fee', 3, 'Datos adicionales sobre la película Cars 3.', 'Owen Wilson, Cristela Alonzo', 'images/Cars3.png', 'https://www.youtube.com/embed/wtmW9rSRIzU?si=MttED7g2UgQk5A08', 6.5);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Kung Fu Panda', 'Po, un torpe oso panda, sueña con convertirse en un hábil guerrero de kung fu. Su vida da un giro cuando es elegido accidentalmente para cumplir una antigua profecía. Po se embarca en una aventura cómica y emocionante para aprender las artes marciales y salvar el Valle de la Paz.', 'https://www.paginaoficial.com/kungfupanda', 'Kung Fu Panda', 'Animacion', 'Estadounidense', 95, 2008, 'DreamWorks Animation', 'Mark Osborne, John Stevenson', 3, 'Datos adicionales sobre la película Kung Fu Panda.', 'Jack Black, Angelina Jolie', 'images/KunfuPanda.png', 'https://www.youtube.com/embed/vRhMIpFu-Zw?si=Hwgor3iZaTcqtmz4', 8.0);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('One Piece', 'Monkey D. Luffy y su valiente tripulación emprenden un viaje épico en busca del legendario tesoro conocido como "One Piece". Enfrentándose a peligros, enemigos y desafíos, Luffy se esfuerza por convertirse en el Rey de los Piratas.', 'https://www.paginaoficial.com/onepiece', 'One Piece', 'Animacion', 'Japonesa', 120, 2022, 'Toei Animation', 'Eiichiro Oda', 12, 'Datos adicionales sobre la película One Piece.', 'Mayumi Tanaka, Kazuya Nakai', 'images/OnePiece.png', 'https://www.youtube.com/embed/CWrJQzm0diI?si=tzF0AIbtEib0kGCV', 8.5);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Rocky', 'Rocky Balboa, un boxeador de Filadelfia con pocas oportunidades, recibe la oportunidad de enfrentarse al campeón de peso pesado Apollo Creed. Aunque inicialmente es considerado como un oponente fácil, Rocky se prepara para la pelea de su vida, demostrando coraje y determinación.', 'https://www.paginaoficial.com/rocky', 'Rocky', 'Drama', 'Estadounidense', 120, 1976, 'United Artists', 'John G. Avildsen', 12, 'Datos adicionales sobre la película Rocky.', 'Sylvester Stallone, Talia Shire, Burgess Meredith', 'images/Rocky.png', 'https://www.youtube.com/embed/Vb-Bx2YkIPA?si=UZigoaMfxKRR6Hy8', 8.1);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Harry Potter y la Piedra Filosofal', 'Harry Potter, un niño huérfano, descubre que es un mago y comienza su educación en la escuela de magia de Hogwarts. Junto a sus amigos, enfrenta misterios y descubre la verdad sobre su pasado.', 'https://example.com/harrypotter1', 'Harry Potter and the Philosophers Stone', 'Aventura, Familia, Fantasia', 'Reino Unido', 152, 2001, 'Warner Bros.', 'Chris Columbus', 7, 'Basada en la novela de J.K. Rowling.', 'Daniel Radcliffe, Emma Watson, Rupert Grint', 'images/potter.png', 'https://www.youtube.com/embed/VyHV0BRtdxo?si=3DCTwOj-S_GY1s_X', 8.7);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Matrix', 'Neo, un hacker, descubre que vive en un simulacro y se une a una rebelión contra las máquinas que controlan la realidad. Una historia de ciencia ficcion llena de acción y reflexión filosófica.', 'https://example.com/matrix', 'The Matrix', 'Accion, Ciencia Ficcion', 'Estados Unidos', 136, 1999, 'Warner Bros.', 'Lana Wachowski, Lilly Wachowski', 15, 'Ganadora de 4 premios Oscar.', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss', 'images/Matrix.png', 'https://www.youtube.com/embed/m8e-FF8MsqU?si=LKyR-3B4Q2qFD0Js', 8.7);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Jurassic Park', 'Un parque temático con dinosaurios creados mediante ingeniería genética se convierte en una pesadilla cuando los animales escapan y amenazan a los visitantes. Una aventura llena de suspense y emoción.', 'https://example.com/jurassicpark', 'Jurassic Park', 'Aventura, Ciencia Ficcion', 'Estados Unidos', 127, 1993, 'Universal Pictures', 'Steven Spielberg', 12, 'Basada en la novela de Michael Crichton.', 'Sam Neill, Laura Dern, Jeff Goldblum', 'images/JurassicPark.jpg', 'https://www.youtube.com/embed/lc0UehYemQA?si=UqjSjLRnQ4S4izZk', 8.4);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Titanic', 'La historia de amor entre Jack y Rose se desarrolla a bordo del Titanic, el famoso transatlántico que choca con un iceberg y enfrenta un trágico destino. Una épica romántica y dramática.', 'https://example.com/titanic', 'Titanic', 'Drama, Romance', 'Estados Unidos', 195, 1997, '20th Century Fox', 'James Cameron', 12, 'Ganadora de 11 premios Oscar.', 'Leonardo DiCaprio, Kate Winslet', 'images/Titanic.jpg', 'https://www.youtube.com/embed/2e-eXJ6HgkQ?si=IctQRBQoTeKUh86p', 8.8);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Forrest Gump', 'Forrest Gump, un hombre con un coeficiente intelectual bajo, vive una vida extraordinaria llena de aventuras, amor y acontecimientos históricos.', 'https://example.com/forrestgump', 'Forrest Gump', 'Drama, Romance', 'Estados Unidos', 142, 1994, 'Paramount Pictures', 'Robert Zemeckis', 12, 'Basada en la novela de Winston Groom.', 'Tom Hanks, Robin Wright, Gary Sinise', 'images/ForrestGump.jpg', 'https://www.youtube.com/embed/uPIEn0M8su0?si=fLm5qE9BQMWXx6oS', 7.7);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('Interestelar', 'Un equipo de astronautas se embarca en un viaje a través de un agujero de gusano en busca de un nuevo hogar para la humanidad. Una odisea espacial llena de misterio y descubrimiento.', 'https://example.com/interstellar', 'Interstellar', 'Aventura, Drama, Ciencia Ficcion', 'Estados Unidos', 169, 2014, 'Paramount Pictures', 'Christopher Nolan', 12, 'Ganadora del premio Oscar a los mejores efectos visuales.', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'images/Interstellar.jpg', 'https://www.youtube.com/embed/zSWdZVtXT7E?si=4r2XsH2dSsO-0KKp', 8.4);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('El Rey León', 'Simba, un joven león, lucha por reclamar su lugar como rey después de que su malvado tío Scar usurpe el trono de su padre. Una épica historia de crecimiento, amor y responsabilidad.', 'https://example.com/lionking', 'The Lion King', 'Animacion, Aventura, Drama', 'Estados Unidos', 118, 1994, 'Walt Disney Pictures', 'Roger Allers, Rob Minkoff', 3, 'Inspirada en Hamlet de William Shakespeare.', 'Matthew Broderick, Jeremy Irons, James Earl Jones', 'images/LionKing.jpg', 'https://www.youtube.com/embed/4sj1MT05lAA?si=yBQKcF9tQoq6zF3a', 6.9);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('El Señor de los Anillos: La Comunidad del Anillo', 'Frodo Bolsón, un hobbit tranquilo, se embarca en una aventura épica para destruir un anillo maligno y salvar a la Tierra Media del mal. Una saga de fantasía que redefine el género.', 'https://example.com/lotr1', 'The Lord of the Rings: The Fellowship of the Ring', 'Aventura, Drama, Fantasia', 'Estados Unidos', 178, 2001, 'New Line Cinema', 'Peter Jackson', 12, 'Basada en la novela de J.R.R. Tolkien.', 'Elijah Wood, Ian McKellen, Viggo Mortensen', 'images/LOTR1.jpg', 'https://www.youtube.com/embed/V75dMMIW2B4?si=OzZkPOklRZWaTpvl', 8.3);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('El Silencio de los Inocentes', 'Un joven agente del FBI busca la ayuda de Hannibal Lecter, un brillante pero peligroso psiquiatra encarcelado, para atrapar a un asesino en serie. Un thriller psicológico que te mantendrá al borde de tu asiento.', 'https://example.com/silenceofthelambs', 'The Silence of the Lambs', 'Crimen, Drama, Thriller', 'Estados Unidos', 118, 1991, 'Orion Pictures', 'Jonathan Demme', 18, 'Basada en la novela de Thomas Harris.', 'Jodie Foster, Anthony Hopkins, Scott Glenn', 'images/SilenceoftheLambs.jpg', 'https://www.youtube.com/embed/W6Mm8Sbe__o?si=tT_TQOD3RfG2V2tJ', 7.2);

INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacion_edad, otros_datos, actores, url_image, url_video, calificacion)
VALUES ('La La Land', 'Un pianista de jazz y una aspirante a actriz se enamoran en Los Ángeles mientras persiguen sus sueños. Una historia de amor y ambición ambientada en la vibrante ciudad de las estrellas.', 'https://example.com/lalaland', 'La La Land', 'Comedia, Drama, Musical', 'Estados Unidos', 128, 2016, 'Summit Entertainment', 'Damien Chazelle', 7, 'Ganadora de 6 premios Oscar.', 'Ryan Gosling, Emma Stone, John Legend', 'images/LaLaLand.jpg', 'https://www.youtube.com/embed/0pdqf4P9MB8?si=Tw-k8yPtTsmfqEUv', 7.8);






-- Inserts para la tabla FootballContent
INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Final de la UEFA Champions League', 'El enfrentamiento definitivo entre los mejores equipos de Europa.', 'https://www.uefa.com/es/uefachampionsleague/', 'Estadio Olímpico Atatürk', 'Manchester City vs Chelsea', 'Inglesa', 90, 2023, 'Ambos equipos buscan su primer título de la Champions League.', 'De Bruyne, Havertz, Sterling', 'https://urlimage.com/championsleaguefinal', 'https://urlvideo.com/championsleaguefinal');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Copa América Final', 'La emocionante conclusión del torneo sudamericano más importante.', 'https://www.conmebol.com/es/copa-america', 'Estadio Maracaná', 'Argentina vs Brasil', 'Argentina y Brasil', 90, 2024, 'El enfrentamiento entre Messi y Neymar acapara la atención mundial.', 'Messi, Neymar, Aguero', 'https://urlimage.com/copaamericafinal', 'https://urlvideo.com/copaamericafinal');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('El Superclásico Argentino', 'El duelo más caliente del fútbol argentino.', 'https://www.afa.com.ar/', 'Estadio Monumental', 'River Plate vs Boca Juniors', 'Argentina', 90, 2023, 'Un encuentro lleno de pasión y rivalidad.', 'Suárez, Tevez, De La Cruz', 'https://urlimage.com/superclasico', 'https://urlvideo.com/superclasico');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Derbi de Madrid', 'La batalla entre los dos equipos más grandes de la capital española.', 'https://www.realmadrid.com/', 'Estadio Wanda Metropolitano', 'Real Madrid vs Atlético de Madrid', 'Española', 90, 2023, 'La rivalidad entre los colchoneros y los merengues se hace sentir en cada jugada.', 'Benzema, Suárez, João Félix', 'https://urlimage.com/derbimadrid', 'https://urlvideo.com/derbimadrid');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Clásico de Avellaneda', 'El enfrentamiento entre los clubes más representativos de la ciudad de Avellaneda.', 'https://www.racingclub.com.ar/', 'Estadio Juan Domingo Perón', 'Racing Club vs Independiente', 'Argentina', 90, 2023, 'Una historia de rivalidad que se remonta a décadas.', 'López, Martínez, Benítez', 'https://urlimage.com/clasicoavellaneda', 'https://urlvideo.com/clasicoavellaneda');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('El Derbi de la Madonnina', 'El clásico de la ciudad de Milán entre los dos equipos más grandes.', 'https://www.inter.it/', 'Estadio Giuseppe Meazza', 'Inter de Milán vs AC Milan', 'Italiana', 90, 2023, 'El partido más esperado por los fanáticos del fútbol italiano.', 'Lautaro Martínez, Ibrahimović, Barella', 'https://urlimage.com/derbimadonnina', 'https://urlvideo.com/derbimadonnina');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Clásico Universitario', 'El enfrentamiento entre las dos universidades más grandes de Perú.', 'https://www.udep.edu.pe/', 'Estadio Monumental', 'Universidad de San Martín vs Universidad de Lima', 'Peruana', 90, 2023, 'Una batalla por el orgullo universitario.', 'Gómez, Fernández, García', 'https://urlimage.com/clasicouniversitario', 'https://urlvideo.com/clasicouniversitario');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('El Clásico del Astillero', 'El derbi entre los equipos más populares de Guayaquil.', 'https://www.barcaymelateam.com/', 'Estadio George Capwell', 'Barcelona SC vs Club Sport Emelec', 'Ecuatoriana', 90, 2023, 'Una tradición futbolística que une a toda una ciudad.', 'Díaz, Cabezas, Caicedo', 'https://urlimage.com/clasicodelastillero', 'https://urlvideo.com/clasicodelastillero');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('El Derbi Valenciano', 'El choque entre los dos equipos más importantes de la Comunidad Valenciana.', 'https://www.valenciacf.com/', 'Estadio Mestalla', 'Valencia CF vs Villarreal CF', 'Española', 90, 2023, 'Una rivalidad que se vive con intensidad en toda la región.', 'Gómez, Moreno, Soler', 'https://urlimage.com/derbivalenciano', 'https://urlvideo.com/derbivalenciano');

INSERT INTO football_content (nombre_partido, descripcion, pagina_oficial, estadio, equipos, nacionalidad, duracion, anho, otros_datos, jugadores, url_image, url_video)
VALUES ('Final de la Copa Libertadores', 'La definición del torneo más prestigioso de clubes en América del Sur.', 'https://www.conmebol.com/es/copa-libertadores', 'Estadio Centenario', 'Boca Juniors vs River Plate', 'Argentina', 90, 2023, 'Una final histórica entre dos eternos rivales.', 'Zárate, De La Cruz, Tevez', 'https://urlimage.com/copalibertadoresfinal', 'https://urlvideo.com/copalibertadoresfinal');



-- Inserts para la tabla F1Content
INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Mónaco', 'La carrera más glamurosa de la Fórmula 1.', 'https://www.formula1.com/', 'Circuito de Mónaco', 'Mercedes, Red Bull Racing, Ferrari', 'Internacional', 120, 2023, 'El circuito callejero más famoso del mundo.', 'Lewis Hamilton, Max Verstappen, Charles Leclerc', 'https://urlimage.com/monaco', 'https://urlvideo.com/monaco');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Italia', 'Una carrera legendaria con mucha historia.', 'https://www.formula1.com/', 'Autodromo Nazionale Monza', 'Alfa Romeo Racing, McLaren, Williams Racing', 'Internacional', 120, 2023, 'Conocida por su alta velocidad y emocionantes adelantamientos.', 'Daniel Ricciardo, Fernando Alonso, Nicholas Latifi', 'https://urlimage.com/italia', 'https://urlvideo.com/italia');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Estados Unidos', 'Una carrera emocionante en el Circuito de las Américas.', 'https://www.formula1.com/', 'Circuit of The Americas', 'McLaren, Red Bull Racing, Aston Martin', 'Internacional', 120, 2023, 'Una de las pistas más modernas y desafiantes del calendario.', 'Lando Norris, Sergio Pérez, Sebastian Vettel', 'https://urlimage.com/usa', 'https://urlvideo.com/usa');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Japón', 'Una carrera icónica en el legendario Circuito de Suzuka.', 'https://www.formula1.com/', 'Circuito de Suzuka', 'AlphaTauri, Alpine, Haas', 'Internacional', 120, 2023, 'Famoso por su "S", la famosa curva en forma de "S".', 'Pierre Gasly, Esteban Ocon, Mick Schumacher', 'https://urlimage.com/japon', 'https://urlvideo.com/japon');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Bélgica', 'Una carrera desafiante en el Circuito de Spa-Francorchamps.', 'https://www.formula1.com/', 'Circuito de Spa-Francorchamps', 'Alpine, Aston Martin, Red Bull Racing', 'Internacional', 120, 2023, 'Conocida como la "Catedral de la Velocidad".', 'Fernando Alonso, Sebastian Vettel, Sergio Pérez', 'https://urlimage.com/belgica', 'https://urlvideo.com/belgica');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Singapur', 'La carrera nocturna más emocionante en el Marina Bay Street Circuit.', 'https://www.formula1.com/', 'Marina Bay Street Circuit', 'Williams Racing, Alfa Romeo Racing, Haas', 'Internacional', 120, 2023, 'Un espectáculo visual único con luces deslumbrantes.', 'George Russell, Kimi Räikkönen, Nikita Mazepin', 'https://urlimage.com/singapur', 'https://urlvideo.com/singapur');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Australia', 'La carrera de apertura de la temporada en el Albert Park Circuit.', 'https://www.formula1.com/', 'Albert Park Circuit', 'Ferrari, McLaren, AlphaTauri', 'Internacional', 120, 2023, 'El inicio de la emoción y la competencia en la Fórmula 1.', 'Carlos Sainz, Daniel Ricciardo, Yuki Tsunoda', 'https://urlimage.com/australia', 'https://urlvideo.com/australia');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Gran Bretaña', 'La carrera en el histórico Circuito de Silverstone.', 'https://www.formula1.com/', 'Silverstone Circuit', 'Mercedes, Aston Martin, Red Bull Racing', 'Internacional', 120, 2023, 'Una de las carreras más antiguas y emocionantes del calendario.', 'Lewis Hamilton, Sebastian Vettel, Max Verstappen', 'https://urlimage.com/granbretana', 'https://urlvideo.com/granbretana');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Brasil', 'La carrera en el icónico Autódromo José Carlos Pace.', 'https://www.formula1.com/', 'Autódromo José Carlos Pace', 'McLaren, Alpine, Ferrari', 'Internacional', 120, 2023, 'Famoso por su inclinada curva final.', 'Lando Norris, Fernando Alonso, Charles Leclerc', 'https://urlimage.com/brasil', 'https://urlvideo.com/brasil');

INSERT INTO f1Content (nombre_carrera, descripcion, pagina_oficial, circuito, equipos, nacionalidad, duracion, anho, otros_datos, pilotos, url_image, url_video)
VALUES ('Gran Premio de Abu Dhabi', 'La carrera final de la temporada en el Yas Marina Circuit.', 'https://www.formula1.com/', 'Yas Marina Circuit', 'Red Bull Racing, Mercedes, Ferrari', 'Internacional', 120, 2023, 'La carrera decisiva que puede cambiar el campeonato.', 'Max Verstappen, Lewis Hamilton, Carlos Sainz', 'https://urlimage.com/abudhabi', 'https://urlvideo.com/abudhabi');


-- Comentarios
--INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
--VALUES ('Una obra maestra, actuaciones increíbles.', 5, '2023-01-05', 'rafael@example.com', 'El Padrino');

--INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
--VALUES ('Emocionante de principio a fin.', 4, '2023-01-06', 'maria@example.com', 'Cadena Perpetua');

--INSERT INTO Comentario (texto, valoracion, fecha_comentario, email_Usuario, nombre_pelicula_Pelicula)
--VALUES ('Efectos visuales asombrosos.', 4, '2023-01-07', 'carlos@example.com', 'El Caballero Oscuro');




