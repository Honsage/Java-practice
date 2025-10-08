package ru.honsage.practice.model;

public record Dish(String name,
                   String category,
                   int price,
                   String description) {

    @Override
    public String toString() {
        return String.format("Dish {\n\tname='%s',\n\tcategory='%s',\n\tprice='%d',\n\tdescription='%s'\n}",
                this.name,
                this.category,
                this.price,
                this.description);
    }
}
