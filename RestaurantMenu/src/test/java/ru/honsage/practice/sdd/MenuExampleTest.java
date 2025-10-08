package ru.honsage.practice.sdd;

import org.junit.Before;
import org.junit.Test;
import ru.honsage.practice.model.Dish;
import ru.honsage.practice.service.MenuService;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuExampleTest {
    private MenuService menuService;
    private Dish porridge;
    private Dish steak;
    private Dish carpaccio;
    private Dish fishSoup;
    private Dish coffee;
    private Dish juice;

    @Before
    public void setUp() {
        this.porridge = new Dish("Овсяная каша", "Каши", 60, "Каша из овсянки на молоке");
        this.steak = new Dish("Говяжий стейк", "Мясные блюда", 270, "Жареный стейк из говядины");
        this.carpaccio = new Dish("Карпаччо", "Закуски", 240, "Какое-то сырое мясо");
        this.fishSoup = new Dish("Уха", "Супы", 120, "Суп из рыбы с пшеном");
        this.coffee = new Dish("Американо", "Напитки", 80, "Кофе Американо");
        this.juice = new Dish("Апельсиновый сок", "Напитки", 100, "Свежевыжатый сок из апельсинов");
    }

    @Test
    public void filterByDrinkCategory() {
        List<Dish> dishes = Arrays.asList(fishSoup, coffee, juice);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.filterByCategory("Напитки");
        assertThat(result).containsExactly(coffee, juice).extracting(Dish::name).containsOnly("Американо", "Апельсиновый сок");
    }

    @Test
    public void filterByDessertCategory() {
        List<Dish> dishes = Arrays.asList(fishSoup, coffee, juice);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.filterByCategory("Десерт");
        assertThat(result).isEmpty();
    }

    @Test
    public void filterBySnackCategory() {
        List<Dish> dishes = Arrays.asList(steak, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.filterByCategory("Закуски");
        assertThat(result).containsExactly(carpaccio).extracting(Dish::name).containsOnly("Карпаччо");
    }

    @Test
    public void searchJuiceInMenu() {
        List<Dish> dishes = Arrays.asList(juice, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.getDishByName("апельсин");
        assertThat(result).hasSize(1).containsExactly(juice);
    }

    @Test
    public void searchAmericanoInMenu() {
        List<Dish> dishes = Arrays.asList(coffee, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.getDishByName("Америка");
        assertThat(result).hasSize(1).containsExactly(coffee);
    }

    @Test
    public void searchPorridgeInMenu() {
        List<Dish> dishes = Arrays.asList(porridge, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.getDishByName("КАША");
        assertThat(result).hasSize(1).containsExactly(porridge);
    }

    @Test
    public void searchFishSoupInMenu() {
        List<Dish> dishes = Arrays.asList(fishSoup, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.getDishByName("ха");
        assertThat(result).hasSize(1).containsExactly(fishSoup);
    }

    @Test
    public void searchSteakInMenu() {
        List<Dish> dishes = Arrays.asList(steak, carpaccio);
        this.menuService = new MenuService(dishes);

        List<Dish> result = this.menuService.getDishByName("Стейк");
        assertThat(result).hasSize(1).containsExactly(steak);
    }
}
