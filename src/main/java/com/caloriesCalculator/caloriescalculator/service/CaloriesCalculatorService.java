package com.caloriesCalculator.caloriescalculator.service;

import com.caloriesCalculator.caloriescalculator.exception.IngredientNotFound;
import com.caloriesCalculator.caloriescalculator.exceptionhandler.HandlerException;
import com.caloriesCalculator.caloriescalculator.model.CaloriesCalculatorResponseDTO;
import com.caloriesCalculator.caloriescalculator.model.DishDTO;
import com.caloriesCalculator.caloriescalculator.model.DishesCaloriesCalculatorResponseDTO;
import com.caloriesCalculator.caloriescalculator.model.IngredientRequestDTO;
import com.caloriesCalculator.caloriescalculator.repository.ICaloriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CaloriesCalculatorService implements ICaloriesCalculatorService{

    @Autowired
    ICaloriesRepository repository;

    @Override
    public CaloriesCalculatorResponseDTO calculateCalories(DishDTO dish) throws IngredientNotFound{
        CaloriesCalculatorResponseDTO response = new CaloriesCalculatorResponseDTO();
        double totalCalories = 0;
        IngredientRequestDTO maxCalorieIngredient = new IngredientRequestDTO();
        HashMap<String, Double> caloriesPerIng = new HashMap<>();
        for(IngredientRequestDTO ingredient: dish.getIngredients()){
            double calories = calculateCalories(ingredient);
            totalCalories = totalCalories + calories;
            caloriesPerIng.put(ingredient.getName(), calories);

            if(maxCalorieIngredient.getName() == null || calculateCalories(maxCalorieIngredient) <= calories) {
                maxCalorieIngredient.setName(ingredient.getName());
                maxCalorieIngredient.setGrams(ingredient.getGrams());
            }
        }
        response.setTotalCalories(totalCalories);
        response.setCaloriesPerIngedients(caloriesPerIng);
        response.setMaxCaloriesIngredient(maxCalorieIngredient.getName());
        return response;
    }

    @Override
    public DishesCaloriesCalculatorResponseDTO calculateCaloriesFromList(List<DishDTO> dishes) {
        DishesCaloriesCalculatorResponseDTO responseList = new DishesCaloriesCalculatorResponseDTO();
        List<CaloriesCalculatorResponseDTO> result = new ArrayList<>();
        for(DishDTO dish: dishes){
            result.add(calculateCalories(dish));
        }
        responseList.setDishesList(result);
        return responseList;
    }

    private double calculateCalories(IngredientRequestDTO ingredient){
        return ((this.repository.findIngredientByName(ingredient.getName()).getCalories())) * ingredient.getGrams();
    }
}
