package com.picpaysimplificado.infra;

import com.picpaysimplificado.dtos.ExcepetionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threadDuplicateEntry(DataIntegrityViolationException exception){
        ExcepetionDTO excepetionDTO = new ExcepetionDTO("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(excepetionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(EntityNotFoundException exception){
        ExcepetionDTO excepetionDTO = new ExcepetionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(excepetionDTO);
    }


}
