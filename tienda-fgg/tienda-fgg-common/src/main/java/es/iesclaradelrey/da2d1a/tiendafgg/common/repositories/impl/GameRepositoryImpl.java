package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Game;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private final List<Game> listaJuegos = new ArrayList<>();

    public GameRepositoryImpl() {
        listaJuegos.add(new Game(1L, "The Legend of Zelda: Breath of the Wild", "Un enorme mundo abierto donde exploras, resuelves puzzles y enfrentas enemigos con total libertad.", 59.99, 1L, "botw.jpg"));
        listaJuegos.add(new Game(2L, "Uncharted 4: A Thief's End", "Aventura cinematográfica llena de acción, tesoros y persecuciones con Nathan Drake.", 19.99, 1L, "uncharted4.jpg"));
        listaJuegos.add(new Game(3L, "Life is Strange", "Historia narrativa donde tus decisiones afectan el tiempo y el destino de los personajes.", 19.04, 1L, "LifeStrange.jpg"));
        listaJuegos.add(new Game(4L, "Red Dead Redemption 2", "Un viaje épico en el Salvaje Oeste con narrativa profunda y mundo detallado.", 39.99, 1L, "rdr2.jpg"));
        listaJuegos.add(new Game(5L, "Firewatch", "Experiencia introspectiva en primera persona como vigilante forestal en Wyoming.", 14.99, 1L, "firewatch.webp"));
        listaJuegos.add(new Game(6L, "Monkey Island 2: LeChuck's Revenge", "Aventura clásica de humor pirata con puzzles ingeniosos.", 9.99, 1L, "monkeyisland2.jpg"));
        listaJuegos.add(new Game(7L, "Tomb Raider (2013)", "Origen de Lara Croft en una isla peligrosa llena de misterios.", 14.99, 1L, "tombraider.jpg"));
        listaJuegos.add(new Game(8L, "Grim Fandango Remastered", "Aventura única ambientada en el mundo de los muertos con estética noir.", 14.99, 1L, "grimfandango.webp"));
        listaJuegos.add(new Game(9L, "Horizon Zero Dawn", "Exploras un mundo dominado por máquinas en una historia futurista y tribal.", 29.99, 1L, "horizonzero.jpg"));
        listaJuegos.add(new Game(10L, "The Walking Dead: Season One", "Drama interactivo en un apocalipsis zombi donde cada decisión pesa.", 19.99, 1L, "twd1.png"));

        listaJuegos.add(new Game(11L, "DOOM Eternal", "Shooter frenético donde combates demonios con armas brutales y ritmo muy rápido.", 19.99, 2L, "doometernal.jpg"));
        listaJuegos.add(new Game(12L, "Call of Duty: Advanced Warfare", "Acción militar futurista con combates intensos y multijugador competitivo.", 9.38, 2L, "cod.jpg"));
        listaJuegos.add(new Game(13L, "Battlefield 1", "Shooter bélico ambientado en la Primera Guerra Mundial con grandes batallas multijugador.", 13.00, 2L, "battlefield1.jpg"));
        listaJuegos.add(new Game(14L, "Far Cry 5", "Shooter en mundo abierto donde enfrentas una secta en una zona rural de Estados Unidos.", 5.42, 2L, "farcry5.webp"));
        listaJuegos.add(new Game(15L, "Sniper Elite 4", "Disparos tácticos y sigilo como francotirador en escenarios de la Segunda Guerra Mundial.", 19.99, 2L, "sniperelite4.jpg"));
        listaJuegos.add(new Game(16L, "Titanfall 2", "Combina combate rápido con parkour y mechas gigantes en una campaña muy dinámica.", 15.74, 2L, "titanfall2.jpg"));
        listaJuegos.add(new Game(17L, "Tom Clancy's Rainbow Six Siege", "Shooter táctico centrado en estrategia, equipos y destrucción del entorno.", 24.50, 2L, "rss.webp"));
        listaJuegos.add(new Game(18L, "PAYDAY 3", "Shooter cooperativo donde realizas atracos coordinados con otros jugadores.", 9.06, 2L, "payday3.jpg"));
        listaJuegos.add(new Game(19L, "High on Life", "Shooter en primera persona con humor y armas parlantes en un mundo de ciencia ficción.", 39.99, 2L, "highonlife.jpg"));
        listaJuegos.add(new Game(20L, "Gears of War: Ultimate Edition", "Shooter en tercera persona con coberturas donde luchas contra hordas alienígenas en un mundo devastado.", 19.99, 2L, "gears.jpg"));

        listaJuegos.add(new Game(21L, "Sid Meier's Civilization VI", "Juego de estrategia por turnos donde desarrollas una civilización desde la antigüedad hasta la era moderna.", 3.62, 3L, "civilizationvi.jpg"));
        listaJuegos.add(new Game(22L, "Age of Empires IV", "Estrategia en tiempo real donde construyes imperios históricos y gestionas recursos y ejércitos.", 19.97, 3L, "ageiv.png"));
        listaJuegos.add(new Game(23L, "XCOM 2", "Estrategia táctica por turnos donde lideras la resistencia contra una invasión alienígena.", 8.00, 3L, "xcom2.jpg"));
        listaJuegos.add(new Game(24L, "Imperialism II: The Age of Exploration", "Estrategia histórica centrada en colonización, comercio y expansión imperial.", 17.92, 3L, "imperialismii.webp"));
        listaJuegos.add(new Game(25L, "Into the Breach", "Estrategia por turnos con combates tácticos en cuadrícula contra criaturas gigantes.", 48.24, 3L, "intobreach.png"));
        listaJuegos.add(new Game(26L, "Panzer Corps 2", "Juego de estrategia militar centrado en batallas históricas con unidades detalladas.", 1.12, 3L, "panzercorps.jpg"));
        listaJuegos.add(new Game(27L, "Crusader Kings III", "Gran juego de estrategia donde gestionas una dinastía medieval mediante política, guerras y relaciones.", 29.99, 3L, "ckiii.jpg"));
        listaJuegos.add(new Game(28L, "Totally Accurate Battle Simulator", "Estrategia divertida basada en física donde creas ejércitos absurdos y los enfrentas.", 6.49, 3L, "tabs.avif"));
        listaJuegos.add(new Game(29L, "Command & Conquer Remastered Collection", "Clásico de estrategia en tiempo real modernizado con gráficos mejorados.", 7.95, 3L, "cac.jpg"));
        listaJuegos.add(new Game(30L, "Heroes of Might and Magic III", "Estrategia por turnos con exploración, gestión de recursos y combates fantásticos.", 8.01, 3L, "homamiii.jpg"));

        listaJuegos.add(new Game(31L, "The Witcher 3: Wild Hunt", "RPG de mundo abierto con una historia profunda en un universo de fantasía oscura.", 9.99, 4L ,"witcheriii.jpg"));
        listaJuegos.add(new Game(32L, "The Elder Scrolls V: Skyrim", "Exploras un enorme mundo de fantasía con libertad total para misiones, combate y exploración.", 19.99, 4L, "skyrim.jpg"));
        listaJuegos.add(new Game(33L, "Cyberpunk 2077", "RPG futurista en una ciudad abierta donde tus decisiones afectan la historia y el mundo.", 39.99, 4L, "cyberpunk.jpg"));
        listaJuegos.add(new Game(34L, "Dark Souls III", "RPG de acción desafiante con combates exigentes y ambientación oscura y misteriosa.", 29.99, 4L, "dsiii.jpg"));
        listaJuegos.add(new Game(35L, "Persona 5 Royal", "RPG japonés donde combinas vida estudiantil con combates por turnos en mundos cognitivos.", 29.99, 4L, "p5r.webp"));
        listaJuegos.add(new Game(36L, "Dragon Age: Inquisition", "RPG de fantasía donde lideras un grupo y tomas decisiones que afectan el destino del mundo.", 19.99, 4L, "dai.png"));
        listaJuegos.add(new Game(37L, "Clair Obscur: Expedition 33", "RPG por turnos con mecánicas en tiempo real ambientado en un mundo inspirado en la Belle Époque francesa.", 49.99, 4L, "expedition33.webp"));
        listaJuegos.add(new Game(38L, "Fallout 4", "RPG postapocalíptico donde exploras un mundo devastado lleno de decisiones y supervivencia.", 19.99, 4L, "fallout4.webp"));
        listaJuegos.add(new Game(39L, "Kingdom Come: Deliverance", "RPG realista ambientado en la Edad Media sin elementos de fantasía.", 7.99, 4L, "kcd.jpg"));
        listaJuegos.add(new Game(40L, "Octopath Traveler", "RPG clásico por turnos con estilo visual único y múltiples historias entrelazadas.", 23.99, 4L, "octopathtraveller.jpg"));
    }

    @Override
    public List<Game> obtenerTodos() {
        return new ArrayList<>(listaJuegos);
    }

    @Override
    public List<Game> buscarPorCategoria(Long categoriaId) {
        return listaJuegos.stream()
                .filter(j -> j.getCategoriaId().equals(categoriaId))
                .toList();
    }

    @Override
    public List<Game> buscarPorNombre(String query) {
        if (query == null || query.isBlank()) return new ArrayList<>();
        return listaJuegos.stream()
                .filter(j -> j.getTitulo().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}