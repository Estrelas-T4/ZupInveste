package br.com.zup.ZupSimula.confg;

import br.com.zup.ZupSimula.simulacao.exceptions.ValorBaixoParaRiscoAltoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> manipularErrosDeValidacao(MethodArgumentNotValidException exception){
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()){
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField(),
                    fieldError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }

        return erros;
    }

    @ExceptionHandler(ValorBaixoParaRiscoAltoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoDeRiscoAltoEValorBaixo(ValorBaixoParaRiscoAltoException exception){
        return new MensagemDeErro(exception.getMessage());
    }

   @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manupularExcecaoDeEnumInvalido(HttpMessageNotReadableException exception){
      if(exception.getLocalizedMessage().contains("br.com.zup.ZupSimula.Simulacao.enuns.Risco")){
          return new MensagemDeErro("Risco não reconhecido");
      }
        return new MensagemDeErro(exception.getLocalizedMessage());
    }
}
