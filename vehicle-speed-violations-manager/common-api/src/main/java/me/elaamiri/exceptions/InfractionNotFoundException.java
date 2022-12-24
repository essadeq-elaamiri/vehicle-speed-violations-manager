package me.elaamiri.exceptions;

public class InfractionNotFoundException extends RuntimeException{

    public InfractionNotFoundException(String message) {
        super(message);
    }
}
