package com.example.pizzaDelivery.repository;

import com.example.pizzaDelivery.model.Ingredient;

import java.sql.ResultSet;
import java.util.Optional;

public class IngredientRepositoryImplementation implements IngredientRepository{
    private JdbcTemplate jdbcTemplate;
    public IngredientRepositoryImplementation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id
        );
        return results.size() == 0? Optional.empty();Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException{
        return new Ingredient(
                row.getString("id"),
                row.getString("name");
                Ingredient.Type.valueOf(row.getString("type"));

        );
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
       jdbcTemplate.update(
               "insert into Ingredient (id, name,type) values(?,?,?)",
               ingredient.getId(),
               ingredient.getName(),
               ingredient.getType().toString()
       );
       return ingredient;
    }
}
