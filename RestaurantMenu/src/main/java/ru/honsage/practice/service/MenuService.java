package ru.honsage.practice.service;

import ru.honsage.practice.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuService {
    private final List<Dish> dishes;

    public MenuService(List<Dish> dishes) {
        this.dishes = new ArrayList<>(dishes);
    }

    public List<Dish> getMenu() {
        return new ArrayList<>(this.dishes);
    }

    public List<Dish> filterByCategory(String category) {
        return this.dishes.stream().filter(dish -> dish.category()
                .equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public List<Dish> filterByPriceRange(int lowerBound, int upperBound) {
        return this.dishes.stream()
                .filter(dish -> (dish.price() >= lowerBound && dish.price() <= upperBound))
                .collect(Collectors.toList());
    }

    public List<Dish> getDishByName(String name) {
        return this.dishes.stream().filter(dish -> dish.name().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
