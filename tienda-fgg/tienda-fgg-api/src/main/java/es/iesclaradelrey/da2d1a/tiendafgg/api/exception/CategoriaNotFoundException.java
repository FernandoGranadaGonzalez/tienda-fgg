package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de negocio lanzada cuando se intenta acceder a una categoría inexistente.
 * <p>
 * Se utiliza principalmente en el {@code CategoriaApiController} y en el
 * {@code VideojuegoService} al validar relaciones durante la creación o filtrado.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class CategoriaNotFoundException extends RuntimeException {

    /** Identificador de la categoría que causó el fallo. */
    private final Long categoriaId;

    /**
     * Construye la excepción con un mensaje formateado y el ID del recurso.
     *
     * @param categoriaId ID que no se pudo localizar en la persistencia.
     */
    public CategoriaNotFoundException(Long categoriaId) {
        super("Categoría no encontrada con id: " + categoriaId);
        this.categoriaId = categoriaId;
    }

    /**
     * @return El ID de la categoría para propósitos de logging o trazabilidad.
     */
    public Long getCategoriaId() {
        return categoriaId;
    }
}