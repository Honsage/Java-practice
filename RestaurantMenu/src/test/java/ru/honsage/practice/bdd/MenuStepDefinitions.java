package ru.honsage.practice.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.honsage.practice.model.Dish;
import ru.honsage.practice.service.MenuService;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuStepDefinitions {
    private MenuService menuService;
    private List<Dish> searchResult;

    @Given("в меню загружены позиции 'Американо' и 'Апельсиновый сок' из категории 'Напитки'")
    public void menu_contains_americano_and_juice() {
        List<Dish> dishes = Arrays.asList(
                new Dish("Овсяная каша", "Каши", 60, "Каша из овсянки на молоке"),
                new Dish("Говяжий стейк", "Мясные блюда", 270, "Жареный стейк из говядины"),
                new Dish("Уха", "Супы", 120, "Суп из рыбы с пшеном"),
                new Dish("Американо", "Напитки", 80, "Кофе Американо"),
                new Dish("Апельсиновый сок", "Напитки", 100, "Свежевыжатый сок из апельсинов")
        );
        this.menuService = new MenuService(dishes);
        System.out.println("Шаг 'Given' выполнен: меню создано");
    }

    @When("я фильтрую меню по категории {string}")
    public void user_filters_menu_by_category(String category) {
        this.searchResult = menuService.filterByCategory(category);
        System.out.println("Шаг 'When' выполнен: выбрана категория '" + category + "'");
    }

    @Then("отображаются только напитки")
    public void only_drinks_are_presented() {
        assertThat(this.searchResult).isNotEmpty()
                .allSatisfy(dish -> assertThat(dish.category()).isEqualTo("Напитки"));
        System.out.println("Шаг 'Then' выполнен: отображены только напитки");
    }

    @Then("в списке есть позиции {string} и {string}")
    public void there_are_americano_and_juice_are_in_list(String expectedDish1, String expectedDish2) {
        assertThat(this.searchResult).extracting(Dish::name).containsExactly(expectedDish1, expectedDish2);
        System.out.println("Шаг 'And' выполнен: проверено наличие '" + expectedDish1 + "' и '" + expectedDish2 + "'");
    }

}
