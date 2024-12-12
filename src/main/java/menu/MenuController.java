package menu;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.coach.Coaches;
import menu.domain.recommendation.RecommendedCategory;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService = new RecommendService(
            new RecommendedCategory());

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        Coaches coaches = retryUntilValid(this::createCoach);

        forbidMenu(coaches);

        List<String> recommendedCategories = recommend(coaches);
        outputView.printResult(coaches.getCoaches(), recommendedCategories);
    }

    private Coaches createCoach() {
        List<String> inputNames = inputView.readCoachNames();
        return new Coaches(inputNames);
    }

    private void forbidMenu(Coaches coaches) {
        coaches.getCoaches().forEach(
                coach -> {
                    while (true) {
                        List<String> menus = inputView.readForbiddenMenuNames(coach.getName());
                        if (Menu.isIn(menus)) {
                            coach.createForbiddenMenu(menus);
                            break;
                        }
                    }
                }
        );
    }

    private List<String> recommend(Coaches coaches) {
        List<String> days = Day.getDays();
        for (String day : days) {
            recommendService.recommend(coaches);
        }
        return recommendService.getRecommendedCategories();
    }

    private static <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
