package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de videojuegos basada en almacenamiento en memoria.
 * <p>
 * Esta clase gestiona el catálogo completo de la tienda mediante una lista interna.
 * Proporciona capacidades de filtrado por categoría y búsqueda textual por título.
 * Al estar anotada con {@code @Repository}, Spring la detecta automáticamente
 * para su inyección de dependencias.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Repository
public class VideojuegoRepositoryImpl implements VideojuegoRepository {

    /**
     * Fuente de datos interna que contiene todos los objetos {@link Videojuego}.
     * Se utiliza una {@link ArrayList} para mantener el orden de inserción.
     */
    private final List<Videojuego> listaJuegos = new ArrayList<>();

    /**
     * Constructor del repositorio.
     * <p>
     * Inicializa el catálogo con una colección extensa de videojuegos de prueba
     * clasificados por categorías (Aventura, Shooter, Estrategia, RPG).
     * Esto permite disponer de datos funcionales inmediatamente tras el arranque.
     * </p>
     */
    public VideojuegoRepositoryImpl() {
        listaJuegos.add(new Videojuego(1L, "The Legend of Zelda: Breath of the Wild", "Un enorme mundo abierto donde exploras, resuelves puzzles y enfrentas enemigos con total libertad.", 59.99, 1L, "botw.jpg"));
        listaJuegos.add(new Videojuego(2L, "Uncharted 4: A Thief's End", "Aventura cinematográfica llena de acción, tesoros y persecuciones con Nathan Drake.", 19.99, 1L, "uncharted4.jpg"));
        listaJuegos.add(new Videojuego(3L, "Life is Strange", "Historia narrativa donde tus decisiones afectan el tiempo y el destino de los personajes.", 19.04, 1L, "LifeStrange.jpg"));
        listaJuegos.add(new Videojuego(4L, "Red Dead Redemption 2", "Un viaje épico en el Salvaje Oeste con narrativa profunda y mundo detallado.", 39.99, 1L, "rdr2.jpg"));
        listaJuegos.add(new Videojuego(5L, "Monkey Island 2: LeChuck's Revenge", "Aventura clásica de humor pirata con puzzles ingeniosos.", 9.99, 1L, "monkeyisland2.jpg"));
        listaJuegos.add(new Videojuego(6L, "Tomb Raider (2013)", "Origen de Lara Croft en una isla peligrosa llena de misterios.", 14.99, 1L, "tombraider.jpg"));
        listaJuegos.add(new Videojuego(7L, "The Last of Us Part I", "Aventura narrativa intensa en un mundo postapocalíptico donde acompañas a Joel y Ellie en un viaje emocional.", 19.99, 1L, "tlou.jpg"));
        listaJuegos.add(new Videojuego(8L, "Horizon Zero Dawn", "Exploras un mundo dominado por máquinas en una historia futurista y tribal.", 29.99, 1L, "horizonzero.jpg"));
        listaJuegos.add(new Videojuego(9L, "The Walking Dead: Season One", "Drama interactivo en un apocalipsis zombi donde cada decisión pesa.", 19.99, 1L, "twd1.png"));

        listaJuegos.add(new Videojuego(10L, "DOOM Eternal", "Shooter frenético donde combates demonios con armas brutales y ritmo muy rápido.", 19.99, 2L, "doometernal.jpg"));
        listaJuegos.add(new Videojuego(11L, "Call of Duty: Advanced Warfare", "Acción militar futurista con combates intensos y multijugador competitivo.", 9.38, 2L, "cod.jpg"));
        listaJuegos.add(new Videojuego(12L, "Battlefield 1", "Shooter bélico ambientado en la Primera Guerra Mundial con grandes batallas multijugador.", 13.00, 2L, "battlefield1.jpg"));
        listaJuegos.add(new Videojuego(13L, "Tom Clancy's Rainbow Six Siege", "Shooter táctico centrado en estrategia, equipos y destrucción del entorno.", 24.50, 2L, "rss.webp"));
        listaJuegos.add(new Videojuego(14L, "PAYDAY 3", "Shooter cooperativo donde realizas atracos coordinados con otros jugadores.", 9.06, 2L, "payday3.jpg"));
        listaJuegos.add(new Videojuego(15L, "High on Life", "Shooter en primera persona con humor y armas parlantes en un mundo de ciencia ficción.", 39.99, 2L, "highonlife.jpg"));
        listaJuegos.add(new Videojuego(16L, "Gears of War: Ultimate Edition", "Shooter en tercera persona con coberturas donde luchas contra hordas alienígenas en un mundo devastado.", 19.99, 2L, "gears.jpg"));

        listaJuegos.add(new Videojuego(17L, "Sid Meier's Civilization VI", "Juego de estrategia por turnos donde desarrollas una civilización desde la antigüedad hasta la era moderna.", 3.62, 3L, "civilizationvi.jpg"));
        listaJuegos.add(new Videojuego(18L, "Age of Empires IV", "Estrategia en tiempo real donde construyes imperios históricos y gestionas recursos y ejércitos.", 19.97, 3L, "ageiv.png"));
        listaJuegos.add(new Videojuego(19L, "Panzer Corps 2", "Juego de estrategia militar centrado en batallas históricas con unidades detalladas.", 1.12, 3L, "panzercorps.jpg"));
        listaJuegos.add(new Videojuego(20L, "Crusader Kings III", "Gran juego de estrategia donde gestionas una dinastía medieval mediante política, guerras y relaciones.", 29.99, 3L, "ckiii.jpg"));
        listaJuegos.add(new Videojuego(21L, "Command & Conquer Remastered Collection", "Clásico de estrategia en tiempo real modernizado con gráficos mejorados.", 7.95, 3L, "cac.jpg"));

        listaJuegos.add(new Videojuego(22L, "The Witcher 3: Wild Hunt", "RPG de mundo abierto con una historia profunda en un universo de fantasía oscura.", 9.99, 4L ,"witcheriii.jpg"));
        listaJuegos.add(new Videojuego(23L, "The Elder Scrolls V: Skyrim", "Exploras un enorme mundo de fantasía con libertad total para misiones, combate y exploración.", 19.99, 4L, "skyrim.jpg"));
        listaJuegos.add(new Videojuego(24L, "Cyberpunk 2077", "RPG futurista en una ciudad abierta donde tus decisiones afectan la historia y el mundo.", 39.99, 4L, "cyberpunk.jpg"));
        listaJuegos.add(new Videojuego(25L, "Dark Souls III", "RPG de acción desafiante con combates exigentes y ambientación oscura y misteriosa.", 29.99, 4L, "dsiii.jpg"));
        listaJuegos.add(new Videojuego(26L, "Persona 5 Royal", "RPG japonés donde combinas vida estudiantil con combates por turnos en mundos cognitivos.", 29.99, 4L, "p5r.webp"));
        listaJuegos.add(new Videojuego(27L, "Dragon Age: Inquisition", "RPG de fantasía donde lideras un grupo y tomas decisiones que afectan el destino del mundo.", 19.99, 4L, "dai.png"));
        listaJuegos.add(new Videojuego(28L, "Clair Obscur: Expedition 33", "RPG por turnos con mecánicas en tiempo real ambientado en un mundo inspirado en la Belle Époque francesa.", 49.99, 4L, "expedition33.webp"));
        listaJuegos.add(new Videojuego(29L, "Fallout 4", "RPG postapocalíptico donde exploras un mundo devastado lleno de decisiones y supervivencia.", 19.99, 4L, "fallout4.webp"));
        listaJuegos.add(new Videojuego(30L, "Kingdom Come: Deliverance", "RPG realista ambientado en la Edad Media sin elementos de fantasía.", 7.99, 4L, "kcd.jpg"));
        listaJuegos.add(new Videojuego(31L, "Octopath Traveler", "RPG clásico por turnos con estilo visual único y múltiples historias entrelazadas.", 23.99, 4L, "octopathtraveller.jpg"));
    }

