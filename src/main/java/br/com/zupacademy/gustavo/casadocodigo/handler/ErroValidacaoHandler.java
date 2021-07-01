package br.com.zupacademy.gustavo.casadocodigo.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle(Exception e, WebRequest request){
        String descricaoErro = e.getLocalizedMessage();
        if(descricaoErro == null){
            descricaoErro = e.toString();
        }
        ErroValidacaoDTO erro = new ErroValidacaoDTO(LocalDateTime.now(), descricaoErro);
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
