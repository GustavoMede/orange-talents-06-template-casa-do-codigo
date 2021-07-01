package br.com.zupacademy.gustavo.casadocodigo.handler;

import java.time.LocalDateTime;

public class ErroValidacaoDTO {

    private LocalDateTime currentDate;
    private String message;

    public ErroValidacaoDTO(){
    }

    public ErroValidacaoDTO(LocalDateTime currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public String getMessage() {
        return message;
    }
}
