package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.MarcaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de los servicios de negocio para la entidad {@link Marca}.
 * <p>
 * Esta clase actúa como intermediaria entre la capa de presentación (controladores)
 * y la capa de datos (repositorios), asegurando que las operaciones sobre las
 * marcas se realicen de forma consistente.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class MarcaServiceImpl implements MarcaService {

    /**
     * Repositorio de marcas utilizado para las operaciones de persistencia.
     */
    private final MarcaRepository marcaRepository;

    /**
     * Constructor para inyección de dependencias.
     * <p>
     * Al usar inyección por constructor, facilitamos la creación de pruebas unitarias
     * y garantizamos que el servicio siempre cuente con su repositorio necesario.
     * </p>
     *
     * @param marcaRepository Instancia del repositorio de marcas gestionada por Spring.
     */
    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    /**
     * Obtiene el listado completo de marcas disponibles en el catálogo.
     *
     * @return Lista de objetos {@link Marca}.
     */
    @Override
    public List<Marca> obtenerTodos() {
        return marcaRepository.findAll();
    }

    /**
     * Recupera la información de una marca específica a partir de su identificador.
     *
     * @param id Identificador único de la marca.
     * @return Un {@link Optional} que envuelve la marca si existe, facilitando el control de nulos.
     */
    @Override
    public Optional<Marca> buscarPorId(Long id) {
        return marcaRepository.findById(id);
    }

    /**
     * Registra una nueva marca o actualiza los datos de una ya existente.
     *
     * @param marca Objeto marca con la información a persistir.
     */
    @Override
    public void guardar(Marca marca) {
        marcaRepository.save(marca);
    }

    /**
     * Elimina de forma permanente una marca de la base de datos.
     * <p>
     * <b>Nota:</b> Debido a la configuración de {@code CascadeType.ALL} en la entidad,
     * eliminar una marca podría provocar la eliminación en cascada de sus videojuegos asociados.
     * </p>
     *
     * @param id Identificador de la marca a eliminar.
     */
    @Override
    public void eliminar(Long id) {
        marcaRepository.deleteById(id);
    }
}