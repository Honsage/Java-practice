package ru.honsage.practice.model;

public record Dish(String name,
                   String category,
                   int price,
                   String description) {

    @Override
    public String toString() {
        return String.format("Dish{name='%s', category='%s'}",
                this.name,
                this.category);
    }
}
