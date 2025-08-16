package com.floproje.StokYonetim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //!Eger bu hata bir response'ta kullanilirsa, status code'u 404 olacaktir.
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message); //!super parent'in constructor'ini cagirir.
    }
}
