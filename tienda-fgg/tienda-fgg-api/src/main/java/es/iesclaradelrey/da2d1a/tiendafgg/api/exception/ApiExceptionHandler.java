package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

/**
 * Gestor centralizado de excepciones para la API REST.
 * <p>
 * Transforma las excepciones de lógica de negocio en objetos {@link ProblemDetail},
 * garantizando que los errores sigan el estándar RFC 9457. Esto permite que los
 * clientes de la API reciban respuestas semánticas y estructuradas.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * Gestiona errores de recursos no encontrados (404).
     */
    @ExceptionHandler(ProductoNotFoundException.class)
    public ProblemDetail handleProductoNotFound(ProductoNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Producto no encontrado");
        problem.setType(URI.create("/errors/producto-no-encontrado"));
        return problem;
    }

    /**
     * Gestiona conflictos de inventario (409).
     */
    @ExceptionHandler(StockInsuficienteException.class)
    public ProblemDetail handleStockInsuficiente(StockInsuficienteException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getMessage());
        problem.setTitle("Stock insuficiente");
        problem.setType(URI.create("/errors/stock-insuficiente"));
        return problem;
    }

    /**
     * Gestiona peticiones mal formadas o con datos fuera de rango (400).
     */
    @ExceptionHandler(UnidadesInvalidasException.class)
    public ProblemDetail handleUnidadesInvalidas(UnidadesInvalidasException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Unidades inválidas");
        problem.setType(URI.create("/errors/unidades-invalidas"));
        return problem;
    }

    /**
     * Gestiona intentos de manipulación de ítems inexistentes en el carrito (409).
     */
    @ExceptionHandler(ProductoNoEnCarritoException.class)
    public ProblemDetail handleProductoNoEnCarrito(ProductoNoEnCarritoException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getMessage());
        problem.setTitle("Producto no está en el carrito");
        problem.setType(URI.create("/errors/producto-no-en-carrito"));
        return problem;
    }

    @ExceptionHandler(MarcaNotFoundException.class)
    public ProblemDetail handleMarcaNotFound(MarcaNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Marca no encontrada");
        problem.setType(URI.create("/errors/marca-no-encontrada"));
        return problem;
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ProblemDetail handleCategoriaNotFound(CategoriaNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Categoría no encontrada");
        problem.setType(URI.create("/errors/categoria-no-encontrada"));
        return problem;
    }

    /**
     * Captura fallos durante el proceso de importación masiva (400).
     */
    @ExceptionHandler(XmlImportException.class)
    public ProblemDetail handleXmlImport(XmlImportException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Error al importar XML");
        problem.setType(URI.create("/errors/xml-import-error"));
        return problem;
    }
}