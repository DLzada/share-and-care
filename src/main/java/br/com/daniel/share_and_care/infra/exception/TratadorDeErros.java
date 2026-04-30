package br.com.daniel.share_and_care.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(
          erros.stream().map(DadosErroValidacao::new).toList()
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> tratarErroDeNegocio(BusinessException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
