package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String rawInput = Console.readLine();
        return Arrays.stream(rawInput.split(","))
                .collect(Collectors.toList());
    }

    public List<String> readForbiddenMenuNames(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String rawInput = Console.readLine();
        if (rawInput.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(rawInput.split(","))
                .collect(Collectors.toList());
    }
}
