package menu;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Recommendation;
import menu.domain.RecommendedCategory;
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

        Coaches coaches = createCoach();
        forbidMenu(coaches);

        Recommendation recommendation = recommend(coaches);
        outputView.printResult(coaches.getCoaches(), recommendation.getRecommendedCategories());
    }

    private Recommendation recommend(Coaches coaches) {
        RecommendedCategory recommendedCategory = new RecommendedCategory();
        Recommendation recommendation = new Recommendation(recommendedCategory);

        List<String> days = Day.getDays();
        for (String day : days) {
            recommendation.recommend(coaches);
        }
        return recommendation;
    }

    private void forbidMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> menus = inputView.readForbiddenMenuNames(coach.getName());
            coach.addForbiddenMenu(menus);
        }
    }

    private Coaches createCoach() {
        List<String> inputNames = inputView.readCoachNames();
        return new Coaches(inputNames);
    }

}
