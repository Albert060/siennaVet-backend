package com.albert.veterinariatfm.app.modulos.auth;

import com.albert.veterinariatfm.app.modulos.vets.Vet;
import com.albert.veterinariatfm.app.modulos.vets.VetRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;

/**
 * Clase que se encarga de gestiona la autenticacion y la logica del Login.
 */
@Service
public class AuthService {

    @Autowired
    VetRepository vetRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private final SecretKey secretKey = Keys.hmacShaKeyFor("Wjq80fgqxkqWymlEc51eZAnAr9Ry3lHv".getBytes());

    /**
     * funcion que se encarga de validar la autenticacion del login para iniciar un inicio de sesion
     * y guardando el token para que quede la identificacion de quien esta logueado.
     * @param autenticacion
     * @return
     */
    public  AuthResponse login(Auth autenticacion){
        Vet result = vetRepository.findFirstByEmail(autenticacion.email);

        if (result == null){
            return new AuthResponse(false, "El Usuario no Existe");
        }

        boolean match = passwordEncoder.matches(autenticacion.contrasena, result.getContrasena());
        if (!match){
            return new AuthResponse(false, "Contraseña Inconrrecta");
        }
        String tokem = Jwts.builder()
                .claim("nombre", result.getNombre())
                .claim("apellido", result.getApellido())
                .claim("email", result.getEmail())
                .setSubject(result.getIdVet().toString())
                .setIssuer("siennaVet")
                .signWith(secretKey)
                .compact();
        return new AuthResponse(true, tokem);
    }

}