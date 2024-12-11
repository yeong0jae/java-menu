package menu;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        List<String> inputNames = inputView.readCoachNames();
        Coaches coaches = new Coaches(inputNames);

        for (Coach coach : coaches.getCoaches()) {
            List<String> menus = inputView.readForbiddenMenuNames(coach.getName());
            coach.addForbiddenMenu(menus);
        }

        Recommendation recommendation = new Recommendation();

        List<String> days = Day.getDays();
        for (String day : days) {
            recommendation.recommend(coaches);
        }

        outputView.printResult(coaches.getCoaches(), recommendation.getRecommendedCategories());
    }
}
