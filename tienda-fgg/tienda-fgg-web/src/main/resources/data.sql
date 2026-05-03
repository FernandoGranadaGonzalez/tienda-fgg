INSERT INTO marcas
    (nombre) VALUES
        ('Nintendo'),
        ('Naughty Dog'),
        ('Dontnod Entertainment'),
        ('Rockstar Games'),
        ('LucasArts'),
        ('Crystal Dynamics'),
        ('Guerrilla Games'),
        ('Telltale Games'),
        ('id Software'),
        ( 'Sledgehammer Games'),
        ( 'DICE'),
        ( 'Ubisoft Montreal'),
        ( 'Starbreeze Studios'),
        ( 'Squanch Games'),
        ( 'The Coalition'),
        ( 'Firaxis Games'),
        ( 'Relic Entertainment'),
        ( 'Flashback Games'),
        ( 'Paradox Development Studio'),
        ( 'Petroglyph Games'),
        ( 'CD Projekt Red'),
        ( 'Bethesda Game Studios'),
        ( 'FromSoftware'),
        ( 'Atlus'),
        ( 'BioWare'),
        ( 'Sandfall Interactive'),
        ( 'Warhorse Studios'),
        ( 'Square Enix'),
        ( 'SEGA'),
        ( 'Playground Games');

INSERT INTO categorias
    (nombre, descripcion, imagen) VALUES
        ('Aventura', 'Explora mundos épicos', 'aventura.jpg'),
        ('Shooter', 'Acción frenética en primera persona', 'shooter.png'),
        ('Estrategia', 'Explora mundos épicos', 'estrategia.png'),
        ('RPG', 'Acción frenética en primera persona', 'rpg.png'),
        ('Simulación', 'Experiencias realistas de gestión', 'simulacion.jpg'),
        ('Carreras', 'Velocidad máxima.', 'carreras.png');

