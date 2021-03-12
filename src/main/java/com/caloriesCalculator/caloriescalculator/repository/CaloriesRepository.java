package com.caloriesCalculator.caloriescalculator.repository;

import com.caloriesCalculator.caloriescalculator.exception.IngredientNotFound;
import com.caloriesCalculator.caloriescalculator.exceptionhandler.HandlerException;
import com.caloriesCalculator.caloriescalculator.model.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesRepository implements ICaloriesRepository {
    private static final String FILEPATH = "classpath:food.json";
    private List<IngredientDTO> ingredients;

    public CaloriesRepository() {
        this.ingredients = new ArrayList<>();
        loadDataBase();
    }

    @Override
    public IngredientDTO findIngredientByName(String ingredient) throws IngredientNotFound{
        IngredientDTO result = null;
        Optional<IngredientDTO> item = this.ingredients
                .stream()
                .filter(ing -> ing.getName().equals(ingredient))
                .findFirst();

        if(item.isPresent()){
            result = item.get();
        } else {
            throw new IngredientNotFound(ingredient);
        }
        return result;
    }

    private void loadDataBase(){
        try {
            ObjectMapper mapper = new ObjectMapper();

            this.ingredients = mapper.readValue(ResourceUtils.getFile(FILEPATH), new TypeReference<>() {});

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
