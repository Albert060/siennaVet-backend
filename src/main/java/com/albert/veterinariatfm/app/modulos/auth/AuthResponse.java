package com.albert.veterinariatfm.app.modulos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    boolean success;
    String mensaje;
}
