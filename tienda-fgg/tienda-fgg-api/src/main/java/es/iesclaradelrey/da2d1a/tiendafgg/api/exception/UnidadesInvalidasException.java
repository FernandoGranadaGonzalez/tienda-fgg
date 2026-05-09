package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de validación de dominio.
 * <p>
 * Se lanza cuando un cliente intenta enviar una cantidad de unidades
 * que no cumple con el requisito mínimo de ser un entero positivo (u > 0).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class UnidadesInvalidasException extends RuntimeException {

    /**
     * Construye la excepción con un mensaje de error predefinido
     * indicando la restricción de valor.
     */
    public UnidadesInvalidasException() {
        super("Las unidades deben ser mayor que cero.");
    }
}