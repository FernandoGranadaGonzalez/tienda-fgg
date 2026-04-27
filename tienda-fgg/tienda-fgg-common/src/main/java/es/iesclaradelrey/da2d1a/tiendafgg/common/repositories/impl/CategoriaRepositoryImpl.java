package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación en memoria del repositorio de categorías.
 * <p>
 * Esta clase extiende de {@link GenericoRepositoryImpl} para aprovechar la gestión
 * básica de entidades y cumple con el contrato definido en {@link CategoriaRepository}.
 * Al estar marcada con {@code @Repository}, Spring la gestiona como un bean de la capa de datos.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Repository
public class CategoriaRepositoryImpl extends GenericoRepositoryImpl<Categoria, Long> implements CategoriaRepository {

    /**
     * Constructor por defecto.
     * <p>
     * Al instanciarse, se encarga de "sembrar" (seeding) el repositorio con datos de prueba
     * iniciales para que la aplicación tenga contenido disponible desde el arranque.
     * </p>
     */
    public CategoriaRepositoryImpl() {
        this.guardar(new Categoria(1L, "Aventura", "Explora mundos épicos", "aventura.jpg"));
        this.guardar(new Categoria(2L, "Shooter", "Acción frenética en primera persona", "shooter.png"));
        this.guardar(new Categoria(3L, "Estrategia", "Planifica tu victoria", "estrategia.png"));
        this.guardar(new Categoria(4L, "RPG", "Juegos de rol y fantasía", null));
    }

    /**
     * Almacena una categoría en el mapa interno de entidades.
     * <p>
     * Utiliza el ID de la categoría como clave para facilitar búsquedas rápidas.
     * Si el ID ya existe, la categoría anterior será sobrescrita (operación save/update).
     * </p>
     *
     * @param categoria El objeto categoría que se desea persistir.
     */
    @Override
    public void guardar(Categoria categoria) {
        entidades.put(categoria.getId(), categoria);
    }

    /**
     * Recupera una lista con todas las categorías disponibles.
     * * @return Una {@link List} que contiene todas las entidades almacenadas.
     * Si no hay categorías, devuelve una lista vacía.
     */
    @Override
    public List<Categoria> obtenerTodos() {
        return new ArrayList<>(entidades.values());
    }

    /**
     * Busca una categoría específica mediante su identificador.
     * * @param id El identificador único de la categoría.
     * @return Un {@link Optional} que contiene la categoría si se encuentra,
     * o un {@code Optional.empty()} en caso contrario.
     */
    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return Optional.ofNullable(entidades.get(id));
    }
}