package menu.view;

import camp.nextstep.edu.missionutils.Console;
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
}
