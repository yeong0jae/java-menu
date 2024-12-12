package menu;

import java.util.List;
import menu.domain.Menu;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.recommendation.NumberGenerator;
import menu.domain.recommendation.RecommendedCategory;
import menu.domain.recommendation.Shuffler;

public class RecommendService {

    private RecommendedCategory recommendedCategory;
    private NumberGenerator numberGenerator;
    private Shuffler shuffler;

    public RecommendService(RecommendedCategory recommendedCategory, NumberGenerator numberGenerator,
                            Shuffler shuffler) {
        this.recommendedCategory = recommendedCategory;
        this.numberGenerator = numberGenerator;
        this.shuffler = shuffler;
    }

    public void recommend(Coaches coaches) {
        String randomCategory = getRandomCategory();
        addRandomMenu(coaches, randomCategory);
    }

    private void addRandomMenu(Coaches coaches, String randomCategory) {
        for (Coach coach : coaches.getCoaches()) {
            while (true) {
                List<String> menus = Menu.getMenusByCategory(randomCategory);
                String menu = shuffler.shuffle(menus);
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
            randomCategory = Menu.getCategory(numberGenerator.generate());
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
