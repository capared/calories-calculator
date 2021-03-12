package com.caloriesCalculator.caloriescalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DishesCaloriesCalculatorResponseDTO {
    List<CaloriesCalculatorResponseDTO> dishesList;
}
