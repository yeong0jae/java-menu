package menu;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.coach.Coaches;
import menu.domain.recommendation.RecommendedCategory;
import menu.external.RandomNumberGenerator;
import menu.external.RandomShuffler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService = new RecommendService(
            new RecommendedCategory(), new RandomNumberGenerator(), new RandomShuffler());

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
                coach ->
                        retryUntilValid(() -> {
                            List<String> menus = inputView.readForbiddenMenuNames(coach.getName());
                            Menu.isIn(menus);
                            coach.createForbiddenMenu(menus);
                        })
        );
    }

    private List<String> recommend(Coaches coaches) {
        for (Day day : Day.values()) {
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

    private static void retryUntilValid(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
