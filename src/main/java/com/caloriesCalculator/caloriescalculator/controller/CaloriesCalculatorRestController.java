package com.caloriesCalculator.caloriescalculator.controller;

import com.caloriesCalculator.caloriescalculator.model.CaloriesCalculatorResponseDTO;
import com.caloriesCalculator.caloriescalculator.model.DishDTO;
import com.caloriesCalculator.caloriescalculator.model.DishesCaloriesCalculatorResponseDTO;
import com.caloriesCalculator.caloriescalculator.service.ICaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaloriesCalculatorRestController {

    @Autowired
    ICaloriesCalculatorService service;

    @PostMapping(path="/dish")
    @ResponseBody
    public CaloriesCalculatorResponseDTO calculateCaloriesPerDish(@RequestBody DishDTO dish){
        return service.calculateCalories(dish);
    }

    @PostMapping(path="/dishes")
    @ResponseBody
    public DishesCaloriesCalculatorResponseDTO calculateCalories(@RequestBody List<DishDTO> dishes){
        return service.calculateCaloriesFromList(dishes);
    }

}
