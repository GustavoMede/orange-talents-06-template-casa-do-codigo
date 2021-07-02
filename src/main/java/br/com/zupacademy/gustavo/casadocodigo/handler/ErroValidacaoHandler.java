package br.com.zupacademy.gustavo.casadocodigo.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> descricaoErro = ex.getBindingResult().getFieldErrors();
        List<ObjectError> descricaoErroObjects = ex.getBindingResult().getGlobalErrors();

        ErroValidacaoDTO erro = new ErroValidacaoDTO(LocalDateTime.now(), descricaoErro, descricaoErroObjects);
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
