package ru.honsage.practice.atdd;

import org.junit.Before;
import org.junit.Test;
import ru.honsage.practice.model.Dish;
import ru.honsage.practice.service.MenuService;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class ScenariosTest {
    private MenuService menuService;

    @Before
    public void setUp() {
        List<Dish> sampleDishes = Arrays.asList(
            new Dish("Овсяная каша", "Каши", 60, "Каша из овсянки на молоке"),
            new Dish("Говяжий стейк", "Мясные блюда", 270, "Жареный стейк из говядины"),
            new Dish("Уха", "Супы", 120, "Суп из рыбы с пшеном"),
            new Dish("Американо", "Напитки", 80, "Кофе Американо"),
            new Dish("Апельсиновый сок", "Напитки", 100, "Свежевыжатый сок из апельсинов")
        );
        menuService = new MenuService(sampleDishes);
    }

    @Test // Сценарий 1
    public void testDishesByCategory() {
        List<Dish> result = menuService.filterByCategory("Напитки");
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Dish::category).containsOnly("Напитки");
        assertThat(result).extracting(Dish::name).containsExactly("Американо", "Апельсиновый сок");
    }

    @Test // Сценарий 2
    public void testNonexistingCategory() {
        List<Dish> result = menuService.filterByCategory("Десерты");
        assertThat(result).isEmpty();
    }

    @Test // Сценарий 3
    public void testSearchByPartOfName() {
        List<Dish> result = menuService.getDishByName("Каша");
        assertThat(result).hasSize(1);
        assertThat(result).extracting(Dish::name).containsExactly("Овсяная каша");
    }

    @Test // Сценарий 4
    public void testGetInfoAboutDish() {
        List<Dish> dishes = menuService.getDishByName("Говяжий стейк");
        assertThat(dishes).hasSize(1);
        String result = dishes.getFirst().toString();
        assertThat(result).contains("Говяжий стейк").contains("270").contains("Жареный стейк из говядины");
    }
}
