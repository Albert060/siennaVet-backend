package com.albert.veterinariatfm.app.modulos.auth;

import com.albert.veterinariatfm.app.modulos.vets.Vet;
import com.albert.veterinariatfm.app.modulos.vets.VetRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    VetRepository vetRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public  AuthResponse login(Auth autenticacion){
        Vet result = vetRepository.findFirstByEmail(autenticacion.email);

        if (result == null){
            return new AuthResponse(false, "El Usuario no Existe");
        }

        boolean match = passwordEncoder.matches(autenticacion.contrasena, result.getContrasena());
        if (!match){
            return new AuthResponse(false, "Contraseña Inconrrecta");
        }
        String tokem = Jwts.builder().setSubject(result.getIdVet().toString()).setIssuer("siennaVet").compact();
        return new AuthResponse(true, tokem);
    }

}