package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommendation {

    public void recommend() {
        String randomCategory = Menu.getCategory(Randoms.pickNumberInRange(0, 4));

    }
}
