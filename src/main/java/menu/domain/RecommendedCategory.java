package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendedCategory {

    public static final int MIN_CATEGORY_RECOMMEND_NUMBER = 2;

    private List<String> categories = new ArrayList<>();

    public boolean isRecommendable(String randomCategory) {
        return Collections.frequency(categories, randomCategory) <= MIN_CATEGORY_RECOMMEND_NUMBER;
    }

    public void addCategory(String randomCategory) {
        categories.add(randomCategory);
    }

    public List<String> getCategories() {
        return categories;
    }
}
