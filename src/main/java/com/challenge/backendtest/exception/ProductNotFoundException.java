package com.challenge.backendtest.exception;

public class ProductNotFoundException extends RuntimeException {

    private final String codigo;
    private final String descripcion;

    public ProductNotFoundException(String codigo, String descripcion) {
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
