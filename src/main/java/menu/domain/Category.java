package menu.domain;

import java.util.List;

public class Category {
    private String name;
    private List<String> foods;

    public Category(String name, List<String> foods) {
        this.name = name;
        this.foods = foods;
    }

    public void addFood(String name) {
        foods.add(name);
    }

    public String getName() {
        return name;
    }

    public Boolean findByName(String name) {
        int result = (int) foods.stream()
                .filter(food -> food.equals(name))
                .count();

        if (result != 0) {
            return true;
        }

        return false;
    }
}

