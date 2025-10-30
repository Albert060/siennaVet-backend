package com.albert.veterinariatfm.app.modulos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * clase que define el token de autenticacion y identifica si es valido o no.
 */
@Data
@AllArgsConstructor
public class AuthResponse {

    boolean success;
    String mensaje;
}
