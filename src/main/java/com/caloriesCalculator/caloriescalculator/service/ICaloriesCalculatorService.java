package com.caloriesCalculator.caloriescalculator.service;

import com.caloriesCalculator.caloriescalculator.exception.IngredientNotFound;
import com.caloriesCalculator.caloriescalculator.model.CaloriesCalculatorResponseDTO;
import com.caloriesCalculator.caloriescalculator.model.DishDTO;
import com.caloriesCalculator.caloriescalculator.model.DishesCaloriesCalculatorResponseDTO;

import java.util.List;

public interface ICaloriesCalculatorService {

    CaloriesCalculatorResponseDTO calculateCalories(DishDTO dish) throws IngredientNotFound;

    DishesCaloriesCalculatorResponseDTO calculateCaloriesFromList(List<DishDTO> dishes);
}