    /**
     * Obtiene todos los videojuegos disponibles en el catálogo.
     * * @return Una copia de la {@link List} que contiene todos los videojuegos.
     */
    @Override
    public List<Videojuego> obtenerTodos() {
        return new ArrayList<>(listaJuegos);
    }

    /**
     * Filtra los videojuegos según su categoría.
     * <p>
     * Utiliza la API de Streams de Java para recorrer la lista y extraer
     * únicamente aquellos juegos cuyo {@code categoriaId} coincida con el proporcionado.
     * </p>
     * * @param categoriaId El identificador de la categoría a filtrar.
     * @return Una lista de videojuegos que pertenecen a dicha categoría.
     */
    @Override
    public List<Videojuego> buscarPorCategoria(Long categoriaId) {
        return listaJuegos.stream()
                .filter(j -> j.getCategoriaId().equals(categoriaId))
                .toList();
    }

    /**
     * Realiza una búsqueda de videojuegos por coincidencia en el título.
     * <p>
     * La búsqueda es insensible a mayúsculas y minúsculas (case-insensitive).
     * Si la consulta es nula o está vacía, se devuelve una lista vacía por seguridad.
     * </p>
     * * @param query El texto a buscar dentro de los títulos de los videojuegos.
     * @return Una lista de videojuegos cuyo título contenga la cadena buscada.
     */
    @Override
    public List<Videojuego> buscarPorNombre(String query) {
        if (query == null || query.isBlank()) return new ArrayList<>();
        return listaJuegos.stream()
                .filter(j -> j.getTitulo().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}