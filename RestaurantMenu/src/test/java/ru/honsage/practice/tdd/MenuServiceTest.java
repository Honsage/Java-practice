package ru.honsage.practice.tdd;

import org.junit.Before;
import org.junit.Test;
import ru.honsage.practice.model.Dish;
import ru.honsage.practice.service.MenuService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuServiceTest {
    private MenuService menuService;
    private Dish porridge;
    private Dish steak;
    private Dish fishSoup;
    private Dish coffee;
    private Dish juice;

    @Before
    public void setUp() {
        this.porridge = new Dish("Овсяная каша", "Каши", 60, "Каша из овсянки на молоке");
        this.steak = new Dish("Говяжий стейк", "Мясные блюда", 270, "Жареный стейк из говядины");
        this.fishSoup = new Dish("Уха", "Супы", 120, "Суп из рыбы с пшеном");
        this.coffee = new Dish("Американо", "Напитки", 80, "Кофе Американо");
        this.juice = new Dish("Апельсиновый сок", "Напитки", 100, "Свежевыжатый сок из апельсинов");

        List<Dish> sampleDishes = Arrays.asList(porridge, steak, fishSoup, coffee, juice);
        menuService = new MenuService(sampleDishes);
    }

    @Test
    public void testFilterByCategory() {
        List<Dish> result = this.menuService.filterByCategory("Напитки");
        assertThat(result).hasSize(2).containsExactly(coffee, juice);
    }

    @Test
    public void testGetByNameSuccess() {
        List<Dish> result = this.menuService.getDishByName("Овсяная каша");
        assertThat(result).hasSize(1).containsExactly(porridge);
        assertThat(result.getFirst()).isEqualTo(this.porridge);
    }

    @Test
    public void testGetByNameFailed() {
        List<Dish> result = this.menuService.getDishByName("Гречневая каша");
        assertThat(result).isEmpty();
    }

    @Test
    public void testFilterByPriceRange() {
        List<Dish> result = this.menuService.filterByPriceRange(70, 130);
        assertThat(result).hasSize(3).containsExactly(fishSoup, coffee, juice);
    }
}
