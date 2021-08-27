package br.com.orange.casadocodigo.controller.exception;

public class CampoUnicoException extends RuntimeException {

    public String campo;

    public CampoUnicoException(String campo) {
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}
