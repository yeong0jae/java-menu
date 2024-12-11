package menu.domain;

import java.util.Collections;
import java.util.List;

public class RecommendedCategory {

    public static final int MIN_CATEGORY_RECOMMEND_NUMBER = 2;

    private List<String> recommendedCategory;

    public RecommendedCategory(List<String> recommendedCategory) {
        this.recommendedCategory = recommendedCategory;
    }

    public boolean isRecommendable(String randomCategory) {
        if (Collections.frequency(recommendedCategory, randomCategory) > MIN_CATEGORY_RECOMMEND_NUMBER) {
            return false;
        }
        return true;
    }

    public void addCategory(String randomCategory) {
        recommendedCategory.add(randomCategory);
    }
}
