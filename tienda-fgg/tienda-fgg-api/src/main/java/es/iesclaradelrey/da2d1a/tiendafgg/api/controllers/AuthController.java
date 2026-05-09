package es.iesclaradelrey.da2d1a.tiendafgg.api.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.*;
import es.iesclaradelrey.da2d1a.tiendafgg.api.jwt.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST encargado de la autenticación basada en JWT.
 * <p>
 * Proporciona los endpoints necesarios para que los clientes obtengan y
 * renueven sus tokens de acceso sin necesidad de mantener sesiones en el servidor (Stateless).
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService    userDetailsService;
    private final JwtService            jwtService;

    /**
     * Inyección de los componentes de seguridad necesarios para la gestión de tokens.
     */
    public AuthController(AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService    = userDetailsService;
        this.jwtService            = jwtService;
    }

    /**
     * Endpoint de inicio de sesión.
     * <p>
     * Valida las credenciales del usuario. Si son correctas, genera un par de tokens:
     * 1. Access Token: De vida corta, para acceder a recursos protegidos.
     * 2. Refresh Token: De vida larga, para obtener nuevos access tokens sin pedir login.
     * </p>
     *
     * @param request DTO con username y password.
     * @return {@link ResponseEntity} con {@link TokenResponseDto} o estado 401 si falla.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String accessToken  = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return ResponseEntity.ok(new TokenResponseDto(accessToken, refreshToken));
    }

    /**
     * Endpoint para la renovación del token de acceso.
     * <p>
     * Permite al cliente obtener un nuevo Access Token enviando un Refresh Token válido,
     * evitando que el usuario tenga que introducir sus credenciales constantemente.
     * </p>
     *
     * @param request DTO que contiene el refresh token.
     * @return {@link ResponseEntity} con el nuevo access token o 400 si el token ha expirado o es inválido.
     */
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequestDto request) {
        try {
            String username = jwtService.extractUsername(request.getRefreshToken());
            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (!jwtService.isTokenValid(request.getRefreshToken(), user)) {
                return ResponseEntity.badRequest().build();
            }

            String newAccessToken = jwtService.generateAccessToken(user);
            return ResponseEntity.ok(new AccessTokenResponseDto(newAccessToken));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}