INSERT INTO videojuegos
    (codigo_ean, titulo, marca_id, descripcion, precio, descuento, imagen) VALUES
        ('8431000000001', 'The Legend of Zelda: Breath of the Wild', 1, 'Explora un vasto mundo abierto lleno de secretos, templos y desafíos donde cada rincón invita a la aventura. Combina exploración, combate y resolución de puzles con total libertad en una experiencia inmersiva y dinámica.', 59.99, 0, 'botw.jpg'),
        ('8431000000002', 'Uncharted 4: A Thief''s End', 2, 'Acompaña a Nathan Drake en una aventura cinematográfica repleta de acción, misterios y tesoros ocultos. Viaja por escenarios espectaculares mientras enfrentas peligros y descubres una historia emocionante llena de giros.', 19.99, 10, 'uncharted4.jpg'),
        ('8431000000003', 'Life is Strange', 3, 'Sumérgete en una historia emocional donde tus decisiones alteran el tiempo y el destino. Vive una narrativa profunda con personajes complejos mientras exploras temas como la amistad, el sacrificio y las consecuencias.', 19.04, 20, 'LifeStrange.jpg'),
        ('8431000000004', 'Red Dead Redemption 2', 4, 'Viaja por un mundo abierto detallado en el Salvaje Oeste, donde cada decisión afecta tu historia. Disfruta de una narrativa madura, misiones variadas y un entorno vivo que reacciona a tus acciones.', 39.99, 10, 'rdr2.jpg'),
        ('8431000000005', 'Monkey Island 2: LeChuck''s Revenge', 5, 'Embárcate en una aventura clásica de piratas con humor ingenioso y desafiantes acertijos. Explora islas, interactúa con personajes únicos y descubre una historia llena de encanto y situaciones absurdas.', 9.99, 0, 'monkeyisland2.jpg'),
        ('8431000000006', 'Tomb Raider (2013)', 6, 'Descubre el origen de Lara Croft en una isla hostil llena de misterios y peligros. Combina exploración, supervivencia y combate en una aventura intensa que muestra la evolución de la protagonista.', 14.99, 30, 'tombraider.jpg'),
        ('8431000000007', 'The Last of Us Part I', 2, 'Vive una historia postapocalíptica cargada de emociones mientras acompañas a Joel y Ellie. Combina sigilo, combate y narrativa profunda en un viaje marcado por la supervivencia y los vínculos humanos.', 19.99, 40, 'tlou.jpg'),
        ('8431000000008', 'Horizon Zero Dawn', 7, 'Explora un mundo dominado por máquinas en esta aventura de acción y rol. Descubre secretos del pasado mientras cazas criaturas mecánicas y desarrollas habilidades en un entorno abierto espectacular.', 29.99, 0, 'horizonzero.jpg'),
        ('8431000000009', 'The Walking Dead: Season One', 8, 'Vive un drama interactivo en un mundo devastado por zombis donde cada decisión importa. Construye relaciones, enfrenta dilemas morales y experimenta una historia intensa que cambia según tus elecciones.', 19.99, 10, 'twd1.png'),

        ( '8431000000010', 'DOOM Eternal', 9, 'Combate hordas de demonios en un shooter frenético lleno de acción y velocidad. Utiliza un arsenal devastador mientras te mueves constantemente en escenarios dinámicos llenos de desafíos.', 19.99, 20, 'doometernal.jpg'),
        ( '8431000000011', 'Call of Duty: Advanced Warfare', 10, 'Sumérgete en combates futuristas con tecnología avanzada y acción intensa. Disfruta de una campaña dinámica y modos multijugador competitivos con gran variedad de armas y habilidades.', 9.38, 20, 'cod.jpg'),
        ( '8431000000012', 'Battlefield 1', 11, 'Experimenta la guerra a gran escala en escenarios inspirados en la Primera Guerra Mundial. Participa en batallas masivas con vehículos, destrucción dinámica y combates realistas.', 13.00, 40, 'battlefield1.jpg'),
        ( '8431000000013', 'Tom Clancy''s Rainbow Six Siege', 12, 'Shooter táctico donde la coordinación y estrategia son clave. Forma equipo, planifica ataques y aprovecha la destrucción del entorno para superar a tus rivales en partidas intensas.', 24.50, 60, 'rss.webp'),
        ( '8431000000014', 'PAYDAY 3', 13, 'Realiza atracos cooperativos donde la planificación y el trabajo en equipo marcan la diferencia. Ejecuta golpes perfectos mientras gestionas recursos y enfrentas situaciones imprevisibles.', 9.06, 50, 'payday3.jpg'),
        ( '8431000000015', 'High on Life', 14, 'Disfruta de un shooter único con humor irreverente y armas parlantes. Explora un universo alienígena lleno de situaciones absurdas y combate enemigos en escenarios coloridos.', 39.99, 10, 'highonlife.jpg'),
        ( '8431000000016', 'Gears of War: Ultimate Edition', 15, 'Lucha contra hordas alienígenas en un intenso shooter en tercera persona basado en coberturas. Vive una historia épica con combates tácticos y acción constante.', 19.99, 0, 'gears.jpg'),

        ( '8431000000017', 'Sid Meier''s Civilization VI', 16, 'Desarrolla una civilización desde sus inicios hasta la era moderna en este juego de estrategia por turnos. Gestiona recursos, diplomacia y guerras mientras expandes tu imperio.', 3.62, 20, 'civilizationvi.jpg'),
        ( '8431000000018', 'Age of Empires IV', 17, 'Construye imperios históricos y lidera ejércitos en batallas estratégicas en tiempo real. Gestiona economía, tecnología y expansión en diferentes civilizaciones.', 19.97, 0, 'ageiv.png'),
        ( '8431000000019', 'Panzer Corps 2', 18, 'Dirige ejércitos en campañas estratégicas basadas en conflictos históricos. Planifica movimientos, gestiona unidades y toma decisiones tácticas para lograr la victoria.', 1.12, 0, 'panzercorps.jpg'),
        ( '8431000000020', 'Crusader Kings III', 19, 'Gestiona una dinastía medieval tomando decisiones políticas, militares y personales. Construye alianzas, conquista territorios y asegura la supervivencia de tu linaje.', 29.99, 40, 'ckiii.jpg'),
        ( '8431000000021', 'Command & Conquer Remastered Collection', 20, 'Revive un clásico de estrategia en tiempo real con gráficos renovados. Gestiona bases, recolecta recursos y lidera ejércitos en intensas batallas tácticas.', 7.95, 30, 'cac.jpg'),

        ( '8431000000022', 'The Witcher 3: Wild Hunt', 21, 'Explora un mundo abierto lleno de decisiones morales y criaturas fantásticas. Vive una historia profunda mientras completas misiones, combates enemigos y desarrollas habilidades.', 9.99, 30, 'witcheriii.jpg'),
        ( '8431000000023', 'The Elder Scrolls V: Skyrim', 22, 'Adéntrate en un vasto mundo de fantasía donde puedes forjar tu propio destino. Completa misiones, desarrolla habilidades y explora libremente un entorno lleno de secretos.', 19.99, 40, 'skyrim.jpg'),
        ( '8431000000024', 'Cyberpunk 2077', 21, 'Sumérgete en una ciudad futurista llena de vida, decisiones y peligros. Personaliza tu personaje y elige tu camino en una historia donde cada elección tiene consecuencias.', 39.99, 50, 'cyberpunk.jpg'),
        ( '8431000000025', 'Dark Souls III', 23, 'Enfréntate a desafiantes enemigos en un mundo oscuro y atmosférico. Domina el combate táctico mientras exploras entornos llenos de secretos y peligros constantes.', 29.99, 0, 'dsiii.jpg'),
        ( '8431000000026', 'Persona 5 Royal', 24, 'Combina vida estudiantil con combates por turnos en mundos cognitivos. Desarrolla relaciones y enfrenta enemigos mientras descubres una historia profunda y estilizada.', 29.99, 0, 'p5r.webp'),
        ( '8431000000027', 'Dragon Age: Inquisition', 25, 'Lidera una organización destinada a salvar el mundo en un RPG lleno de decisiones. Forma alianzas, combate enemigos y explora un mundo rico en historia.', 19.99, 20, 'dai.png'),
        ( '8431000000028', 'Clair Obscur: Expedition 33', 26, 'Explora un mundo inspirado en la Belle Époque con combates por turnos y mecánicas dinámicas. Vive una historia artística con un sistema de combate innovador.', 49.99, 30, 'expedition33.webp'),
        ( '8431000000029', 'Fallout 4', 22, 'Sobrevive en un mundo postapocalíptico lleno de peligros y decisiones. Construye asentamientos, explora ruinas y define tu destino en un entorno abierto.', 19.99, 20, 'fallout4.webp'),
        ( '8431000000030', 'Kingdom Come: Deliverance', 27, 'Vive una experiencia realista en la Edad Media con combates exigentes y narrativa histórica. Toma decisiones que afectan tu reputación y desarrollo.', 7.99, 10, 'kcd.jpg'),
        ( '8431000000031', 'Octopath Traveler', 28, 'Disfruta de un RPG clásico con estilo visual único y múltiples historias entrelazadas. Elige tu camino y descubre los destinos de ocho personajes distintos.', 23.99, 0, 'octopathtraveller.jpg'),

        ( '0000000000000', 'Placeholder Videojuego', 1, 'Juego base sin categorías para pruebas internas.', 0.00, 0, 'no-image.jpg'),

        ( '8431000000033', 'Forza Horizon 5', 30, 'Vive la aventura definitiva de Horizon en los paisajes vibrantes y en constante evolución de México.', 49.99, 0, 'forza5.webp');

-- AVENTURA
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (1,1),
        (2,1),
        (3,1),
        (4,1),
        (5,1),
        (6,1),
        (7,1),
        (8,1),
        (9,1);

-- SHOOTER
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (10,2),
        (11,2),
        (12,2),
        (13,2),
        (14,2),
        (15,2),
        (16,2);

-- ESTRATEGIA
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (17,3),
        (18,3),
        (19,3),
        (20,3),
        (21,3);

-- RPG
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (23,4),
        (25,4),
        (26,4),
        (27,4),
        (28,4),
        (30,4),
        (31,4);

-- PRODUCTOS EN VARIAS CATEGORÍAS
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (22,4),
        (22,1);

INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (24,4),
        (24,2);

INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (29,4),
        (29,2);

-- CATEGORÍA CON UN SOLO PRODUCTO
INSERT INTO videojuego_categoria
    (videojuego_id, categoria_id) VALUES
        (33, 6);