package com.albert.veterinariatfm.app.modulos.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que gestiona por el @RequestBody los datos enviados en el formulario,
 * y devuelte si es correcto o no.
 */
@RestController
@RequestMapping ("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @PostMapping
    public AuthResponse login (@RequestBody Auth auth){
        return authService.login(auth);
    }
}
