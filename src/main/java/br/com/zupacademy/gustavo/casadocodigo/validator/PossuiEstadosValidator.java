package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.dto.ClienteRequisicaoForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PossuiEstadosValidator implements ConstraintValidator<PossuiEstados, Object> {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(PossuiEstados constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        var objeto = (ClienteRequisicaoForm) o;
        String nomePais = objeto.getNomePais();
        String nomeEstado = objeto.getNomeEstado();
        Pais pais = paisRepository.findByNomePais(nomePais);
        if(pais == null){
            return false;
        }
        Estado possuiEstados = estadoRepository.findByNomePais(nomePais);
        if(possuiEstados != null && (nomeEstado == null || nomeEstado.isBlank())){
            return false;
        }else if(possuiEstados == null && nomeEstado.isBlank()){
            return true;
        }else{
            Estado estado = estadoRepository.findByNomePaisAndNomeEstado(nomePais, nomeEstado);
            return estado != null;
        }
    }
}
