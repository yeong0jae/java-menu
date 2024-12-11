package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Recommendation {

    private RecommendedCategory recommendedCategory;

    public void recommend(Coaches coaches) {

        // 카테고리 랜덤 하나 추가
        String randomCategory;
        while (true) {
            randomCategory = Menu.getCategory(Randoms.pickNumberInRange(0, 4));
            if (recommendedCategory.isRecommendable(randomCategory)) {
                recommendedCategory.addCategory(randomCategory);
                break;
            }
        }

        // 코치마다 메뉴 랜덤 추가
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
}
