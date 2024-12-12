package menu.external;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.recommendation.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
