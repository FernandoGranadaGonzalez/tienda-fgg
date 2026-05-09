package es.iesclaradelrey.da2d1a.tiendafgg.api.xml;

import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

/**
 * Servicio especializado en la transferencia de datos mediante formato XML.
 * <p>
 * Proporciona capacidades de exportación de catálogo completo y procesamiento
 * masivo de importaciones, asegurando la integridad de los datos mediante
 * transaccionalidad.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface XmlProductoService {

    /**
     * Genera una representación en memoria (Árbol DOM) de todos los productos.
     * <p>
     * Utiliza la API {@link Document} de W3C para estructurar dinámicamente el
     * catálogo actual, incluyendo metadatos de marcas y categorías.
     * </p>
     *
     * @return Objeto Document listo para ser transformado a Stream o Fichero.
     */
    Document exportarProductosXml();

    /**
     * Procesa un archivo XML cargado por el usuario e integra los datos en el sistema.
     * <p>
     * La implementación debe delegar en un {@link SaxProductoHandler} para un parseo
     * eficiente. Es mandatorio que este método sea transaccional: si un solo producto
     * falla en la validación o inserción, toda la importación debe revertirse.
     * </p>
     *
     * @param file Fichero XML recibido a través de una petición Multi-part.
     * @throws es.iesclaradelrey.da2d1a.tiendafgg.api.exception.XmlImportException
     *         si el archivo es corrupto o no cumple el esquema.
     */
    void importarProductosXml(MultipartFile file);
}