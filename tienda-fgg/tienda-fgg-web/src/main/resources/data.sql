INSERT INTO categorias
    (nombre, descripcion, imagen) VALUES
        ('Aventura', 'Explora mundos épicos', 'aventura.jpg'),
        ('Shooter', 'Acción frenética en primera persona', 'shooter.png'),
        ('Estrategia', 'Explora mundos épicos', 'estrategia.png'),
        ('RPG', 'Acción frenética en primera persona', 'rpg.png');

INSERT INTO videojuegos
    (titulo, descripcion, precio, categoria_id, imagen)VALUES
        ('The Legend of Zelda: Breath of the Wild', 'Un enorme mundo abierto donde exploras, resuelves puzzles y enfrentas enemigos con total libertad.', 59.99, 1, 'botw.jpg'),
        ('Uncharted 4: A Thief''s End', 'Aventura cinematográfica llena de acción, tesoros y persecuciones con Nathan Drake.', 19.99, 1, 'uncharted4.jpg'),
        ('Life is Strange', 'Historia narrativa donde tus decisiones afectan el tiempo y el destino de los personajes.', 19.04, 1, 'LifeStrange.jpg'),
        ('Red Dead Redemption 2', 'Un viaje épico en el Salvaje Oeste con narrativa profunda y mundo detallado.', 39.99, 1, 'rdr2.jpg'),
        ('Monkey Island 2: LeChuck''s Revenge', 'Aventura clásica de humor pirata con puzzles ingeniosos.', 9.99, 1, 'monkeyisland2.jpg'),
        ('Tomb Raider (2013)', 'Origen de Lara Croft en una isla peligrosa llena de misterios.', 14.99, 1, 'tombraider.jpg'),
        ('The Last of Us Part I', 'Aventura narrativa intensa en un mundo postapocalíptico donde acompañas a Joel y Ellie en un viaje emocional.', 19.99, 1, 'tlou.jpg'),
        ('Horizon Zero Dawn', 'Exploras un mundo dominado por máquinas en una historia futurista y tribal.', 29.99, 1, 'horizonzero.jpg'),
        ('The Walking Dead: Season One', 'Drama interactivo en un apocalipsis zombi donde cada decisión pesa.', 19.99, 1, 'twd1.png'),

        ('DOOM Eternal', 'Shooter frenético donde combates demonios con armas brutales y ritmo muy rápido.', 19.99, 2, 'doometernal.jpg'),
        ('Call of Duty: Advanced Warfare', 'Acción militar futurista con combates intensos y multijugador competitivo.', 9.38, 2, 'cod.jpg'),
        ('Battlefield 1', 'Shooter bélico ambientado en la Primera Guerra Mundial con grandes batallas multijugador.', 13.00, 2, 'battlefield1.jpg'),
        ('Tom Clancy''s Rainbow Six Siege', 'Shooter táctico centrado en estrategia, equipos y destrucción del entorno.', 24.50, 2, 'rss.webp'),
        ('PAYDAY 3', 'Shooter cooperativo donde realizas atracos coordinados con otros jugadores.', 9.06, 2, 'payday3.jpg'),
        ('High on Life', 'Shooter en primera persona con humor y armas parlantes en un mundo de ciencia ficción.', 39.99, 2, 'highonlife.jpg'),
        ('Gears of War: Ultimate Edition', 'Shooter en tercera persona con coberturas donde luchas contra hordas alienígenas en un mundo devastado.', 19.99, 2, 'gears.jpg'),

        ('Sid Meier''s Civilization VI', 'Juego de estrategia por turnos donde desarrollas una civilización desde la antigüedad hasta la era moderna.', 3.62, 3, 'civilizationvi.jpg'),
        ('Age of Empires IV', 'Estrategia en tiempo real donde construyes imperios históricos y gestionas recursos y ejércitos.', 19.97, 3, 'ageiv.png'),
        ('Panzer Corps 2', 'Juego de estrategia militar centrado en batallas históricas con unidades detalladas.', 1.12, 3, 'panzercorps.jpg'),
        ('Crusader Kings III', 'Gran juego de estrategia donde gestionas una dinastía medieval mediante política, guerras y relaciones.', 29.99, 3, 'ckiii.jpg'),
        ('Command & Conquer Remastered Collection', 'Clásico de estrategia en tiempo real modernizado con gráficos mejorados.', 7.95, 3, 'cac.jpg'),

        ('The Witcher 3: Wild Hunt', 'RPG de mundo abierto con una historia profunda en un universo de fantasía oscura.', 9.99, 4, 'witcheriii.jpg'),
        ('The Elder Scrolls V: Skyrim', 'Exploras un enorme mundo de fantasía con libertad total para misiones, combate y exploración.', 19.99, 4, 'skyrim.jpg'),
        ('Cyberpunk 2077', 'RPG futurista en una ciudad abierta donde tus decisiones afectan la historia y el mundo.', 39.99, 4, 'cyberpunk.jpg'),
        ('Dark Souls III', 'RPG de acción desafiante con combates exigentes y ambientación oscura y misteriosa.', 29.99, 4, 'dsiii.jpg'),
        ('Persona 5 Royal', 'RPG japonés donde combinas vida estudiantil con combates por turnos en mundos cognitivos.', 29.99, 4, 'p5r.webp'),
        ('Dragon Age: Inquisition', 'RPG de fantasía donde lideras un grupo y tomas decisiones que afectan el destino del mundo.', 19.99, 4, 'dai.png'),
        ('Clair Obscur: Expedition 33', 'RPG por turnos con mecánicas en tiempo real ambientado en un mundo inspirado en la Belle Époque francesa.', 49.99, 4, 'expedition33.webp'),
        ('Fallout 4', 'RPG postapocalíptico donde exploras un mundo devastado lleno de decisiones y supervivencia.', 19.99, 4, 'fallout4.webp'),
        ('Kingdom Come: Deliverance', 'RPG realista ambientado en la Edad Media sin elementos de fantasía.', 7.99, 4, 'kcd.jpg'),
        ('Octopath Traveler', 'RPG clásico por turnos con estilo visual único y múltiples historias entrelazadas.', 23.99, 4, 'octopathtraveller.jpg');