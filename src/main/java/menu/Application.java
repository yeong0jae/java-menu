package menu;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> inputNames = List.of("토미", "제임스", "포코");
        Coaches coaches = new Coaches(inputNames);

        for (int i = 0; i < coaches.getSize(); i++) {
            coaches.getCoachName(i);
            List<String> menus = List.of("우동", "스시");
            ForbiddenMenu forbiddenMenu = new ForbiddenMenu(menus);
            coaches.addForbiddenMenu(i, forbiddenMenu);
        }


    }
}
