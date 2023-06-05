package com.challenge.backendtest.exception;

public class NotConnectionCLientException extends RuntimeException {

    private final String codigo;
    private final String descripcion;


    public NotConnectionCLientException(String codigo, String descripcion) {
        this.codigo=codigo;
        this.descripcion=descripcion;
    }



    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
