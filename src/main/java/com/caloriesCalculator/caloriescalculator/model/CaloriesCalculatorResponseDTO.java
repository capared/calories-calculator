package com.caloriesCalculator.caloriescalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class CaloriesCalculatorResponseDTO {
    private double totalCalories;
    private HashMap<String, Double> caloriesPerIngedients;
    private String maxCaloriesIngredient;
}
