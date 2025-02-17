package br.com.orange.casadocodigo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class APIExceptionHandler {

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public List<ObjetoErroDTO> handleMethodNotValid(MethodArgumentNotValidException exception) {
        List<ObjetoErroDTO> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.stream().forEach(e -> {
            String mensagem = "Por favor, preencha corretamente este campo!";
            ObjetoErroDTO erro = new ObjetoErroDTO(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EstadoJaExistenteException.class)
    public ObjetoErroDTO handleEstadoExistePais(EstadoJaExistenteException exception) {
        String mensagem = "O estado que você preencheu já existe neste país!";
        ObjetoErroDTO dto = new ObjetoErroDTO(exception.getForm().getNome(), mensagem);
        return dto;
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CampoUnicoException.class})
    public ObjetoErroDTO handleCampoUnico(CampoUnicoException exception) {
        String mensagem = "Este " + exception.getCampo() +" já existe.";
        ObjetoErroDTO dto = new ObjetoErroDTO(exception.getCampo(), mensagem);
        return dto;
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler({RegraNegocioException.class})
    public ObjetoErroDTO handleCampoUnico(RegraNegocioException exception) {
        return exception.getObjetoErroDTO();
    }
}

