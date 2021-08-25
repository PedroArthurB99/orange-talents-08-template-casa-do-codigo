package br.com.orange.casadocodigo.controller.exception;

public class ObjetoErroDTO {

    private String campo;
    private String erro;


    public ObjetoErroDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
