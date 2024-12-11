package menu;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.view.InputView;

public class MenuController {

    private final InputView inputView;

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> inputNames = inputView.readCoachNames();
        Coaches coaches = new Coaches(inputNames);

        for (Coach coach : coaches.getCoaches()) {
            List<String> menus = inputView.readForbiddenMenuNames(coach.getName());
            coach.addForbiddenMenu(menus);
        }

        Recommendation recommendation = new Recommendation();
        recommendation.recommend();

    }
}
