package com.caloriesCalculator.caloriescalculator.repository;

import com.caloriesCalculator.caloriescalculator.exception.IngredientNotFound;
import com.caloriesCalculator.caloriescalculator.model.IngredientDTO;

public interface ICaloriesRepository {

    IngredientDTO findIngredientByName(String ingredient) throws IngredientNotFound;
}
