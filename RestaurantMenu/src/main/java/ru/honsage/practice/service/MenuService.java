package ru.honsage.practice.service;

import ru.honsage.practice.model.Dish;

import java.util.List;
import java.util.Optional;

public class MenuService {

    public MenuService(List<Dish> dishes) {}

    public List<Dish> filterByCategory(String category) { return null; }

    public List<Dish> filterByPriceRange(int lowerBound, int upperBound) { return null; }

    public Optional<Dish> getDishByName(String name) { return null; }
}
