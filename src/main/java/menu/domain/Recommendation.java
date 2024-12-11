package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommendation {

    private RecommendedCategory recommendedCategory;

    public void recommend() {

        // 카테고리 랜덤 추가
        while (true) {
            String randomCategory = Menu.getCategory(Randoms.pickNumberInRange(0, 4));
            if (recommendedCategory.isRecommendable(randomCategory)) {
                recommendedCategory.addCategory(randomCategory);
                break;
            }
        }


    }
}
