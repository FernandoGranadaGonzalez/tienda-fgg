package es.iesclaradelrey.da2d1a.tiendafgg.api.mapper;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper para la gestión de categorías de videojuegos.
 * <p>
 * Facilita la conversión entre la entidad persistente {@link Categoria} y su
 * representación de transporte {@link CategoriaDto}. Al seguir una convención
 * de nombres idéntica entre ambos objetos, la implementación generada es
 * altamente eficiente y libre de errores manuales.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    /**
     * Convierte una entidad Categoria en un DTO para la API.
     *
     * @param categoria Entidad proveniente de la base de datos.
     * @return DTO listo para ser enviado en formato JSON.
     */
    CategoriaDto toDto(Categoria categoria);

    /**
     * Convierte una colección de entidades en una lista de DTOs.
     * <p>
     * Este método es fundamental para los endpoints de listado de categorías
     * utilizados en los filtros de búsqueda del frontend.
     * </p>
     *
     * @param categorias Lista de entidades Categoria.
     * @return Lista de DTOs mapeados.
     */
    List<CategoriaDto> toDtoList(List<Categoria> categorias);
}