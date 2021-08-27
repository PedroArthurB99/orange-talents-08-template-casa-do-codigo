package br.com.orange.casadocodigo.controller.exception;

import br.com.orange.casadocodigo.controller.form.EstadoForm;

public class EstadoJaExistenteException extends RuntimeException {

    private EstadoForm form;

    public EstadoJaExistenteException(EstadoForm form) {
        this.form = form;
    }

    public EstadoForm getForm() {
        return form;
    }
}
