package org.example.utils;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class TokenUtil {

    @Value("${TokenSalt}")
    public static String TokenSalt;


    public static String GenneratorToken(Object object){
        String parameter = object.toString();
        String token = UUID.randomUUID() + TokenSalt + parameter;
        return token.toUpperCase();
    }


}
