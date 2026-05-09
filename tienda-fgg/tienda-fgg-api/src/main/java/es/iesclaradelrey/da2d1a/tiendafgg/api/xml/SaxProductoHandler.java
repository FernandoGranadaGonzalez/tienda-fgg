package es.iesclaradelrey.da2d1a.tiendafgg.api.xml;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.XmlProductoDto;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Analizador sintáctico (Parser) basado en eventos para la importación de productos.
 * <p>
 * Implementa la estrategia SAX para recorrer el árbol XML sin cargarlo íntegramente
 * en memoria. Durante el proceso, construye objetos {@link XmlProductoDto} capturando
 * tanto el contenido de las etiquetas como sus atributos (ej. IDs de marca y categoría).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class SaxProductoHandler extends DefaultHandler {

    /** Lista resultante de productos procesados. */
    private final List<XmlProductoDto> productos = new ArrayList<>();

    /** Referencia temporal al producto que se está parseando actualmente. */
    private XmlProductoDto productoActual;

    /** Acumulador de texto para el contenido entre etiquetas. */
    private StringBuilder buffer;

    /** Variable de estado para trackear la categoría procesada en el flujo. */
    private Long categoriaIdActual;

    /**
     * @return La colección de productos extraída tras finalizar el parseo.
     */
    public List<XmlProductoDto> getProductos() {
        return productos;
    }

    /**
     * Evento disparado al abrir una etiqueta XML.
     * Gestiona la instanciación de nuevos DTOs y la extracción de metadatos (IDs).
     */
    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
        buffer = new StringBuilder();

        switch (qName) {
            case "product" -> productoActual = new XmlProductoDto();

            case "brand" -> {
                String idStr = attributes.getValue("id");
                if (idStr != null) {
                    productoActual.setMarcaId(Long.parseLong(idStr));
                }
            }

            case "category" -> {
                String idStr = attributes.getValue("id");
                if (idStr != null) {
                    categoriaIdActual = Long.parseLong(idStr);
                    productoActual.getCategoriaIds().add(categoriaIdActual);
                }
            }
        }
    }

    /**
     * Acumula el contenido textual encontrado entre etiquetas.
     * SAX puede llamar a este método varias veces para una misma etiqueta.
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }

    /**
     * Evento disparado al cerrar una etiqueta XML.
     * Mapea el texto acumulado en el buffer hacia los campos correspondientes del DTO.
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        String texto = buffer.toString().trim();

        switch (qName) {
            case "product"      -> productos.add(productoActual);
            case "ean"          -> productoActual.setEan(texto);
            case "title"        -> productoActual.setTitulo(texto);
            case "description"  -> productoActual.setDescripcion(texto);
            case "price"        -> productoActual.setPrecio(Double.parseDouble(texto));
            case "discount"     -> productoActual.setDescuento(Integer.parseInt(texto));
            case "stock"        -> productoActual.setStock(Integer.parseInt(texto));
            case "image"        -> productoActual.setImagen(texto);
            case "brand"        -> productoActual.setMarcaNombre(texto);
            case "category"     -> productoActual.getCategoriaNombres().add(texto);
        }
    }
}