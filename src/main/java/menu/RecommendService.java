package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Menu;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.recommendation.RecommendedCategory;

public class RecommendService {

    private RecommendedCategory recommendedCategory;

    public RecommendService(RecommendedCategory recommendedCategory) {
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
