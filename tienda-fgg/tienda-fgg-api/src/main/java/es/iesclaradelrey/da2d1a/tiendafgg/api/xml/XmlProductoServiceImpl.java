package es.iesclaradelrey.da2d1a.tiendafgg.api.xml;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.XmlProductoDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.exception.*;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.MarcaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Orquestador de procesos XML para el catálogo de la tienda.
 * <p>
 * Implementa una estrategia dual:
 * <ul>
 *     <li><b>DOM:</b> Para la exportación, permitiendo un control total sobre la jerarquía de nodos.</li>
 *     <li><b>SAX:</b> Para la importación, optimizando el uso de memoria ante ficheros de gran volumen.</li>
 * </ul>
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class XmlProductoServiceImpl implements XmlProductoService {

    private final VideojuegoRepository videojuegoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    public XmlProductoServiceImpl(VideojuegoRepository videojuegoRepository,
                                  MarcaRepository marcaRepository,
                                  CategoriaRepository categoriaRepository) {
        this.videojuegoRepository = videojuegoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Document exportarProductosXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.setXmlStandalone(true);

            Element root = doc.createElement("products");
            doc.appendChild(root);

            List<Videojuego> todos = videojuegoRepository.findAll();

            for (Videojuego v : todos) {
                Element product = doc.createElement("product");
                root.appendChild(product);

                appendTextElement(doc, product, "ean", v.getCodigoEan());
                appendTextElement(doc, product, "title", v.getTitulo());
                appendTextElement(doc, product, "description", v.getDescripcion());
                appendTextElement(doc, product, "price", String.valueOf(v.getPrecio()));
                appendTextElement(doc, product, "discount", String.valueOf(v.getDescuento()));
                appendTextElement(doc, product, "stock", String.valueOf(v.getStock()));
                appendTextElement(doc, product, "image", v.getImagen());

                Element brand = doc.createElement("brand");
                brand.setAttribute("id", String.valueOf(v.getMarca().getId()));
                brand.setTextContent(v.getMarca().getNombre());
                product.appendChild(brand);

                Element categories = doc.createElement("categories");
                product.appendChild(categories);
                for (Categoria c : v.getCategorias()) {
                    Element category = doc.createElement("category");
                    category.setAttribute("id", String.valueOf(c.getId()));
                    category.setTextContent(c.getNombre());
                    categories.appendChild(category);
                }
            }
            return doc;
        } catch (Exception e) {
            throw new XmlImportException("Error crítico en la generación del DOM: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void importarProductosXml(MultipartFile file) {
        List<XmlProductoDto> dtos = parsearConSax(file);

        List<Videojuego> videojuegosAGuardar = new ArrayList<>();

        for (XmlProductoDto dto : dtos) {
            Marca marca = marcaRepository.findById(dto.getMarcaId())
                    .orElseThrow(() -> new MarcaNotFoundException(dto.getMarcaId()));

            List<Categoria> categorias = new ArrayList<>();
            for (Long catId : dto.getCategoriaIds()) {
                Categoria categoria = categoriaRepository.findById(catId)
                        .orElseThrow(() -> new CategoriaNotFoundException(catId));
                categorias.add(categoria);
            }

            Videojuego videojuego = Videojuego.builder()
                    .codigoEan(dto.getEan())
                    .titulo(dto.getTitulo())
                    .descripcion(dto.getDescripcion())
                    .precio(dto.getPrecio())
                    .descuento(dto.getDescuento())
                    .stock(dto.getStock() != null ? dto.getStock() : 10)
                    .imagen(dto.getImagen() != null ? dto.getImagen() : "no-image.jpg")
                    .marca(marca)
                    .categorias(categorias)
                    .build();

            videojuegosAGuardar.add(videojuego);
        }

        videojuegoRepository.saveAll(videojuegosAGuardar);
    }

    private List<XmlProductoDto> parsearConSax(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxProductoHandler handler = new SaxProductoHandler();
            parser.parse(is, handler);
            return handler.getProductos();
        } catch (Exception e) {
            throw new XmlImportException("Fallo en el flujo SAX: " + e.getMessage(), e);
        }
    }

    private void appendTextElement(Document doc, Element parent, String tagName, String textContent) {
        Element el = doc.createElement(tagName);
        el.setTextContent(textContent != null ? textContent : "");
        parent.appendChild(el);
    }
}