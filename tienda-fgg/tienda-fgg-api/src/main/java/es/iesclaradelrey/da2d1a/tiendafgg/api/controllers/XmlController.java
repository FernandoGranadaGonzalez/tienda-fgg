package es.iesclaradelrey.da2d1a.tiendafgg.api.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.api.xml.XmlProductoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controlador REST especializado en la importación y exportación de datos en formato XML.
 * <p>
 * Este componente permite la persistencia externa y la carga masiva de productos,
 * gestionando la serialización DOM y la recepción de archivos multimedia.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/xml")
public class XmlController {

    private final XmlProductoService xmlProductoService;

    /**
     * Inyección del servicio de lógica XML.
     */
    public XmlController(XmlProductoService xmlProductoService) {
        this.xmlProductoService = xmlProductoService;
    }

    /**
     * Genera y descarga un archivo XML con el catálogo completo de productos.
     * <p>
     * Utiliza {@link Transformer} para dar formato al documento (indentación y encoding)
     * y escribe el resultado directamente en el flujo de salida de la respuesta HTTP.
     * El nombre del archivo incluye una marca de tiempo dinámica.
     * </p>
     *
     * @param response Objeto de respuesta de Servlet para gestionar la descarga.
     * @throws IOException Si ocurre un error en la escritura del flujo.
     */
    @GetMapping
    public void exportarXml(HttpServletResponse response) throws IOException {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd.HH-mm"));
        String filename = "products-export." + timestamp + ".xml";

        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        Document doc = xmlProductoService.exportarProductosXml();

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            transformer.transform(
                    new DOMSource(doc),
                    new StreamResult(response.getOutputStream())
            );

        } catch (TransformerException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Error al serializar el XML: " + e.getMessage());
        }
    }

    /**
     * Recibe un archivo XML para procesar e importar nuevos productos al sistema.
     * <p>
     * El archivo se recibe mediante una petición POST con formato 'multipart/form-data'.
     * </p>
     *
     * @param file El archivo XML subido por el cliente.
     * @return 201 Created si la importación se completa correctamente.
     */
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Void> importarXml(
            @RequestParam("productsfile") MultipartFile file) {

        xmlProductoService.importarProductosXml(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}