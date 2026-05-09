package es.iesclaradelrey.da2d1a.tiendafgg.api.mapper;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.CategoriaResumenDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.MarcaDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.VideojuegoDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper principal para la entidad Videojuego.
 * <p>
 * Gestiona la transformación de la entidad raíz y sus relaciones anidadas.
 * MapStruct utiliza una estrategia de composición: para mapear un Videojuego,
 * invoca internamente los métodos definidos para Marca y Categoria.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface VideojuegoMapper {

    /**
     * Mapea un Videojuego a su DTO completo.
     * Incluye la resolución automática de marca y categorías.
     */
    VideojuegoDto toDto(Videojuego videojuego);

    /**
     * Transforma colecciones de videojuegos, ideal para el catálogo principal.
     */
    List<VideojuegoDto> toDtoList(List<Videojuego> videojuegos);

    /**
     * Método auxiliar para transformar la Marca asociada.
     * MapStruct lo inyectará en el flujo de {@code toDto}.
     */
    MarcaDto marcaToDto(Marca marca);

    /**
     * Método auxiliar para transformar Categorías en su versión simplificada.
     * Permite reducir el peso del JSON resultante al evitar datos redundantes.
     */
    CategoriaResumenDto categoriaToResumenDto(Categoria categoria);
}