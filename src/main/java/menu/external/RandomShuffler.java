package menu.external;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.recommendation.Shuffler;

public class RandomShuffler implements Shuffler {

    @Override
    public String shuffle(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
