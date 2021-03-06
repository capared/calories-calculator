package com.caloriesCalculator.caloriescalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DishDTO {
    private String name;
    private List<IngredientRequestDTO> ingredients;
}
