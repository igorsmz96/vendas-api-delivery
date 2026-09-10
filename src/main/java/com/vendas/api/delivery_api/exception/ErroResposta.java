package com.vendas.api.delivery_api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErroResposta {
    @JsonFormat(pattern = "dd/MM/yyyy  HH:mm")
    private LocalDateTime timestamp;
    private int status;
    private List<String> erro;
    private String message;


    public ErroResposta(int status, String erro, String message) {
        this.timestamp = LocalDateTime.now().withSecond(0);
        this.status = status;
        this.erro = List.of(erro);
        this.message = message;
    }
    public ErroResposta(int status, List<String> erro, String message) {
        this.timestamp = LocalDateTime.now().withSecond(0);
        this.status = status;
        this.erro = erro;
        this.message = message;
    }
}
