package com.caloriesCalculator.caloriescalculator.exceptionhandler;

import com.caloriesCalculator.caloriescalculator.exception.IngredientNotFound;
import com.caloriesCalculator.caloriescalculator.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HandlerException extends Exception{

    @ExceptionHandler(IngredientNotFound.class)
    public ResponseEntity<ErrorDTO> handleException(IngredientNotFound exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Ingredient Not Found");
        errorDTO.setDescription("The ingredient " + exception + "not found");
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
