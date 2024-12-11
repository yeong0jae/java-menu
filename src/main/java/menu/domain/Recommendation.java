package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Recommendation {

    private RecommendedCategory recommendedCategory;

    public Recommendation(RecommendedCategory recommendedCategory) {
        this.recommendedCategory = recommendedCategory;
    }

    public void recommend(Coaches coaches) {
        String randomCategory = getRandomCategory();
        addRandomMenu(coaches, randomCategory);
    }

    private static void addRandomMenu(Coaches coaches, String randomCategory) {
        for (Coach coach : coaches.getCoaches()) {
            while (true) {
                List<String> menus = Menu.getMenusByCategory(randomCategory);
                String menu = Randoms.shuffle(menus).get(0);
                if (coach.isRecommendable(menu)) {
                    coach.addRecommendMenu(menu);
                    break;
                }
            }
        }
    }

    private String getRandomCategory() {
        String randomCategory;
        while (true) {
            randomCategory = Menu.getCategory(Randoms.pickNumberInRange(0, 4));
            if (recommendedCategory.isRecommendable(randomCategory)) {
                recommendedCategory.addCategory(randomCategory);
                break;
            }
        }
        return randomCategory;
    }

    public List<String> getRecommendedCategories() {
        return recommendedCategory.getCategories();
    }
}
