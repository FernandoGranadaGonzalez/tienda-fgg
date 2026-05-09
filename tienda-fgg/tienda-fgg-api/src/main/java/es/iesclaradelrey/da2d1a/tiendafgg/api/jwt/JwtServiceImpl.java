package es.iesclaradelrey.da2d1a.tiendafgg.api.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * Implementación del servicio de gestión de tokens JWT.
 * <p>
 * Se encarga de la creación, parseo y validación de tokens utilizando
 * algoritmos HMAC-SHA. Las claves y tiempos de expiración se configuran
 * externamente para mayor flexibilidad y seguridad.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class JwtServiceImpl implements JwtService {

    private final SecretKey secretKey;
    private final long accessExpiration;
    private final long refreshExpiration;

    /**
     * Constructor que inicializa la clave secreta y tiempos de vida.
     *
     * @param secret Clave en formato Base64 definida en application.properties.
     * @param accessExpiration Tiempo de vida para tokens de acceso (ms).
     * @param refreshExpiration Tiempo de vida para tokens de refresco (ms).
     */
    public JwtServiceImpl(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.access-token.expiration}") long accessExpiration,
            @Value("${jwt.refresh-token.expiration}") long refreshExpiration) {

        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
        this.accessExpiration = accessExpiration;
        this.refreshExpiration = refreshExpiration;
    }

    @Override
    public String generateAccessToken(UserDetails user) {
        return buildToken(user, accessExpiration, TipoToken.ACCESS);
    }

    @Override
    public String generateRefreshToken(UserDetails user) {
        return buildToken(user, refreshExpiration, TipoToken.REFRESH);
    }

    /**
     * Método centralizado para la construcción de la estructura JWT.
     */
    private String buildToken(UserDetails user, long expiration, TipoToken tipo) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(now))
                .expiration(new Date(now + expiration))
                .claims(Map.of("type", tipo.name()))
                .signWith(secretKey)
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    @Override
    public Boolean isTokenValid(String token, UserDetails user) {
        try {
            String username = extractUsername(token);
            return username.equals(user.getUsername()) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Realiza el parseo del token y verifica la firma criptográfica.
     * @throws io.jsonwebtoken.JwtException si la firma no es válida.
     */
    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}